package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.api.DeclarationAccidentApi;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.service.DeclarationAccidentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class DeclarationAccidentController implements DeclarationAccidentApi {
	
	DeclarationAccidentService deccService;

	public DeclarationAccidentController(DeclarationAccidentService deccService) {
		super();
		this.deccService = deccService;
	}

	@Override
	public List<DeclarationAccident> getAllDeclarationAccident() {
		// TODO Auto-generated method stub
		return deccService.getAllDeclarationAccident();
	}

	@Override
	public DeclarationAccident getDeclarationAccidentById(@Valid Long id) {
		// TODO Auto-generated method stub
		return deccService.getDeclarationAccidentById(id);
	}
	
	

	@Override
	public List<?> getDeclarationAccidentByChauffeur(@Valid Long id) {
		// TODO Auto-generated method stub
		return deccService.getDeclarationAccidentByChauffeurId(id);
	}

	@Override
	public DeclarationAccident addDeclarationAccident(@Valid DeclarationAccident declarationAccident,
			MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return deccService.addDeclarationAccident(declarationAccident, file);
	}

	@Override
	public DeclarationAccident updateDeclarationAccident(@Valid Long id, @Valid DeclarationAccident declarationAccident,
			MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return deccService.updateDeclarationAccident(id, declarationAccident, file);
	}

	@Override
	public void deleteDeclarationAccident(@Valid Long id) {
		deccService.deleteDeclarationAccident(id);
	}

	@Override
	public List<DeclarationAccident> getAllValideDeclarationAccident() {
		// TODO Auto-generated method stub
		return deccService.getDeclarationAccidentByStatus();
	}

	@Override
	public List<?> getAllNotValideDeclarationAccident() {
		// TODO Auto-generated method stub
		return deccService.getDeclarationNotValide();
	}

	@Override
	public DeclarationAccident cancelDeclarationAccident(@Valid Long id) {
		// TODO Auto-generated method stub
		return deccService.cancelDeclaration(id);
	}

}
