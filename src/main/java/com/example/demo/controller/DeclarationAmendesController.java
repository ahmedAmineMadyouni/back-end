package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.api.DeclarationAmendesApi;
import com.example.demo.model.DeclarationAmendes;
import com.example.demo.service.DeclarationAmendesService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class DeclarationAmendesController implements DeclarationAmendesApi {
	DeclarationAmendesService amService;
	
	public DeclarationAmendesController(DeclarationAmendesService amService) {
		super();
		this.amService = amService;
	}

	@Override
	public List<DeclarationAmendes> getAllDeclarationAmendes() {
		// TODO Auto-generated method stub
		return amService.getAllDeclarationAmendes();
	}

	@Override
	public DeclarationAmendes getDeclarationAmendesById(@Valid Long id) {
		// TODO Auto-generated method stub
		return amService.getDeclarationAmendesById(id);
	}

	@Override
	public DeclarationAmendes addDeclarationAmendes(@Valid DeclarationAmendes declarationAmendes, MultipartFile file)
			throws IOException {
		// TODO Auto-generated method stub
		return amService.addDeclarationAmendes(declarationAmendes, file);
	}

	@Override
	public DeclarationAmendes updateDeclarationAmendes(@Valid Long id, @Valid DeclarationAmendes declarationAmendes,
			MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return amService.updateDeclarationAmendes(id, declarationAmendes, file);
	}

	@Override
	public void deleteDeclarationAmendes(@Valid Long id) {
		amService.deleteDeclarationAmendes(id);

	}

	@Override
	public List<?> getDeclarationAmendesByChauffeur(@Valid Long id) {
		// TODO Auto-generated method stub
		return amService.getDeclarationAmendesByChauffeur(id);
	}

	@Override
	public List<DeclarationAmendes> getAllValideDeclarationAmendes() {
		// TODO Auto-generated method stub
		return amService.getDeclarationAmendesByStatus();
	}

	@Override
	public List<?> getAllNotValideDeclarationAmendes() {
		// TODO Auto-generated method stub
		return amService.getDeclarationAmendesNotValide();
	}

	@Override
	public DeclarationAmendes cancelDeclarationAmendes(@Valid Long id) {
		// TODO Auto-generated method stub
		return amService.cancelDeclaration(id);
	}

}
