package com.example.demo.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.auth.authService.entretienRequest;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DemandeEntretien;
import com.example.demo.model.EntretienCompletation;
import com.example.demo.model.Fournisseur;
import com.example.demo.model.Profile;
import com.example.demo.model.Voiture;
import com.example.demo.repository.ChauffeurRepository;
import com.example.demo.repository.DemandeEntretienRepository;
import com.example.demo.repository.FournisseurRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.service.DemandeEntretienService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class DemandeEntretienServiceImpl implements DemandeEntretienService {
	@Autowired
	private DemandeEntretienRepository demRepo;
	@Autowired
	private FournisseurRepository fRepo;
	

	public DemandeEntretienServiceImpl(DemandeEntretienRepository demRepo,FournisseurRepository fRepo) {
		super();
		this.demRepo = demRepo;
		this.fRepo=fRepo;
	}

	@Override
	public List<DemandeEntretien> getAllDemandeEntretien() {
		// TODO Auto-generated method stub
		return  demRepo.findAll();
	}

	@Override
	public DemandeEntretien getDemandeEntretienById(Long id) {
		Optional<DemandeEntretien> optionalDemandeEntretien = demRepo.findById(id);
		if (optionalDemandeEntretien.isPresent()) {
			
//			return VoitureDTO.fromEntity(optionalVoiture.get());
			return optionalDemandeEntretien.get(); 
		} else {

			throw new EntityNotFoundException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}
	}
	
	
	@Override
	public List<DemandeEntretien> getDemandeEntretienByChauffeur(Long id) {
		List<DemandeEntretien> entretien = demRepo.findByChauffeur(id);
	    if (entretien !=null) {
	      return  entretien;
	    }
	    return Collections.emptyList();
	}

	@Override
	public DemandeEntretien addDemandeEntretien(DemandeEntretien demandeEntretien) {
		if(demRepo.existsByDateDemandes(demandeEntretien.getDateDemandes())) {
			throw new EntityAlreadyExistsException("demande Entretien already exists",ErrorCodes.DEMANDE_ENTRETIEN_ALREADY_EXIST);
        }else {
        	demandeEntretien.setStatus(false);
        	return demRepo.save(demandeEntretien);
        }
		
	}

	@Override
	public DemandeEntretien updateDemandeEntretien(Long id, DemandeEntretien demandeEntretien) {
		DemandeEntretien optionalDemandeEntretien =demRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("DemandeEntretien not found",ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND));
		if( optionalDemandeEntretien.getCompleted()==null) {
			optionalDemandeEntretien.setDateDemandes(demandeEntretien.getDateDemandes());
			optionalDemandeEntretien.setVoiture(demandeEntretien.getVoiture());
			optionalDemandeEntretien.setType(demandeEntretien.getType());
			optionalDemandeEntretien.setObligation(demandeEntretien.getObligation());
			optionalDemandeEntretien.setDescription(demandeEntretien.getDescription());
			optionalDemandeEntretien.setChauffeur(demandeEntretien.getChauffeur());

	            return demRepo.save(optionalDemandeEntretien);
		}else {
			throw new InvalidEntityException("demande Entretien status  not NULL",ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}
		
	}
	
	@Override
	public void deleteDemandeEntretien(Long id) {
		if(demRepo.existsById(id)) {
			DemandeEntretien x=demRepo.findById(id).orElseThrow(()->new EntityNotFoundException("demande Entretien not found",ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND));
			if(x.getCompleted()==null||x.getCompleted().equals(EntretienCompletation.CANCELED)) {
				demRepo.deleteById(id);
			}

	}
	}
	@Override
	public void deleteDemandeEntretienAdmin(Long id) {
		DemandeEntretien x=demRepo.findById(id).orElseThrow(()->new EntityNotFoundException("demande Entretien not found",ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND) );
		if(x.getCompleted()!=null) {
		if(x.getCompleted().equals(EntretienCompletation.SUCCESS)) {
			demRepo.deleteById(id);
		}
		
		}
	}
	
	@Override
	public List<DemandeEntretien> getDemandeEntretienNotValide() {
		// TODO Auto-generated method stub
		return demRepo.findByStatusNotValide();
	}

	@Override
	public List<DemandeEntretien> getDemandeEntretienByStatus( ) {
		// TODO Auto-generated method stub
		return demRepo.findByStatus();
	}

	@Override
	public List<DemandeEntretien> getDemandeEntretienByChauffeurAndNotCompleted(Long id) {
		
		return demRepo.findByChauffeurAndNotCompleted(id);
	}

	@Override
	public List<DemandeEntretien> getDemandeEntretienCanceled() {
		// TODO Auto-generated method stub
		return demRepo.findByCanceled();
	}

	@Override
	public List<DemandeEntretien> getDemandeEntretieninProgress() {
		// TODO Auto-generated method stub
		return demRepo.findByInProgress();
	}

	@Override
	public List<DemandeEntretien> getDemandeEntretienConfiremed() {
		// TODO Auto-generated method stub
		return demRepo.findByCompleted();
	}

	@Override
	public DemandeEntretien setDemandeEntretienAdminAproved(Long id, Long idF) {
		Optional<DemandeEntretien> x= demRepo.findById(id);
		Optional<Fournisseur> x2= fRepo.findById(idF);
		if(x2.isPresent()) {
			if(x.isPresent()) {
				if(x.get().getCompleted()==null) {
					x.get().setCompleted(EntretienCompletation.ADMIN_APROVED);
					x.get().setFournisseur(x2.get());
					return demRepo.save(x.get());
				}else {
					throw new InvalidEntityException("demande entretine filed completed is not null");
				}
				
			}else {
				throw new EntityNotFoundException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
			}
			
		}else {
			throw new EntityNotFoundException("fournisseur not found", ErrorCodes.FOURNISSEUR_NOT_FOUND);
		}
		
		
	}

	@Override
	public DemandeEntretien startDemandeEntretien(Long id) {
		Optional<DemandeEntretien> x= demRepo.findById(id);
		if(x.isPresent() && (x.get().getCompleted().equals(EntretienCompletation.ADMIN_APROVED))){
			x.get().setCompleted(EntretienCompletation.IN_PROGRESS);
			return demRepo.save(x.get());
		}else {

			throw new EntityNotFoundException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}
	}

	@Override
	public DemandeEntretien cancelDemandeEntretien(Long id) {
		Optional<DemandeEntretien> x= demRepo.findById(id);
		if(x.isPresent() && (x.get().getCompleted().equals(EntretienCompletation.ADMIN_APROVED)||x.get().getCompleted().equals(EntretienCompletation.IN_PROGRESS)|| x.get().getCompleted()==null )){
			x.get().setCompleted(EntretienCompletation.CANCELED);
			return demRepo.save(x.get());
		}else {

			throw new EntityNotFoundException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}
	}
	
	@Override
	public DemandeEntretien cancelDemandeEntretienAdmin(Long id) {
		DemandeEntretien x= demRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND));
		if(x.getCompleted()==null) {
			x.setCompleted(EntretienCompletation.CANCELED);
			return demRepo.save(x);
		}else {
			if(x.getCompleted().equals(EntretienCompletation.ADMIN_APROVED)||x.getCompleted()==null ){
				x.setCompleted(EntretienCompletation.CANCELED);
				return demRepo.save(x);
		}
			throw new InvalidEntityException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}

			
		
	}

	@Override
	public DemandeEntretien confirmDemandeEntretien(Long id,entretienRequest x1) {
		Optional<DemandeEntretien> x= demRepo.findById(id);
		if(x.isPresent() && (x.get().getCompleted().equals(EntretienCompletation.IN_PROGRESS))){
			x.get().setCompleted(EntretienCompletation.SUCCESS);
			x.get().setMontant(x1.getMontant());
			x.get().setNumDemandeAchat(x1.getNumDemandeAchat());
			return demRepo.save(x.get());
		}else {

			throw new EntityNotFoundException("demande not found", ErrorCodes.DEMANDE_ENTRETIEN_NOT_FOUND);
		}
	}

	

}
