package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.ChauffeurDTO;
import com.example.demo.model.Chauffeur;
import com.example.demo.model.Profile;
import com.example.demo.model.Voiture;

import jakarta.validation.Valid;
@Validated
public interface ChauffeurApi {
//	@GetMapping(value=APP_ROOT+"/chauffeur/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<ChauffeurDTO> getAllChauffeurs();
//	
//	@GetMapping(value=APP_ROOT+"/chauffeur/{idChauffeur}",produces=MediaType.APPLICATION_JSON_VALUE)
//	ChauffeurDTO getChauffeurById(@PathVariable("idChauffeur")@Valid Long id);
//	
//	@PostMapping(value= APP_ROOT+"/chauffeur/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	ChauffeurDTO addChauffeurs(@Valid @RequestBody ChauffeurDTO ChauffeurDTO);
//	
//	@PutMapping(value= APP_ROOT+"/chauffeur/update/{idChauffeur}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	ChauffeurDTO updateChauffeur(@Valid @PathVariable("idChauffeur") Long id,@Valid @RequestBody ChauffeurDTO ChauffeurDTO);
//	
//	@DeleteMapping(value=APP_ROOT+"/chauffeur/delete/{idChauffeur}")
//	void deleteChauffeur(@PathVariable("idChauffeur")@Valid Long id);
	
	
	@GetMapping(value=APP_ROOT+"/chauffeur/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getAllChauffeurs();
	@GetMapping(value=APP_ROOT+"/chauffeur/check/{id}")
	boolean checkChauffeur(@PathVariable("id") Long id);
	
	@GetMapping(value=APP_ROOT+"/chauffeur/checkChauffeur/stillThere/{id1}")
	boolean checkChauffeurStillThere(@PathVariable("id1") Long id);
	
	@GetMapping(value=APP_ROOT+"/chauffeur/not/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getNotChauffeur();
	
	@GetMapping(value=APP_ROOT+"/chauffeur/{idChauffeur}",produces=MediaType.APPLICATION_JSON_VALUE)
	Chauffeur getChauffeurById(@PathVariable("idChauffeur")@Valid Long id);
	
//	@PostMapping(value= APP_ROOT+"/chauffeur/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	Chauffeur addChauffeurs(@Valid @RequestBody Chauffeur chauffeur);
	
	@PutMapping(value= APP_ROOT+"/chauffeur/update/{idChauffeur}")
	Chauffeur updateChauffeur(@Valid @PathVariable("idChauffeur") Long id,@Valid  Chauffeur chauffeur, MultipartFile file) throws IOException;
	
	@DeleteMapping(value=APP_ROOT+"/chauffeur/delete/{idChauffeur}")
	void deleteChauffeur(@PathVariable("idChauffeur")@Valid Long id);
	
	
	 @PostMapping(value= APP_ROOT+"/chauffeur/create/img")
	 ResponseEntity<?> saveProfile(Chauffeur chauffeur, MultipartFile file) throws IOException;
	    
	
	}