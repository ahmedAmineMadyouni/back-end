package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Entretien;
@Repository
public interface EntretienRepository extends JpaRepository<Entretien,Long>{
	
	@Query("SELECT d FROM Entretien d WHERE d.chauffeur.idConducteur=?1 ")
	List<Entretien> findByChauffeur(Long id );

}
