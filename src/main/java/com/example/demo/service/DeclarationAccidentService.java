package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.Mission;

public interface DeclarationAccidentService {
	
	  List<DeclarationAccident> getAllDeclarationAccident();
	  
	  List<?> getDeclarationAccidentByChauffeurId(Long idConducteur);
	  
	  List<DeclarationAccident> getDeclarationAccidentByStatus();
	  
	  List<?>  getDeclarationNotValide();

	  DeclarationAccident getDeclarationAccidentById(Long id);

	  DeclarationAccident addDeclarationAccident(DeclarationAccident declarationAccident,MultipartFile file) throws IOException;

	  DeclarationAccident updateDeclarationAccident(Long id, DeclarationAccident declarationAccident, MultipartFile file)
				throws IOException ;
	  
	  DeclarationAccident cancelDeclaration(Long id);
	    void deleteDeclarationAccident(Long id);

}
