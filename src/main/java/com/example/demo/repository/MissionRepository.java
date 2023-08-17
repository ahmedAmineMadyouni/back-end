package com.example.demo.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AffectationVoiture;
import com.example.demo.model.DemandeEntretien;
import com.example.demo.model.Mission;
@Repository
public interface MissionRepository extends JpaRepository<Mission,Long>{
	//used by chauffeur to see his  Mission  to start completing it 	
	@Query("SELECT v FROM Mission v WHERE v.affectationVoiture.idAffectation=?1 AND (v.missionStatus=NEW_TASK OR v.missionStatus=IN_PROGRESS)")
	List<Mission> findByAffectationVoiture(Long id);
	
	@Query("SELECT CASE WHEN COUNT(m) > 0 OR COUNT(d) > 0 THEN true ELSE false END " +
		       "FROM Mission m, DemandeEntretien d " +
		       "WHERE (m.missionStatus IN ('IN_PROGRESS', 'NEW_TASK') AND m.affectationVoiture.voiture.idVoiture = :id) " +
		       "OR (d.completed IN ('ADMIN_APPROVED', 'IN_PROGRESS') AND d.voiture.idVoiture = :id)")
		boolean areAllMissionsNewTaskByAffectationVoiture(Long id);
	
	//teeeeeeeest
	@Query("SELECT v FROM Mission v")
	List<Mission> getMission();
	
	
	
	//used by admin to list the successful misions  
	@Query("SELECT d FROM Mission d WHERE    d.missionStatus=SUCCESS")
	List<Mission> findByCompleted( );
	
	//used by admin to list canceled 
	@Query("SELECT d FROM Mission d WHERE   d.missionStatus=CANCELED")
	List<Mission> findByCanceled( );
	
	//used by admin to see in-progress 
	@Query("SELECT d FROM Mission d WHERE   d.missionStatus=IN_PROGRESS")
	List<Mission> findByInProgress( );
	

	
	

}
