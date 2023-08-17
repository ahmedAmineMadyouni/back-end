package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import com.example.demo.dto.FournisseurDTO;
import com.example.demo.model.Fournisseur;

import jakarta.validation.Valid;

public interface FournisseurApi {
//	@GetMapping(value=APP_ROOT+"/Fournisseur/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<FournisseurDTO> getAllFournisseur();
//	@GetMapping(value=APP_ROOT+"/Fournisseur/{idFournisseur}",produces=MediaType.APPLICATION_JSON_VALUE)
//	FournisseurDTO getFournisseurById(@PathVariable("idFournisseur")@Valid Long id);
//	@PostMapping(value= APP_ROOT+"/Fournisseur/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	FournisseurDTO addFournisseur(@Valid @RequestBody FournisseurDTO FournisseurDTO);
//	@PutMapping(value= APP_ROOT+"/Fournisseur/update/{idFournisseur}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	FournisseurDTO updateFournisseur(@Valid @PathVariable("idFournisseur") Long id,@Valid @RequestBody FournisseurDTO FournisseurDTO);
//	 @DeleteMapping(value=APP_ROOT+"/Fournisseur/delete/{idFournisseur}")
//	void deleteFournisseur(@PathVariable("idFournisseur")@Valid Long id);   
	 
	 
	@GetMapping(value=APP_ROOT+"/Fournisseur/all")
	List<Fournisseur> getAllFournisseur();
	@GetMapping(value=APP_ROOT+"/Fournisseur/by/entretien/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	boolean checkFournisseur(@PathVariable("id") Long id);
	@GetMapping(value=APP_ROOT+"/Fournisseur/{idFournisseur}",produces=MediaType.APPLICATION_JSON_VALUE)
	Fournisseur getFournisseurById(@PathVariable("idFournisseur")@Valid Long id);
	@PostMapping(value= APP_ROOT+"/Fournisseur/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	Fournisseur addFournisseur(@Valid @RequestBody Fournisseur fournisseur);
	@PutMapping(value= APP_ROOT+"/Fournisseur/update/{idFournisseur}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	Fournisseur updateFournisseur(@Valid @PathVariable("idFournisseur") Long id,@Valid @RequestBody Fournisseur fournisseur);
	 @DeleteMapping(value=APP_ROOT+"/Fournisseur/delete/{idFournisseur}")
	void deleteFournisseur(@PathVariable("idFournisseur")@Valid Long id);   
	 
	 
	 
	}