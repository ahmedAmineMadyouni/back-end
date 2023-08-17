package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AffectationVoiture;
@Repository
public interface AffectationVoitureRepository extends JpaRepository<AffectationVoiture,Long>{

	
	@Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM Mission v WHERE v.affectationVoiture.voiture.idVoiture = ?1 AND v.missionStatus IN ('NEW_TASK', 'IN_PROGRESS')) OR EXISTS (SELECT 1 FROM DemandeEntretien d WHERE d.voiture.idVoiture = ?1 AND d.completed IN ('ADMIN_APPROVED', 'IN_PROGRESS')) THEN true ELSE false END")
	boolean areAffectationVoiture(Long id);
	
	@Query("SELECT v.idAffectation FROM AffectationVoiture v WHERE v.chauffeur.idConducteur=?1 ")
	Long getIdconducteurFromAffectation(Long id);
	
	@Query("SELECT v.voiture.idVoiture FROM AffectationVoiture v WHERE v.chauffeur.idConducteur=?1 ")
	Long getIdVoitureFromAffectation(Long id);

	
}
