package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationAmendes;

public interface DeclarationAmendesService {
	 List<DeclarationAmendes> getAllDeclarationAmendes();

	 DeclarationAmendes getDeclarationAmendesById(Long id);
	 
	 List<?> getDeclarationAmendesByChauffeur(Long id);
	 
	 List<DeclarationAmendes> getDeclarationAmendesByStatus();
	 
	 List<?>  getDeclarationAmendesNotValide();

	 DeclarationAmendes addDeclarationAmendes(DeclarationAmendes declarationAmendes,MultipartFile file) throws IOException;

	 DeclarationAmendes updateDeclarationAmendes(Long id, DeclarationAmendes declarationAmendes, MultipartFile file)
				throws IOException ;
	 DeclarationAmendes cancelDeclaration(Long id);

	    void deleteDeclarationAmendes(Long id);

}
