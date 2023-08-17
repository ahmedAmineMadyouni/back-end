package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.authService.entretienRequest;
import com.example.demo.controller.api.DemandeEntretienApi;
import com.example.demo.model.DemandeEntretien;
import com.example.demo.service.DemandeEntretienService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class DemandeEntretienController implements DemandeEntretienApi {

	DemandeEntretienService entreService;
	
	public DemandeEntretienController(DemandeEntretienService entreService) {
		super();
		this.entreService = entreService;
	}

	@Override
	public List<DemandeEntretien> getAllDemandeEntretien() {
		// TODO Auto-generated method stub
		return entreService.getAllDemandeEntretien();
	}

	@Override
	public DemandeEntretien getDemandeEntretienById(@Valid Long id) {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretienById(id);
	}

	@Override
	public DemandeEntretien addDemandeEntretien(@Valid DemandeEntretien demandeEntretien) {
		// TODO Auto-generated method stub
		return entreService.addDemandeEntretien(demandeEntretien);
	}

	@Override
	public DemandeEntretien updateDemandeEntretien(@Valid Long id, @Valid DemandeEntretien demandeEntretien) {
		// TODO Auto-generated method stub
		return entreService.updateDemandeEntretien(id, demandeEntretien);
	}

	@Override
	public void deleteDemandeEntretien(@Valid Long id) {
		entreService.deleteDemandeEntretien(id);

	}

	@Override
	public List<DemandeEntretien> getDemandeEntretienByChauffeur(@Valid Long id) {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretienByChauffeur(id);
	}
	
	@Override
	public List<DemandeEntretien> getDemandeEntretienByChauffeurAndAdminAproved(@Valid Long id)  {


		return entreService.getDemandeEntretienByChauffeurAndNotCompleted(id);
	}

	@Override
	public List<DemandeEntretien> getAllValideDemandeEntretien() {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretienByStatus();
	}

	@Override
	public List<DemandeEntretien> getAllNotValideDemandeEntretien() {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretienNotValide();
	}

	@Override
	public List<DemandeEntretien> getAllNotValideDemandeEntretienCanceled() {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretienNotValide();
	}

	@Override
	public List<DemandeEntretien> getAllNotValideDemandeEntretienInProgress() {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretieninProgress();
	}

	@Override
	public List<DemandeEntretien> getAllNotValideDemandeEntretienConfirmed() {
		// TODO Auto-generated method stub
		return entreService.getDemandeEntretienConfiremed();
	}

	@Override
	public DemandeEntretien startDemandeEntretien(@Valid Long id) {
		// TODO Auto-generated method stub
		return entreService.startDemandeEntretien(id);
	}

	@Override
	public DemandeEntretien CancelDemandeEntretien(@Valid Long id) {
		// TODO Auto-generated method stub
		return entreService.cancelDemandeEntretien(id);
	}

	@Override
	public DemandeEntretien CancelDemandeEntretienAdmin(@Valid Long id) {
		// TODO Auto-generated method stub
		return entreService.cancelDemandeEntretienAdmin(id);
	}

	@Override
	public DemandeEntretien ConfirmDemandeEntretien(@Valid Long id,entretienRequest x) {
		// TODO Auto-generated method stub
		return entreService.confirmDemandeEntretien(id,x);
	}

	@Override
	public DemandeEntretien validateFirstDemandeEntretien(@Valid Long id, Long idFournisseur) {
		// TODO Auto-generated method stub
		return entreService.setDemandeEntretienAdminAproved(id,idFournisseur);
	}

	@Override
	public void deleteDemandeEntretienAdmin(@Valid Long id) {
		entreService.deleteDemandeEntretienAdmin(id);
		
	}

	

	

}
