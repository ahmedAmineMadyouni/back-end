package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.dto.AdresseDTO;
//import com.example.demo.dto.EntretienDTO;
//import com.example.demo.dto.FournisseurDTO;
//
//import com.example.demo.dto.MaintenanceDTO;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.Fournisseur;
import com.example.demo.repository.FournisseurRepository;
import com.example.demo.service.fournisseurService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FournisseurServiceImpl implements fournisseurService {
	@Autowired
	private  FournisseurRepository fRepo;

	@Override
	public List<Fournisseur> getAllFournisseur() {
		// TODO Auto-generated method stub
//		return fRepo.findAll().stream().map(FournisseurDTO::fromEntity).collect(Collectors.toList());
		return fRepo.findAll();
	}

	@Override
	public Fournisseur getFournisseurById(Long id) {
		// TODO Auto-generated method stub
		Optional<Fournisseur> optionalFournisseur = fRepo.findById(id);
		if (optionalFournisseur.isPresent()) {
//			return FournisseurDTO.fromEntity(optionalFournisseur.get());
			return optionalFournisseur.get();
		} else {

			throw new EntityNotFoundException("fournisseur not found", ErrorCodes.FOURNISSEUR_NOT_FOUND);
		}
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
//		if (fRepo.existsById(fournisseur.getIdFournisseur())) {
//			throw new EntityAlreadyExistsException("fournisseur already exists");
//		} else {
		
//			return  FournisseurDTO.fromEntity(fRepo.save(FournisseurDTO.toEntity(fournisseurDto)));
			return  fRepo.save(fournisseur);

		//}
	}

	@Override
	public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur) {
//		Mission miss =miRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("voiture"));
//		Optional<Mission> optionalMission = miRepo.findById(id);
//		if (optionalMission.isPresent()&& optionalMission.get().getMissionStatus().equals(MissionStatus.NEW_TASK)) {
//			
//			miss.setTitre(mission.getTitre());
//			miss.setType(mission.getType());
//			optionalMission.get().setAdresse(mission.getAdresse());
//			miss.setDescription(mission.getDescription());
//			miss.setDateMission(mission.getDateMission());
//			miss.setAffectationVoiture(mission.getAffectationVoiture());
		Fournisseur x=fRepo.findById(id).orElseThrow(()->
		new EntityNotFoundException("Fournisseur not found",ErrorCodes.FOURNISSEUR_NOT_FOUND));
				
				x.setNomSociete(fournisseur.getNomSociete());
//				fournisseur.setEntretien((Fournisseur.getEntretienDto().stream()
//						.map(EntretienDTO::toEntity).collect(Collectors.toList())));
//				fournisseur.setMaintenance((fournisseurDto.getMaintenanceDto().stream()
//						.map(MaintenanceDTO::toEntity).collect(Collectors.toList())));
				x.setAdresse(fournisseur.getAdresse());
				x.setNumTel(fournisseur.getNumTel());
//				return FournisseurDTO.fromEntity(fRepo.save(fournisseur));
				return fRepo.save(x);
			
		}
	

	@Override
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		if (fRepo.existsById(id)&&!fRepo.isFournisseurInDemandeEntretienInProgress(id)) {
			fRepo.deleteById(id);
		} else {
			throw new EntityNotFoundException("fournisseur not found or IS IN a INprogress Demande entretien", ErrorCodes.FOURNISSEUR_NOT_FOUND);
		}
	}

	@Override
	public boolean checkFournisseur(Long id) {
		// TODO Auto-generated method stub
		return fRepo.isFournisseurInDemandeEntretienInProgress(id);
	}

}
