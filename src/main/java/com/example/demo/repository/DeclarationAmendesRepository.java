package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationAmendes;

@Repository
public interface DeclarationAmendesRepository extends JpaRepository<DeclarationAmendes,Long>{

	boolean existsByNumAmendes(long numAmendes);
	
	@Query("SELECT d FROM DeclarationAmendes d WHERE d.chauffeur.idConducteur=?1 AND d.status = false ")
	List<DeclarationAmendes> findByChauffeur(Long id );
	
	@Query("SELECT d FROM DeclarationAmendes d WHERE  d.status = true")
	List<DeclarationAmendes> findByStatus( );
	//ziiid where d.decStatus!= CANCELED
	@Query("SELECT d FROM DeclarationAmendes d WHERE  d.status = false AND d.decStatus!= CANCELED ")
	List<DeclarationAmendes> findByStatusNotValide( );
	
	

}
