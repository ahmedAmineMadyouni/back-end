package com.example.demo.controller;

import static com.example.demo.utils.Constants.APP_ROOT;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.api.ChauffeurApi;
//import com.example.demo.dto.ChauffeurDTO;
import com.example.demo.model.Chauffeur;
import com.example.demo.service.chauffeurService;
//import com.example.demo.utils.*;
import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class ChauffeurController implements ChauffeurApi{
	
	private chauffeurService cs;
	//@Autowired
	public ChauffeurController(chauffeurService cs) {
		this.cs = cs;
	}
	
	@Override
	public List<?> getAllChauffeurs() {
		// TODO Auto-generated method stub
		return cs.getAllChauffeurs();
	}
	
	@Override
	public Chauffeur getChauffeurById(@Valid Long id) {
		// TODO Auto-generated method stub
		return cs.getChauffeurById(id);
	}
	
//	@Override
//	public Chauffeur addChauffeurs(@Valid Chauffeur chauffeur) {
//		// TODO Auto-generated method stub
//		return cs.addChauffeurs(chauffeur);
//	}
	
	@Override
	public Chauffeur updateChauffeur(@Valid Long id, @Valid Chauffeur chauffeur, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return cs.updateChauffeur(id, chauffeur,file);
	}
	
	@Override
	public void deleteChauffeur(@Valid Long id) {
		cs.deleteChauffeur(id);
		
	}

	@Override
	public ResponseEntity<?> saveProfile(Chauffeur chauffeur, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return cs.saveProfile(chauffeur, file);
	}

	@Override
	public List<?> getNotChauffeur() {
		// TODO Auto-generated method stub
		return cs.getNOTaffected();
	}

	@Override
	public boolean checkChauffeur(Long id) {
		// TODO Auto-generated method stub
		return cs.checkChauffeur(id);
	}

	@Override
	public boolean checkChauffeurStillThere(Long id) {
		// TODO Auto-generated method stub
		return cs.checkChauffeurStillThere(id);
	}
}
