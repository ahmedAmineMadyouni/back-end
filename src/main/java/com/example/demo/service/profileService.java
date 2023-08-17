package com.example.demo.service;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.ProfileDTO;
import com.example.demo.model.Profile;

public interface profileService {
//    List<ProfileDTO> getAllProfile();
//
//    ProfileDTO getProfileById(Long id);
//
//    ProfileDTO addProfile(ProfileDTO ProfileDTO);
//
//    ProfileDTO updateProfile(Long id, ProfileDTO ProfileDTO);
//
//    void deleteProfile(Long id);
	
    List<Profile> getAllProfile();

    Profile getProfileById(Long id);
    
    Profile getProfileByUsername(String username);

    Profile addProfile(Profile profile);

    Profile updateProfile(Long id, Profile profile);

    void deleteProfile(Long id);

	
}