package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;
import static com.example.demo.utils.Constants.APP_ROOT2;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.DemandeEntretien;
//import com.example.demo.dto.AmendesDTO;
//import com.example.demo.dto.EntretienDTO;
import com.example.demo.model.Entretien;

import jakarta.validation.Valid;

public interface EntretienApi {
//	@GetMapping(value=APP_ROOT+"/Entretien/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<EntretienDTO> getAllEntretiens();
//	 @GetMapping(value=APP_ROOT+"/Entretien/{idEntretien}",produces=MediaType.APPLICATION_JSON_VALUE)
//    EntretienDTO getEntretienById(@PathVariable("idAccident")@Valid Long id);
//    @PostMapping(value= APP_ROOT+"/Entretien/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    EntretienDTO addEntretien(@Valid @RequestBody EntretienDTO EntretienDTO);
//    @PutMapping(value= APP_ROOT+"/Entretien/update/{idEntretien}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    EntretienDTO updateEntretien(@Valid @PathVariable("idEntretien") Long id,@Valid @RequestBody EntretienDTO EntretienDTO);
//    @DeleteMapping(value=APP_ROOT+"/Entretien/delete/{idEntretien}")
//    void deleteEntretien(@PathVariable("idEntretien")@Valid Long id);
	
	
	
	
	@GetMapping(value=APP_ROOT+"/Entretien/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getAllEntretiens();
	
	@GetMapping(value=APP_ROOT+"/Entretien/check/Voiture/{id}")
	boolean chachVoitureStillThereById(@PathVariable("id")@Valid Long id);
	 
	@GetMapping(value=APP_ROOT+"/Entretien/{idEntretien}",produces=MediaType.APPLICATION_JSON_VALUE)
	Entretien getEntretienById(@PathVariable("idEntretien")@Valid Long id);
	
	@GetMapping(value=APP_ROOT2+"/Entretien/chauffeur/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getEntretienByIdConducteur(@PathVariable("id")@Valid Long id);
    
	@PostMapping(value= APP_ROOT+"/Entretien/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    Entretien addEntretien(@Valid @RequestBody Entretien entretien);
    
	@PostMapping(value= APP_ROOT+"/Entretien/create/fromdemande/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    Entretien validateDemandeEntretien(@Valid @PathVariable("id") Long id);
	
    @PutMapping(value= APP_ROOT+"/Entretien/update/{idEntretien}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    Entretien updateEntretien(@Valid @PathVariable("idEntretien") Long id,@Valid @RequestBody Entretien entretien);
    
    @DeleteMapping(value=APP_ROOT+"/Entretien/delete/{idEntretien}")
    void deleteEntretien(@PathVariable("idEntretien")@Valid Long id);
    
    
    
   
  
    
 
    
 

}
