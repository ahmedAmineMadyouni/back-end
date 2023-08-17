package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;
import static com.example.demo.utils.Constants.APP_ROOT2;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.ProfileDTO;
import com.example.demo.model.Profile;

import jakarta.validation.Valid;

public interface ProfileApi {
//	@GetMapping(value=APP_ROOT+"/Profile/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<ProfileDTO> getAllProfile();
//	@GetMapping(value=APP_ROOT+"/Profile/{idProfile}",produces=MediaType.APPLICATION_JSON_VALUE)
//	ProfileDTO getProfileById(@PathVariable("idProfile")@Valid Long id);
//	 @PostMapping(value= APP_ROOT+"/Profile/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	ProfileDTO addProfile(@Valid @RequestBody ProfileDTO ProfileDTO);
//	 @PutMapping(value= APP_ROOT+"/Profile/update/{idProfile}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	ProfileDTO updateProfile(@Valid @PathVariable("idProfile") Long id,@Valid @RequestBody  ProfileDTO ProfileDTO);
//	 @DeleteMapping(value=APP_ROOT+"/Profile/delete/{idProfile}")
//	void deleteProfile(@PathVariable("idProfile")@Valid Long id);

	
	
	
	@GetMapping(value=APP_ROOT+"/Profile/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Profile> getAllProfile();
	@GetMapping(value=APP_ROOT+"/Profile/{idProfile}",produces=MediaType.APPLICATION_JSON_VALUE)
	Profile getProfileById(@PathVariable("idProfile")@Valid Long id);
	 @PostMapping(value= APP_ROOT+"/Profile/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	 Profile addProfile(@Valid @RequestBody Profile profile);
	 @PutMapping(value= APP_ROOT+"/Profile/update/{idProfile}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	 Profile updateProfile(@Valid @PathVariable("idProfile") Long id,@Valid @RequestBody  Profile profile);
	 @DeleteMapping(value=APP_ROOT+"/Profile/delete/{idProfile}")
	void deleteProfile(@PathVariable("idProfile")@Valid Long id);
	 @GetMapping(value=APP_ROOT2+"/Profile/user/{username}",produces=MediaType.APPLICATION_JSON_VALUE)
		Profile getProfileByUsername(@PathVariable("username") String username);
	 
	 
//	 @PostMapping(value= APP_ROOT+"/Profile/create/img")
//	 ResponseEntity<String> saveProfile(Profile profile, MultipartFile file) throws IOException;
	    
	    
	    
		 
		  
	
	}