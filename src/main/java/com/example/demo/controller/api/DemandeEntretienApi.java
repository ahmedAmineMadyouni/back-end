package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;
import static com.example.demo.utils.Constants.APP_ROOT2;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.auth.authService.entretienRequest;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DemandeEntretien;

import jakarta.validation.Valid;

public interface DemandeEntretienApi {
	
	
	//findAll
	@GetMapping(value=APP_ROOT+"/DemandeEntretien/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getAllDemandeEntretien();
	//used by admin to list all notValid Demande entretien 
	@GetMapping(value=APP_ROOT+"/DemandeEntretien/NotValide/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getAllValideDemandeEntretien( );
	//used by admin to list all not valide demande to validate it in the future 
	@GetMapping(value=APP_ROOT+"/DemandeEntretien/NotValide/NotAproved/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getAllNotValideDemandeEntretien();
	//used by admin to list all canceld demande 
	@GetMapping(value=APP_ROOT+"/DemandeEntretien/NotValide/Canceled/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getAllNotValideDemandeEntretienCanceled();
	//used by admin to list all InProgress demande
	@GetMapping(value=APP_ROOT+"/DemandeEntretien/NotValide/InProgress/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getAllNotValideDemandeEntretienInProgress();
	//used by admin to list all Confirmed demande
	@GetMapping(value=APP_ROOT+"/DemandeEntretien/NotValide/Confirmed/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getAllNotValideDemandeEntretienConfirmed();
	
	@GetMapping(value=APP_ROOT2+"/DemandeEntretien/{idDemande}",produces=MediaType.APPLICATION_JSON_VALUE)
	 DemandeEntretien getDemandeEntretienById(@PathVariable("idDemande")@Valid Long id);
	//used by user
	@GetMapping(value=APP_ROOT2+"/DemandeEntretien/chauffeur/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getDemandeEntretienByChauffeur(@PathVariable("id")@Valid Long id);
	
	@GetMapping(value=APP_ROOT2+"/DemandeEntretien/chauffeur/AdminValidated/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<DemandeEntretien> getDemandeEntretienByChauffeurAndAdminAproved(@PathVariable("id")@Valid Long id);
	//used by user
	@PutMapping(value= APP_ROOT2+"/DemandeEntretien/NotValide/setInProgress/{idDemande}",produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien startDemandeEntretien(@Valid @PathVariable("idDemande") Long id);
	//used by user
	@PutMapping(value= APP_ROOT2+"/DemandeEntretien/NotValide/setCanceld/{idDemande}",produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien CancelDemandeEntretien(@Valid @PathVariable("idDemande") Long id);
	
	@PutMapping(value= APP_ROOT+"/DemandeEntretien/NotValide/setCanceld/admin/{idDemande}",produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien CancelDemandeEntretienAdmin(@Valid @PathVariable("idDemande") Long id);
	//used by user
	@PutMapping(value= APP_ROOT2+"/DemandeEntretien/NotValide/setConfirmed/{idDemande}",produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien ConfirmDemandeEntretien(@Valid @PathVariable("idDemande") Long id ,@RequestBody entretienRequest x);
	//used by admin
	@PutMapping(value= APP_ROOT+"/DemandeEntretien/NotValide/firstValdation/{idDemande}/{idFournisseur}",produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien validateFirstDemandeEntretien(@Valid @PathVariable("idDemande") Long id,@PathVariable("idFournisseur") Long idFournisseur);
	
	@PostMapping(value= APP_ROOT2+"/DemandeEntretien/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien addDemandeEntretien(@Valid @RequestBody DemandeEntretien demandeEntretien);
    
	@PutMapping(value= APP_ROOT2+"/DemandeEntretien/update/{idDemande}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    DemandeEntretien updateDemandeEntretien(@Valid @PathVariable("idDemande") Long id,@Valid @RequestBody DemandeEntretien demandeEntretien);
   
	@DeleteMapping(value=APP_ROOT2+"/DemandeEntretien/delete/{idDemande}")
    void deleteDemandeEntretien(@PathVariable("idDemande")@Valid Long id);
	@DeleteMapping(value=APP_ROOT+"/DemandeEntretien/delete/admin/{idDemande}")
	void deleteDemandeEntretienAdmin(@PathVariable("idDemande")@Valid Long id);

    
    

}
