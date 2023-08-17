package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long>{

	@Query("SELECT v FROM Voiture v WHERE v.idVoiture NOT IN (SELECT a.voiture.idVoiture FROM AffectationVoiture a)")
	List<Voiture> getNotAffectedVoiture();
}
