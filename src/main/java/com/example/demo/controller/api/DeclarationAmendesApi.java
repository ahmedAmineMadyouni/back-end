package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;
import static com.example.demo.utils.Constants.APP_ROOT2;

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

import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationAmendes;


import jakarta.validation.Valid;

public interface DeclarationAmendesApi {
	
	@GetMapping(value=APP_ROOT+"/DeclarationAmendes/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DeclarationAmendes> getAllDeclarationAmendes();
	
	@GetMapping(value=APP_ROOT+"/DeclarationAmendes/valide/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DeclarationAmendes> getAllValideDeclarationAmendes();
	
	@GetMapping(value=APP_ROOT+"/DeclarationAmendes/NotValide/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getAllNotValideDeclarationAmendes();
	
	@GetMapping(value=APP_ROOT+"/DeclarationAmendes/{idDeclaration}",produces=MediaType.APPLICATION_JSON_VALUE)
	DeclarationAmendes getDeclarationAmendesById(@PathVariable("idDeclaration")@Valid Long id);
	 
	@GetMapping(value=APP_ROOT2+"/DeclarationAmendes/chauffeur/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getDeclarationAmendesByChauffeur(@PathVariable("id")@Valid Long id);
	
	@PostMapping(value= APP_ROOT2+"/DeclarationAmendes/create")
	 DeclarationAmendes addDeclarationAmendes(@Valid  DeclarationAmendes declarationAmendes,MultipartFile file) throws IOException;
	 
	@PutMapping(value= APP_ROOT2+"/DeclarationAmendes/update/{idDeclaration}",produces=MediaType.APPLICATION_JSON_VALUE)
	 DeclarationAmendes updateDeclarationAmendes(@Valid @PathVariable("idDeclaration") Long id,@Valid   DeclarationAmendes declarationAmendes,MultipartFile file) throws IOException;
	
	@PutMapping(value= APP_ROOT+"/DeclarationAmendes/cancel/{idDeclaration}",produces=MediaType.APPLICATION_JSON_VALUE)
	DeclarationAmendes cancelDeclarationAmendes(@Valid @PathVariable("idDeclaration") Long id);
	
	
	@DeleteMapping(value=APP_ROOT2+"/DeclarationAmendes/delete/{idDeclaration}")
	void deleteDeclarationAmendes(@PathVariable("idDeclaration")@Valid Long id);

}
