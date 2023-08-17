package com.example.demo.service;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.ChauffeurDTO;
import com.example.demo.model.Chauffeur;


public interface chauffeurService {
//    List<ChauffeurDTO> getAllChauffeurs();
//
//    ChauffeurDTO getChauffeurById(Long id);
//
//    ChauffeurDTO addChauffeurs(ChauffeurDTO chauffeurDto);
//
//    ChauffeurDTO updateChauffeur(Long id, ChauffeurDTO chauffeurDto);
//
//    void deleteChauffeur(Long id);
	
	
	List<?> getAllChauffeurs();
	boolean checkChauffeur(Long id);
	
	boolean checkChauffeurStillThere(Long id);

	Chauffeur getChauffeurById(Long id);
	 List<?> getNOTaffected();

//	Chauffeur addChauffeurs(Chauffeur chauffeur);

	Chauffeur updateChauffeur(Long id, Chauffeur chauffeur,MultipartFile file) throws IOException;

    void deleteChauffeur(Long id);
    
    ResponseEntity<?> saveProfile(Chauffeur chauffeur, MultipartFile file) throws IOException;
}