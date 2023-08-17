package com.example.demo.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.ProfileDTO;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.Photo;
import com.example.demo.model.Profile;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.profileService;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfileServiceImpl implements profileService {
	@Autowired
	private final ProfileRepository pRepo;
	@Autowired
	private PhotoRepository  phRepo;
	
	public ProfileServiceImpl(ProfileRepository pRepo) {

		this.pRepo=pRepo;
	}
	


	@Override
	public List<Profile> getAllProfile() {
		
//		return pRepo.findAll().stream().map(ProfileDTO::fromEntity).collect(Collectors.toList());
		return pRepo.findAll();
	}

	@Override
	public Profile getProfileById(Long id) {
		 Optional<Profile> optionalProfile = pRepo.findById(id);
		 if(optionalProfile.isPresent()) {
//				return  ProfileDTO.fromEntity(optionalProfile.get()); 
			 return  optionalProfile.get(); 
		 }else {
			 
			 throw new EntityNotFoundException("profile not found",ErrorCodes.PROFILE_NOT_FOUND);
		 }
		
	}

	@Override
	public Profile addProfile(Profile profile) {
		 if (pRepo.existsByEmail(profile.getEmail())) {
	            throw new EntityAlreadyExistsException("Profile already exists",ErrorCodes.PROFILE_ALREADY_EXIST);
	        }else {
		
//		return ProfileDTO.fromEntity(pRepo.save(ProfileDTO.toEntity(profileDto)));
	        	return pRepo.save(profile);
		}
	}

	@Override
	public Profile updateProfile(Long id, Profile profile) {
		// TODO Auto-generated method stub
		if(pRepo.existsByEmail(profile.getEmail())) {
			throw new EntityAlreadyExistsException("Profile already exists",ErrorCodes.PROFILE_ALREADY_EXIST);
		}else {
		Optional<Profile> optionalProfile =pRepo.findById(id);
		if(optionalProfile.isPresent()) {
			Profile opProfile = optionalProfile.get();
			opProfile.setFirstName(profile.getFirstName());
			opProfile.setLastName(profile.getLastName());
			opProfile.setEmail(profile.getEmail());
//	             // set the password attribute
//	           return ProfileDTO.fromEntity(pRepo.save(profile));
	            return pRepo.save(opProfile);
		}else {
			throw new EntityNotFoundException("profile not found",ErrorCodes.PROFILE_NOT_FOUND);
		}
		}
	}

	@Override
	public void deleteProfile(Long id) {
		// TODO Auto-generated method stub
		if(pRepo.existsById(id)) {
			pRepo.deleteById(id);
		}else {
			throw new EntityNotFoundException("profile not found",ErrorCodes.PROFILE_NOT_FOUND);
		}
	}



	@Override
	public Profile getProfileByUsername(String username) {
		Optional<Profile> optionalProfile = pRepo.findByUsername(username);
		 if(optionalProfile.isPresent()) {
//				return  ProfileDTO.fromEntity(optionalProfile.get()); 
			 return  optionalProfile.get(); 
		 }else {
			 
			 throw new EntityNotFoundException("profile not found",ErrorCodes.PROFILE_NOT_FOUND);
		 }
	}
	
	
	

}
