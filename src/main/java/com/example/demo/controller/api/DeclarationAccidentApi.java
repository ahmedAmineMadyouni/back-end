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

import jakarta.validation.Valid;

public interface DeclarationAccidentApi {
	@GetMapping(value=APP_ROOT+"/DeclarationAccident/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DeclarationAccident> getAllDeclarationAccident();
	
	@GetMapping(value=APP_ROOT+"/DeclarationAccident/valide/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DeclarationAccident> getAllValideDeclarationAccident();
	
	@GetMapping(value=APP_ROOT+"/DeclarationAccident/NotValide/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getAllNotValideDeclarationAccident();
	
	@GetMapping(value=APP_ROOT+"/DeclarationAccident/{idDeclaration}",produces=MediaType.APPLICATION_JSON_VALUE)
	DeclarationAccident getDeclarationAccidentById(@PathVariable("idDeclaration")@Valid Long id);
	
	@GetMapping(value=APP_ROOT2+"/DeclarationAccident/chauffeur/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getDeclarationAccidentByChauffeur(@PathVariable("id")@Valid Long id);
	  
	@PostMapping(value= APP_ROOT2+"/DeclarationAccident/create")
	DeclarationAccident addDeclarationAccident(@Valid  DeclarationAccident declarationAccident,MultipartFile file) throws IOException;
	
	@PutMapping(value= APP_ROOT2+"/DeclarationAccident/update/{idDeclaration}",produces=MediaType.APPLICATION_JSON_VALUE)
	DeclarationAccident updateDeclarationAccident(@Valid @PathVariable("idDeclaration") Long id,@Valid   DeclarationAccident declarationAccident,MultipartFile file) throws IOException;
	
	@PutMapping(value= APP_ROOT+"/DeclarationAccident/cancel/{idDeclaration}",produces=MediaType.APPLICATION_JSON_VALUE)
	DeclarationAccident cancelDeclarationAccident(@Valid @PathVariable("idDeclaration") Long id);
	
	
	@DeleteMapping(value=APP_ROOT2+"/DeclarationAccident/delete/{idDeclaration}")
	void deleteDeclarationAccident(@PathVariable("idDeclaration")@Valid Long id);

}
