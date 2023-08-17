package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.auth.authService.entretienRequest;
import com.example.demo.model.DemandeEntretien;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface DemandeEntretienService {
	 List<DemandeEntretien> getAllDemandeEntretien();

	 DemandeEntretien getDemandeEntretienById(Long id);
	 
	 List<DemandeEntretien> getDemandeEntretienByChauffeur(Long id);
	 
	 List<DemandeEntretien>  getDemandeEntretienByChauffeurAndNotCompleted(Long id) ;
	 
	 List<DemandeEntretien> getDemandeEntretienCanceled();
	 
	 List<DemandeEntretien> getDemandeEntretieninProgress();
	 
	 List<DemandeEntretien> getDemandeEntretienConfiremed();
	 
	 List<DemandeEntretien> getDemandeEntretienByStatus();
	 
	 List<DemandeEntretien> getDemandeEntretienNotValide();
	 
	 DemandeEntretien setDemandeEntretienAdminAproved(Long id, Long idF);
	 
	 DemandeEntretien startDemandeEntretien(Long id );
	 
	 DemandeEntretien cancelDemandeEntretien(Long id);
	 
	 DemandeEntretien cancelDemandeEntretienAdmin(Long id);
	 
	 DemandeEntretien confirmDemandeEntretien(Long id ,entretienRequest x);
	 
	 DemandeEntretien addDemandeEntretien(DemandeEntretien demandeEntretien);

	 DemandeEntretien updateDemandeEntretien(Long id, DemandeEntretien demandeEntretien);

	    void deleteDemandeEntretien(Long id);
	    void deleteDemandeEntretienAdmin(Long id);
}
