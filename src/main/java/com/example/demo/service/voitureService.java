package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.dto.VoitureDTO;
import com.example.demo.model.Voiture;

public interface voitureService {
//	List<VoitureDTO> getAllVoiture();
//	VoitureDTO getVoitureById(Long id);
//	VoitureDTO addVoiture(VoitureDTO voitureDto);
//	VoitureDTO updateVoiture(Long id, VoitureDTO voitureDto);
//    void deleteVoiture(Long id);
	
	
	
	List<Voiture> getAllVoiture();
	Voiture getVoitureById(Long id);
	List<Voiture> getNOTaffected();
	Voiture addVoiture(Voiture voiture ,MultipartFile file) throws IOException;
	Voiture updateVoiture(Long id, Voiture voiture,MultipartFile file)throws IOException;
    void deleteVoiture(Long id);
}
