package com.example.demo.auth.authService;


import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Security.JwtService;
import com.example.demo.model.AffectationVoiture;
import com.example.demo.model.Photo;
//import com.example.demo.model.Personne;
import com.example.demo.model.Profile;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.AffectationVoitureRepository;
import com.example.demo.repository.PhotoRepository;
//import com.example.demo.repository.PersonneRepo;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepo;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {
  private final ProfileRepository personRepo;
  private final UserRepo userRepo;
  private final AffectationVoitureRepository afRepo;
  private final PhotoRepository pRepo;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public ResponseEntity<?> register(Profile request) {

    var user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        //.role(request.getRole())
        .role(Role.ROLE_CHAUFFEUR)
        .build();
    request.setUser(user);
    request.setRole(Role.ROLE_CHAUFFEUR);
    userRepo.save(user);
    request.setRole(user.getRole());
    personRepo.save(request);

    var jwtToken = jwtService.generateToken(user);
    return ResponseEntity.ok(AuthenticationResponse.builder().token(jwtToken).build());
  }
  
  public ResponseEntity<?> registerAdmin(Profile request, MultipartFile file) throws IOException  {

	    var user = User.builder()
	        .username(request.getUsername())
	        .password(passwordEncoder.encode(request.getPassword()))
	        .role(Role.ROLE_ADMIN)
	        //.role(Role.ROLE_CHAUFFEUR)
	        .build();
	    Photo photo = Photo.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.imageData(ImageEncoder.compressImage(file.getBytes())).build();
		photo = pRepo.save(photo);
	    request.setUser(user);
	    request.setRole(user.getRole());
	    userRepo.save(user);
	    request.setPhoto(photo);
	    personRepo.save(request);

	    var jwtToken = jwtService.generateToken(user);
	    return ResponseEntity.ok(AuthenticationResponseAdmin.builder().token(jwtToken).build());
	  }

  public ResponseEntity<?> authenticate(AuthenticationRequest request) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              request.getUsername(),
              request.getPassword()));

    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(403).body("Wrong username or password!");
    }

    var user = userRepo.findUserByUsername(request.getUsername())
        .orElseThrow(() -> new IllegalStateException("Something went wrong!"));
   

    var jwtToken = jwtService.generateToken(user);
    return ResponseEntity.ok(AuthenticationResponse.builder().token(jwtToken)

    		.username(user.getUsername())
    		.idConducteur(personRepo.findByUsername(user.getUsername()).get().getChauffeur().getIdConducteur())
    		.idPhoto(personRepo.findByUsername(user.getUsername()).get().getPhoto().getPhoto_id())
    		.idAffectations(afRepo.getIdconducteurFromAffectation(personRepo.findByUsername(user.getUsername()).get().getChauffeur().getIdConducteur()))
    		.idVoiture(afRepo.getIdVoitureFromAffectation(personRepo.findByUsername(user.getUsername()).get().getChauffeur().getIdConducteur()))
    		.build());
  }
  
  public ResponseEntity<?> authenticateAdmin(AuthenticationRequest request) {
	    try {
	      authenticationManager.authenticate(
	          new UsernamePasswordAuthenticationToken(
	              request.getUsername(),
	              request.getPassword()));

	    } catch (BadCredentialsException ex) {
	      return ResponseEntity.status(403).body("Wrong username or password!");
	    }

	    var user = userRepo.findUserByUsername(request.getUsername())
	        .orElseThrow(() -> new IllegalStateException("Something went wrong!"));
	    if (user.getRole().equals(Role.ROLE_CHAUFFEUR)) {
	        throw new BadCredentialsException("Admin access required");
	    }
	    var jwtToken = jwtService.generateToken(user);
	    return ResponseEntity.ok(AuthenticationResponseAdmin.builder().token(jwtToken)
	    		.username(user.getUsername())
	    		.idPhoto(personRepo.findByUsername(user.getUsername()).get().getPhoto().getPhoto_id())
	    		.build());
	  }


}
