package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.dto.AffectationVoitureDTO;
//import com.example.demo.dto.ChauffeurDTO;
//import com.example.demo.dto.VoitureDTO;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.AffectationVoiture;
import com.example.demo.model.Entretien;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.repository.AffectationVoitureRepository;
import com.example.demo.service.affectationVoitureService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AffectationVoitureImpl implements affectationVoitureService {
    @Autowired
    private AffectationVoitureRepository afRepo;
    public AffectationVoitureImpl(AffectationVoitureRepository afRepo) {
		super();
		this.afRepo = afRepo;
	}

	@Override
    public List<?> getAllAffectationVoitures() {
		List<AffectationVoiture> affectations = afRepo.findAll();
		List<AffectationDTO> affectationDTOs = new ArrayList<>();

		for (AffectationVoiture affectationVoiture : affectations) {
			AffectationDTO affectationDTO = new AffectationDTO();
			affectationDTO.setVoiturePhotoId(affectationVoiture.getVoiture().getPhoto().getPhoto_id());
			affectationDTO.setVoitureModele(affectationVoiture.getVoiture().getLibellemodele());
			affectationDTO.setVoitureMarque(affectationVoiture.getVoiture().getLibelleMarque());
			affectationDTO.setIdVoiture(affectationVoiture.getVoiture().getIdVoiture());
			affectationDTO.setIdChauffeur(affectationVoiture.getChauffeur().getIdConducteur());
			affectationDTO.setIdAffectation(affectationVoiture.getIdAffectation());
			affectationDTO.setDateFin(affectationVoiture.getDateFin());
			affectationDTO.setDateDebut(affectationVoiture.getDateDebut());
		    affectationDTO.setChauffeurUserName(affectationVoiture.getChauffeur().getProfile().getUsername());
		    affectationDTO.setChauffeurPhotoId(affectationVoiture.getChauffeur().getPhoto().getPhoto_id());
		    affectationDTO.setChauffeurName(affectationVoiture.getChauffeur().getNom());
		    affectationDTO.setChauffeurEamil(affectationVoiture.getChauffeur().getEmail());
		    
		    
		    affectationDTOs.add(affectationDTO);
		}
		return affectationDTOs;
//        return afRepo.findAll().stream().map(AffectationVoitureDTO::fromEntity).collect(Collectors.toList());
    //return afRepo.findAll();
    }

    @Override
    public AffectationVoiture getAffectationVoitureById(Long id) {
        Optional<AffectationVoiture> optionalAffectationvoiture = afRepo.findById(id);
        
        if (optionalAffectationvoiture.isPresent()) {
            return optionalAffectationvoiture.get();

        } else {

            throw new EntityNotFoundException("affectation not found", ErrorCodes.AFFECTATION_VOITURE_NOT_FOUND);
        }
    }

    @Override
    public AffectationVoiture addAffectationVoiture(AffectationVoiture affectationVoiture) {
//        if (afRepo.existsByVoiture(affectationVoiture.getVoiture().getIdVoiture())) {
//            throw new EntityAlreadyExistsException("affectation already exists");
//        } else {

//            return AffectationVoitureDTO.fromEntity(afRepo.save(AffectationVoitureDTO.toEntity(affectationVoitureDTO)));
            return afRepo.save(affectationVoiture);
        //}
    }

    @Override
    public AffectationVoiture updateAffectationVoiture(Long id, AffectationVoiture affectationVoiture) {
    	AffectationVoiture x= afRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("AffectationVoiture not found ",ErrorCodes.AFFECTATION_VOITURE_NOT_FOUND));
    	x.setChauffeur(affectationVoiture.getChauffeur());
    	x.setDateDebut(affectationVoiture.getDateDebut());
    	x.setDateFin(affectationVoiture.getDateFin());
    	x.setVoiture(affectationVoiture.getVoiture());
    	
        return afRepo.save(x);
    }

    @Override
    public void deleteAffectationVoiture(Long id) {
        // TODO Auto-generated method stub
        if (afRepo.existsById(id)&& !afRepo.areAffectationVoiture(id)) {
            afRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("affectation not found", ErrorCodes.AFFECTATION_VOITURE_NOT_FOUND);
        }
    }

	@Override
	public boolean checkAffectationVoiture(Long id) {
		// TODO Auto-generated method stub
		return afRepo.areAffectationVoiture(id);
	}

}