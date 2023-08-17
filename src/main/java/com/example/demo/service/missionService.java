package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.AffectationVoiture;
//import com.example.demo.dto.MissionDTO;
import com.example.demo.model.Mission;

public interface missionService {
//    List<MissionDTO> getAllMission();
//
//    MissionDTO getMissionById(Long id);
//
//    MissionDTO addMission(MissionDTO MissionDTO);
//
//    MissionDTO updateMission(Long id, MissionDTO MissionDTO);
//
//    void deleteMission(Long id);
	
	
	
	boolean areAllMissionsNewTaskByAffectationVoiture(Long id);
	 List<?> getMissionsByAffectationVoitureId(Long idAffectationVoiture);
	
	 List<?> getAllMission();
	 
	 List<Mission> getAllStartedMission();
	 
	 List<Mission> getAllCanceledMission();
	 
	 List<Mission> getAllConfirmedMission();
	 
	 Mission startMission(Long id);
	 
	 Mission cancelMissionAdmin(Long id);
	 
	 Mission cancelMission(Long id );
	 
	 Mission confirmMission(Long id);

	 Mission getMissionById(Long id);

	 Mission addMission(Mission mission);

	 Mission updateMission(Long id, Mission mission);

	    void deleteMission(Long id);
}
