package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Security.JwtService;
import com.example.demo.auth.authService.AuthenticationService;
//
//import com.example.demo.dto.AccidentDTO;
//import com.example.demo.dto.AdresseDTO;
//import com.example.demo.dto.AffectationVoitureDTO;
//import com.example.demo.dto.AmendesDTO;
//import com.example.demo.dto.ChauffeurDTO;
//import com.example.demo.dto.MissionDTO;
//import com.example.demo.dto.ProfileDTO;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.Chauffeur;
import com.example.demo.model.Photo;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.model.Voiture;
import com.example.demo.repository.ChauffeurRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.chauffeurService;
import com.example.demo.service.profileService;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class ChauffeurServiceImpl implements chauffeurService {
	@Autowired
	 private  ChauffeurRepository cRepo;
	@Autowired
	private PhotoRepository pRepo;
	@Autowired
	private ProfileRepository prRepo;
	@Autowired
	private UserRepo uRepo;
	@Autowired
	 private AuthenticationService authService;
	@Autowired
	 private final PasswordEncoder passwordEncoder;
	
	
	

	@Override
	public List<?> getAllChauffeurs() {
		// TODO Auto-generated method stub
//		return cRepo.findAll().stream().map(ChauffeurDTO::fromEntity).collect(Collectors.toList());
		List<Chauffeur> chauffeurs = cRepo.findAll();
		List<ChauffeurDTO> chauffeurDTOs = new ArrayList<>();

		for (Chauffeur chauffeur : chauffeurs) {
		    ChauffeurDTO chauffeurDTO = new ChauffeurDTO();
		    chauffeurDTO.setIdConducteur(chauffeur.getIdConducteur());
		    chauffeurDTO.setNom(chauffeur.getNom());
		    chauffeurDTO.setPrenom(chauffeur.getPrenom());
		    chauffeurDTO.setAdresse(chauffeur.getAdresse());
		    chauffeurDTO.setEmail(chauffeur.getEmail());
		    chauffeurDTO.setNumCIN(chauffeur.getNumCIN());
		    chauffeurDTO.setNumCNSS(chauffeur.getNumCNSS());
		    chauffeurDTO.setNumTelephone(chauffeur.getNumTelephone());
		    chauffeurDTO.setIdProfile(chauffeur.getProfile().getProfile_id());
		    chauffeurDTO.setUsername(chauffeur.getProfile().getUsername());
		    chauffeurDTO.setPhoto(chauffeur.getPhoto().getPhoto_id());
		    chauffeurDTO.setPhotoName(chauffeur.getPhoto().getName());
		    chauffeurDTO.setPassword(chauffeur.getPassword());
		    
		    chauffeurDTOs.add(chauffeurDTO);
		}

		return chauffeurDTOs;

	//	return cRepo.findAll();
	}

	@Override
	public Chauffeur getChauffeurById(Long id) {
		// TODO Auto-generated method stub
		Optional<Chauffeur> optionalchauffeur = cRepo.findById(id);
		if (optionalchauffeur.isPresent()) {
//			return ChauffeurDTO.fromEntity(optionalchauffeur.get());
			return optionalchauffeur.get();
			
		} else {

			throw new EntityNotFoundException("chauffeur not found", ErrorCodes.CHAUFFEUR_NOT_FOUND);
		}
	}


	@Override
	public Chauffeur updateChauffeur(Long id, Chauffeur chauffeur,MultipartFile file) throws IOException {

		
		Chauffeur x=cRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("chauffeur not found ",ErrorCodes.CHAUFFEUR_NOT_FOUND));	
		Profile prof=prRepo.findById(x.getProfile().getProfile_id()).orElseThrow(()-> new EntityNotFoundException("profile not found ",ErrorCodes.PROFILE_NOT_FOUND));
		if (file != null && !file.isEmpty()) {
		 
			Optional<Photo> newPhoto = pRepo.findById(x.getPhoto().getPhoto_id());
			 if ( newPhoto.isPresent() || !newPhoto.get().getType().equals(file.getContentType()) ||
		                !Arrays.equals(newPhoto.get().getImageData(), file.getBytes())) {
				 newPhoto.get().setImageData(ImageEncoder.compressImage(file.getBytes()));
		        	newPhoto.get().setName(file.getOriginalFilename());
		        	newPhoto.get().setType(file.getContentType());
		        	prof.setPhoto(pRepo.save(newPhoto.get()));
		        	x.setPhoto(pRepo.save(newPhoto.get()));
			 } 
		}
		
		
				
				x.setNom(chauffeur.getNom());
				x.setPrenom(chauffeur.getPrenom());
				prof.setFirstName(chauffeur.getNom());
				prof.setLastName(chauffeur.getPrenom());
				x.setAdresse(chauffeur.getAdresse());
				x.setNumCIN(chauffeur.getNumCIN());
				x.setNumCNSS(chauffeur.getNumCNSS());
				x.setNumTelephone(chauffeur.getNumTelephone());
				//x.setAffectationVoiture(chauffeur.getAffectationVoiture());
				x.setEmail(chauffeur.getEmail());
				prof.setEmail(chauffeur.getEmail());
				if(x.getPassword().equals(chauffeur.getPassword())) {
					
				}else {
				x.setPassword(chauffeur.getPassword());
				User y=uRepo.findById(x.getProfile().getUser().getId_user()).orElseThrow(()->
				new EntityNotFoundException("",ErrorCodes.CHAUFFEUR_NOT_FOUND));
				y.setPassword(passwordEncoder.encode(chauffeur.getPassword()));
				uRepo.save(y);
				prof.setPassword(chauffeur.getPassword());
				}	
				x.setProfile(prRepo.save(prof));
//				opChauffeur.setProfile(chauffeur.getProfile());
////				opChauffeur.setAffectationVoiture(chauffeur.get);
//				opChauffeur.setAccident(chauffeur.getAccident();
//				opChauffeur.setAmendes(chauffeurDto.getAmendesDto().stream().map(AmendesDTO::toEntity).collect(Collectors.toList()));
//				opChauffeur.setMission(chauffeurDto.getMissionDto().stream().map(MissionDTO::toEntity).collect(Collectors.toList()));
//				return ChauffeurDTO.fromEntity(cRepo.save(opChauffeur));
				return  cRepo.save(x);
			
	}

	@Override
	public void deleteChauffeur(Long id) {
		// TODO Auto-generated method stub
		if (cRepo.existsById(id)&&!cRepo.isChauffeurInDemandeEntretienInProgressAndMission(id)) {
			cRepo.deleteById(id);
		} else {
			throw new EntityNotFoundException("chauffeurs not found or is in INprogres mision or entretien ", ErrorCodes.CHAUFFEUR_NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> saveProfile(Chauffeur chauffeur, MultipartFile file) throws IOException {

		Photo photo = Photo.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.imageData(ImageEncoder.compressImage(file.getBytes())).build();
		photo = pRepo.save(photo);
		chauffeur.setPhoto(photo);
		Profile profile= Profile.builder().firstName(chauffeur.getNom())
				.email(chauffeur.getEmail())
				.lastName(chauffeur.getPrenom())
				.password(chauffeur.getPassword())
				.photo(photo)
				//.role(chauffeur.getRole())
				.username(chauffeur.getNom()+chauffeur.getPrenom()+chauffeur.getIdConducteur())
				.chauffeur(chauffeur)
				.build();
		chauffeur.setProfile(profile);
		cRepo.save(chauffeur);
			   
		return authService.register(profile);
	}

	//TODO implement  a DTO conversion here 
	@Override
	public List<?> getNOTaffected() {
		List<Chauffeur> chauffeurs = cRepo.getNotAffectedChauffeur();
		List<ChauffeurDTO> chauffeurDTOs = new ArrayList<>();

		for (Chauffeur chauffeur : chauffeurs) {
		    ChauffeurDTO chauffeurDTO = new ChauffeurDTO();
		    chauffeurDTO.setIdConducteur(chauffeur.getIdConducteur());
		    chauffeurDTO.setNom(chauffeur.getNom());
		    chauffeurDTO.setPrenom(chauffeur.getPrenom());
		    chauffeurDTO.setAdresse(chauffeur.getAdresse());
		    chauffeurDTO.setEmail(chauffeur.getEmail());
		    chauffeurDTO.setNumCIN(chauffeur.getNumCIN());
		    chauffeurDTO.setNumCNSS(chauffeur.getNumCNSS());
		    chauffeurDTO.setNumTelephone(chauffeur.getNumTelephone());
		    chauffeurDTO.setIdProfile(chauffeur.getProfile().getProfile_id());
		    chauffeurDTO.setUsername(chauffeur.getProfile().getUsername());
		    chauffeurDTO.setPhoto(chauffeur.getPhoto().getPhoto_id());
		    chauffeurDTO.setPhotoName(chauffeur.getPhoto().getName());
		    chauffeurDTO.setPassword(chauffeur.getPassword());
		    
		    chauffeurDTOs.add(chauffeurDTO);
		}

		return chauffeurDTOs;
		//return cRepo.getNotAffectedChauffeur();
	}

	@Override
	public boolean checkChauffeur(Long id) {
		// TODO Auto-generated method stub
		return cRepo.isChauffeurInDemandeEntretienInProgressAndMission(id);
	}

	@Override
	public boolean checkChauffeurStillThere(Long id) {
		// TODO Auto-generated method stub
		return cRepo.existsById(id);
	}
	
	
	
		

		//return //ResponseEntity.status(HttpStatus.OK).body("Profile saved successfully with image: " + file.getOriginalFilename());

		
//		@Override
//		public Chauffeur addChauffeurs(Chauffeur chauffeur) {
//			
//			if (cRepo.existsByNumCIN(chauffeur.getNumCIN())) {
//				throw new EntityAlreadyExistsException("chauffeurs already exists");
//			} else {
//				// TODO Auto-generated method stub
////				return ChauffeurDTO.fromEntity(cRepo.save(ChauffeurDTO.toEntity(chauffeurDto)));
//				return cRepo.save(chauffeur);
//			}
//		}
	

}
