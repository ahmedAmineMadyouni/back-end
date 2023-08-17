package com.example.demo.service;
import java.util.List;

import com.example.demo.model.DemandeEntretien;
//import com.example.demo.dto.EntretienDTO;
import com.example.demo.model.Entretien;

public interface entretienService {
//    List<EntretienDTO> getAllEntretiens();
//
//    EntretienDTO getEntretienById(Long id);
//
//    EntretienDTO addEntretien(EntretienDTO EntretienDTO);
//
//    EntretienDTO updateEntretien(Long id, EntretienDTO EntretienDTO);
//
//    void deleteEntretien(Long id);
	
	
    List<?> getAllEntretiens();
    List<?> getEntretienByIdConducteur(Long id);
    Entretien getEntretienById(Long id);
    Entretien validateDemnadeEntretien(Long id);
    
    boolean checkVoitureStillThere(Long id);

    Entretien addEntretien(Entretien entretien);

    Entretien updateEntretien(Long id, Entretien entretien);

    void deleteEntretien(Long id);
}
