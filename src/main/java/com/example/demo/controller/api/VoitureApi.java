package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.VoitureDTO;
import com.example.demo.model.Voiture;

import jakarta.validation.Valid;

public interface VoitureApi {
//	@GetMapping(value=APP_ROOT+"/Voiture/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<VoitureDTO> getAllVoiture();
//	@GetMapping(value=APP_ROOT+"/Voiture/{idVoiture}",produces=MediaType.APPLICATION_JSON_VALUE)
//	VoitureDTO getVoitureById(@PathVariable("idVoiture")@Valid Long id);
//	 @PostMapping(value= APP_ROOT+"/Voiture/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	 VoitureDTO addVoiture(@Valid @RequestBody VoitureDTO voitureDTO);
//	 @PutMapping(value= APP_ROOT+"/Voiture/update/{idVoiture}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	 VoitureDTO updateVoiture(@Valid @PathVariable("idVoiture") Long id,@Valid @RequestBody  VoitureDTO voitureDTO);
//	 @DeleteMapping(value=APP_ROOT+"/Voiture/delete/{idVoiture}")
//	void deleteVoiture(@PathVariable("idVoiture")@Valid Long id);
	
	
	
	
	@GetMapping(value=APP_ROOT+"/Voiture/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Voiture> getAllVoiture();
	@GetMapping(value=APP_ROOT+"/Voiture/not/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Voiture> getNotVoiture();
	@GetMapping(value=APP_ROOT+"/Voiture/{idVoiture}",produces=MediaType.APPLICATION_JSON_VALUE)
	Voiture getVoitureById(@PathVariable("idVoiture")@Valid Long id);
	 @PostMapping(value= APP_ROOT+"/Voiture/create")
	 Voiture addVoiture(@Valid  Voiture voiture,MultipartFile file) throws IOException;
	 @PutMapping(value= APP_ROOT+"/Voiture/update/{idVoiture}",produces=MediaType.APPLICATION_JSON_VALUE)
	 Voiture updateVoiture( @PathVariable("idVoiture") Long id,  Voiture voiture,MultipartFile file) throws IOException;
	 @DeleteMapping(value=APP_ROOT+"/Voiture/delete/{idVoiture}")
	void deleteVoiture(@PathVariable("idVoiture")@Valid Long id);
	    
	    
	    
		 
		  
	
	}