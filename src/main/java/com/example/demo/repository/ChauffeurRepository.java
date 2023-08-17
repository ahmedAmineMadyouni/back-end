package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chauffeur;
import com.example.demo.model.Voiture;
@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur,Long>{

	Boolean existsByNumCIN(long numCIN);
	
	
	@Query("SELECT ch FROM Chauffeur ch WHERE ch.idConducteur NOT IN (SELECT a.chauffeur.idConducteur FROM AffectationVoiture a)")
	List<Chauffeur> getNotAffectedChauffeur();
	
	@Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM DemandeEntretien d WHERE d.chauffeur.idConducteur = ?1 AND d.completed = 'IN_PROGRESS') " +
		       "OR EXISTS (SELECT 1 FROM Mission m WHERE m.affectationVoiture.chauffeur.idConducteur = ?1 AND (m.missionStatus = 'IN_PROGRESS' OR m.missionStatus = 'NEW_TASK')) " +
		       "THEN true ELSE false END")
		boolean isChauffeurInDemandeEntretienInProgressAndMission(Long idConducteur);

   
}
