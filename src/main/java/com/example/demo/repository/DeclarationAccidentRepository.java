package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DeclarationAccident;

@Repository
public interface DeclarationAccidentRepository extends JpaRepository<DeclarationAccident,Long> {

	boolean existsByDateDeclaration(Date dateDeclaration);
	
	@Query("SELECT d FROM DeclarationAccident d WHERE d.chauffeur.idConducteur=?1 AND d.status = false")
	List<DeclarationAccident> findByChauffeur(Long id );
	
	@Query("SELECT d FROM DeclarationAccident d WHERE d.status=true")
	List<DeclarationAccident> findByStatus( );
	
	@Query("SELECT d FROM DeclarationAccident d WHERE d.status=false AND d.decStatus!= CANCELED")
	List<DeclarationAccident> findByStatusNotValide( );

}
