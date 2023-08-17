package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long>{

	
	@Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END " +
		       "FROM DemandeEntretien d " +
		       "WHERE d.fournisseur.idFournisseur = ?1 AND d.completed = IN_PROGRESS")
		boolean isFournisseurInDemandeEntretienInProgress(Long idFournisseur);
}
