package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DeclarationAmendes;
import com.example.demo.model.DemandeEntretien;

@Repository
public interface DemandeEntretienRepository  extends JpaRepository<DemandeEntretien,Long>{

	boolean existsByDateDemandes(Date dateDemandes);
	
	//used by chauffeur to list his own not approved yet demande
	@Query("SELECT d FROM DemandeEntretien d WHERE d.chauffeur.idConducteur=?1 AND d.status = false AND d.completed=NULL OR d.completed=CANCELED")
	List<DemandeEntretien> findByChauffeur(Long id );
	
	//used by admin to list the successful demande to validate it in the future 
	@Query("SELECT d FROM DemandeEntretien d WHERE   d.status = false  AND d.completed=SUCCESS")
	List<DemandeEntretien> findByCompleted( );
	
	//used by admin to list canceled 
	@Query("SELECT d FROM DemandeEntretien d WHERE   d.status = false  AND d.completed=CANCELED")
	List<DemandeEntretien> findByCanceled( );
	
	//used by admin to see in-progress 
	@Query("SELECT d FROM DemandeEntretien d WHERE   d.status = false  AND d.completed=IN_PROGRESS")
	List<DemandeEntretien> findByInProgress( );
	
	//used by chauffeur to see his approved demande  to start completing it 	
	@Query("SELECT d FROM DemandeEntretien d WHERE d.chauffeur.idConducteur=?1 AND d.completed IS NOT NULL  AND (d.completed !=CANCELED AND d.completed !=SUCCESS)")
	List<DemandeEntretien> findByChauffeurAndNotCompleted(Long id );
	
	@Query("SELECT d FROM DemandeEntretien d WHERE   d.completed !=CANCELED OR d.completed=NULL")
	List<DemandeEntretien> findByStatus( );
	
	//used by admin to validate or cancel  chauffeurs demande 	
	@Query("SELECT d FROM DemandeEntretien d WHERE  d.status = false AND d.completed=NULL")
	List<DemandeEntretien> findByStatusNotValide( );
	
	

}
