package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Fournisseur;

//import com.example.demo.dto.FournisseurDTO;

public interface fournisseurService {
//    List<FournisseurDTO> getAllFournisseur();
//
//    FournisseurDTO getFournisseurById(Long id);
//
//    FournisseurDTO addFournisseur(FournisseurDTO FournisseurDTO);
//
//    FournisseurDTO updateFournisseur(Long id, FournisseurDTO FournisseurDTO);
//
//    void deleteFournisseur(Long id);
	
	
	
	 List<Fournisseur> getAllFournisseur();
	 boolean checkFournisseur(Long id);

	    Fournisseur getFournisseurById(Long id);

	    Fournisseur addFournisseur(Fournisseur Fournisseur);

	    Fournisseur updateFournisseur(Long id, Fournisseur Fournisseur);

	    void deleteFournisseur(Long id);
}