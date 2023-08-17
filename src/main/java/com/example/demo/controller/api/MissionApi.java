package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;

import static com.example.demo.utils.Constants.APP_ROOT2;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.AffectationVoiture;
//import com.example.demo.dto.AmendesDTO;
//import com.example.demo.dto.MissionDTO;
import com.example.demo.model.Mission;

import jakarta.validation.Valid;

public interface MissionApi {
//	@GetMapping(value=APP_ROOT+"/Mission/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<MissionDTO> getAllMission();
//	@GetMapping(value=APP_ROOT+"/Mission/{idMission}",produces=MediaType.APPLICATION_JSON_VALUE)
//	MissionDTO getMissionById(@PathVariable("idMission")@Valid Long id);
//	@PostMapping(value= APP_ROOT+"/Mission/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	MissionDTO addMission(@Valid @RequestBody MissionDTO MissionDTO);
//	@PutMapping(value= APP_ROOT+"/Mission/update/{idMission}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	MissionDTO updateMission(@Valid @PathVariable("idMission") Long id,@Valid @RequestBody MissionDTO MissionDTO);
//	@DeleteMapping(value=APP_ROOT+"/Mission/delete/{idMission}")
//	void deleteMission(@PathVariable("idMission")@Valid Long id);
	
	
	@GetMapping(value=APP_ROOT+"/Mission/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> getAllMission();
	
	@GetMapping(value=APP_ROOT+"/Mission/inProgress/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Mission> getAllStartedMission();
	
	@GetMapping(value=APP_ROOT+"/Mission/canceled/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Mission> getAllCanceldMission();
	
	@GetMapping(value=APP_ROOT+"/Mission/success/all",produces=MediaType.APPLICATION_JSON_VALUE)
	List<Mission> getAllConfirmedMission();
	
	@GetMapping(value=APP_ROOT+"/Mission/{idMission}",produces=MediaType.APPLICATION_JSON_VALUE)
	Mission getMissionById(@PathVariable("idMission")@Valid Long id);
	//used by user
	@PutMapping(value=APP_ROOT2+"/Mission/start/{idMission}",produces=MediaType.APPLICATION_JSON_VALUE)
	Mission startMissionById(@PathVariable("idMission")@Valid Long id);
	//used bu user
	@PutMapping(value=APP_ROOT2+"/Mission/cancel/{idMission}",produces=MediaType.APPLICATION_JSON_VALUE)
	Mission cancelMissionById(@PathVariable("idMission")@Valid Long id);
	
	@PutMapping(value=APP_ROOT+"/Mission/cancelAdmin/{idMission}",produces=MediaType.APPLICATION_JSON_VALUE)
	Mission cancelMissionAdminById(@PathVariable("idMission")@Valid Long id);
	//used by user 
	@PutMapping(value=APP_ROOT2+"/Mission/confirm/{idMission}",produces=MediaType.APPLICATION_JSON_VALUE)
	Mission confirmMissionById(@PathVariable("idMission")@Valid Long id);
	
	@PostMapping(value= APP_ROOT+"/Mission/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	Mission addMission(@Valid @RequestBody Mission mission);
	
	@PutMapping(value= APP_ROOT+"/Mission/update/{idMission}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	Mission updateMission( @PathVariable("idMission") Long id,@Valid @RequestBody Mission mission);
	
	@DeleteMapping(value=APP_ROOT+"/Mission/delete/{idMission}")
	void deleteMission(@PathVariable("idMission")@Valid Long id);
	
	@GetMapping(value=APP_ROOT2+"/Mission/chauffeur/all/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	List<?> findByAffectationVoiture(@PathVariable("id") long id);
	
	@GetMapping(value=APP_ROOT+"/Mission/voitureStatus/{id}")
	boolean getVoitureStatus(@PathVariable("id") Long id);
	
	}
