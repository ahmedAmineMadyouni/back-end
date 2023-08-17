package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.api.ProfileApi;
//import com.example.demo.dto.ProfileDTO;
import com.example.demo.model.Profile;
import com.example.demo.service.profileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@Validated
public class ProfileController implements ProfileApi{
 private profileService ps;
@Autowired
public ProfileController(profileService ps) {
	this.ps = ps;
}

@Override
public List<Profile> getAllProfile() {
	// TODO Auto-generated method stub
	return ps.getAllProfile();
}

@Override
public Profile getProfileById(@Valid Long id) {
	// TODO Auto-generated method stub
	return ps.getProfileById(id);
}

@Override
public Profile addProfile(@Valid Profile Profile) {
	// TODO Auto-generated method stub
	return ps.addProfile(Profile);
}

@Override
public Profile updateProfile(@Valid Long id, @Valid Profile Profile) {
	// TODO Auto-generated method stub
	return ps.updateProfile(id, Profile);
}

@Override
public void deleteProfile(@Valid Long id) {
	ps.deleteProfile(id);
}

@Override
public Profile getProfileByUsername(String username) {
	// TODO Auto-generated method stub
	return ps.getProfileByUsername(username);
}



//@Override
//public ResponseEntity<String> saveProfile(Profile profile, MultipartFile file) throws IOException {
//	// TODO Auto-generated method stub
//	return ps.saveProfile(profile, file);
//}
}
