package com.example.demo.service;

import java.util.List;

//import com.example.demo.dto.AffectationVoitureDTO;
import com.example.demo.model.AffectationVoiture;

public interface affectationVoitureService {

//    List<AffectationVoitureDTO> getAllAffectationVoitures();
//
//    AffectationVoitureDTO getAffectationVoitureById(Long id);
//
//    AffectationVoitureDTO addAffectationVoiture(AffectationVoitureDTO affectationVoitureDTO);
//
//    AffectationVoitureDTO updateAffectationVoiture(Long id, AffectationVoitureDTO affectationVoitureDTO);
//
//    void deleteAffectationVoiture(Long id);
    
    

    List<?> getAllAffectationVoitures();

    AffectationVoiture getAffectationVoitureById(Long id);
    
    boolean checkAffectationVoiture(Long id);

    AffectationVoiture addAffectationVoiture(AffectationVoiture 	affectationVoiture);

    AffectationVoiture updateAffectationVoiture(Long id, AffectationVoiture affectationVoiture);

    void deleteAffectationVoiture(Long id);


}
