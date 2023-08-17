package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.example.demo.dto.EntretienDTO;
//
//import com.example.demo.dto.FournisseurDTO;
//
//import com.example.demo.dto.VoitureDTO;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.Chauffeur;
import com.example.demo.model.DemandeEntretien;
import com.example.demo.model.Entretien;
import com.example.demo.repository.DemandeEntretienRepository;
import com.example.demo.repository.EntretienRepository;
import com.example.demo.repository.VoitureRepository;
import com.example.demo.service.entretienService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EntretienServiceImpl implements entretienService {

	@Autowired
	private  EntretienRepository eRepo;
	@Autowired
	private DemandeEntretienRepository demRepo;
	@Autowired
	private VoitureRepository vRepo;
	

	public EntretienServiceImpl(EntretienRepository eRepo) {
		super();
		this.eRepo = eRepo;
	}

	@Override
	public List<?> getAllEntretiens() {
		List<Entretien> entretiens = eRepo.findAll();
		List<EntretienUserDTO> entretienDTOs = new ArrayList<>();

		for (Entretien entretien : entretiens) {
			EntretienUserDTO entretienDTO = new EntretienUserDTO();
			entretienDTO.setChauffeurName(entretien.getChauffeur().getNom());
			entretienDTO.setChauffeurUserName(entretien.getChauffeur().getProfile().getUsername());
			entretienDTO.setChauffeurPhotoId(entretien.getChauffeur().getPhoto().getPhoto_id());
			entretienDTO.setDateE(entretien.getDateE());
			entretienDTO.setDetail(entretien.getDetail());
		    entretienDTO.setFournisseur(entretien.getFournisseur());
		    entretienDTO.setIdEntretien(entretien.getIdEntretien());
		    entretienDTO.setVoitureMarque(entretien.getVoiture().getLibelleMarque());
		    entretienDTO.setVoitureModele(entretien.getVoiture().getLibellemodele());
		    entretienDTO.setVoiturePhotoId(entretien.getVoiture().getPhoto().getPhoto_id());
		    entretienDTO.setType(entretien.getType());
		    entretienDTO.setNumDemandeAchat(entretien.getNumDemandeAchat());
		    entretienDTO.setMontant(entretien.getMontant());
		    entretienDTO.setLibellee(entretien.getLibellee());
		    
		    
		    entretienDTOs.add(entretienDTO);
		}
		return entretienDTOs;
//		return  eRepo.findAll().stream().map(EntretienDTO::fromEntity).collect(Collectors.toList());
		//return  eRepo.findAll();
	}

	@Override
	public Entretien getEntretienById(Long id) {
		Optional<Entretien> optionalEntretien = eRepo.findById(id);
		if (optionalEntretien.isPresent()) {
//			return EntretienDTO.fromEntity(optionalEntretien.get());
			return optionalEntretien.get();
		} else {

			throw new EntityNotFoundException("entretien not found", ErrorCodes.ENTRETIEN_NOT_FOUND);
		}
	}

	@Override
	public Entretien addEntretien(Entretien entretien) {
		if (eRepo.existsById(entretien.getIdEntretien())) {
			throw new EntityAlreadyExistsException("entretien already exists");
		} else {
		
//			return EntretienDTO.fromEntity(eRepo.save(EntretienDTO.toEntity(entretienDto)));
			return eRepo.save(entretien);
		}
	}

	@Override
	public Entretien updateEntretien(Long id, Entretien entretien) {

		if (eRepo.existsById(entretien.getIdEntretien())) {
			throw new EntityAlreadyExistsException("entretien already exists");
		} else {
			Optional<Entretien> optionalEntretien = eRepo.findById(id);
			if (optionalEntretien.isPresent()) {
				Entretien opEntretien = optionalEntretien.get();
				entretien.setDateE(entretien.getDateE());
				entretien.setFournisseur(entretien.getFournisseur());
				entretien.setMontant(entretien.getMontant());
				entretien.setNumDemandeAchat(entretien.getNumDemandeAchat());
				entretien.setLibellee(entretien.getLibellee());
				
				entretien.setDetail(entretien.getDetail());
				entretien.setVoiture(entretien.getVoiture());
//				return EntretienDTO.fromEntity(eRepo.save(entretien));
				return eRepo.save(opEntretien);
			} else {
				throw new EntityNotFoundException("entretien not found", ErrorCodes.ENTRETIEN_NOT_FOUND);
			}
		}
	}

	@Override
	public void deleteEntretien(Long id) {
		// TODO Auto-generated method stub
		if (eRepo.existsById(id)) {
			eRepo.deleteById(id);
		} else {
			throw new EntityNotFoundException("entretien not found", ErrorCodes.ENTRETIEN_NOT_FOUND);
		}
	}

	@Override
	public Entretien validateDemnadeEntretien(Long id) {
		Optional<DemandeEntretien> opEntre=demRepo.findById(id);
		if(opEntre.isPresent()&& !opEntre.get().isStatus()) {
			Entretien entre =new  Entretien();
			entre.setChauffeur(opEntre.get().getChauffeur());
			entre.setVoiture(opEntre.get().getVoiture());
			entre.setType(opEntre.get().getType());
			entre.setNumDemandeAchat(opEntre.get().getNumDemandeAchat());
			entre.setMontant(opEntre.get().getMontant());
			entre.setLibellee(opEntre.get().getObligation());
			entre.setFournisseur(opEntre.get().getFournisseur());
			entre.setDetail(opEntre.get().getDescription());
			entre.setDateE(opEntre.get().getDateDemandes());
			opEntre.get().setStatus(true);
			demRepo.save(opEntre.get());
			return eRepo.save(entre);
			
			
		}else {
			throw new EntityNotFoundException("Declaration Accident not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}
		
	}

	@Override
	public boolean checkVoitureStillThere(Long id) {
		// TODO Auto-generated method stub
		return vRepo.existsById(id);
	}

	@Override
	public List<?> getEntretienByIdConducteur(Long id) {
		List<Entretien> entretiens = eRepo.findByChauffeur(id);
		List<EntretienUserDTO> entretienDTOs = new ArrayList<>();

		for (Entretien entretien : entretiens) {
			EntretienUserDTO entretienDTO = new EntretienUserDTO();
			entretienDTO.setChauffeurName(entretien.getChauffeur().getNom());
			entretienDTO.setChauffeurUserName(entretien.getChauffeur().getProfile().getUsername());
			entretienDTO.setChauffeurPhotoId(entretien.getChauffeur().getPhoto().getPhoto_id());
			entretienDTO.setDateE(entretien.getDateE());
			entretienDTO.setDetail(entretien.getDetail());
		    entretienDTO.setFournisseur(entretien.getFournisseur());
		    entretienDTO.setIdEntretien(entretien.getIdEntretien());
		    entretienDTO.setVoitureMarque(entretien.getVoiture().getLibelleMarque());
		    entretienDTO.setVoitureModele(entretien.getVoiture().getLibellemodele());
		    entretienDTO.setVoiturePhotoId(entretien.getVoiture().getPhoto().getPhoto_id());
		    entretienDTO.setType(entretien.getType());
		    entretienDTO.setNumDemandeAchat(entretien.getNumDemandeAchat());
		    entretienDTO.setMontant(entretien.getMontant());
		    entretienDTO.setLibellee(entretien.getLibellee());
		    
		    
		    entretienDTOs.add(entretienDTO);
		}
		return entretienDTOs;
		
		
	}

}
