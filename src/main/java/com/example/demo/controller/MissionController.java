package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.api.MissionApi;
import com.example.demo.model.AffectationVoiture;
//import com.example.demo.dto.MissionDTO;
import com.example.demo.model.Mission;
import com.example.demo.service.missionService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class MissionController implements  MissionApi{
private missionService ms;
@Autowired
public MissionController(missionService ms) {
	this.ms = ms;
}


@Override
public List<?> getAllMission() {
	// TODO Auto-generated method stub
	return ms.getAllMission();
}


@Override
public Mission getMissionById(@Valid Long id) {
	// TODO Auto-generated method stub
	return ms.getMissionById(id);
}

@Override
public Mission addMission(@Valid Mission Mission) {
	// TODO Auto-generated method stub
	return ms.addMission(Mission);
}

@Override
public Mission updateMission( Long id, @Valid Mission Mission) {
	// TODO Auto-generated method stub
	return ms.updateMission(id, Mission);
}

@Override
public void deleteMission(@Valid Long id) {
	ms.deleteMission(id);
	
}


@Override
public List<?> findByAffectationVoiture(long id) {
	// TODO Auto-generated method stub
	return ms.getMissionsByAffectationVoitureId(id);
}


@Override
public Mission startMissionById(@Valid Long id) {
	// TODO Auto-generated method stub
	return ms.startMission(id);
}


@Override
public Mission cancelMissionById(@Valid Long id) {
	// TODO Auto-generated method stub
	return ms.cancelMission(id);
}


@Override
public Mission confirmMissionById(@Valid Long id) {
	// TODO Auto-generated method stub
	return ms.confirmMission(id);
}


@Override
public List<Mission> getAllStartedMission() {
	// TODO Auto-generated method stub
	return ms.getAllStartedMission();
}


@Override
public List<Mission> getAllCanceldMission() {
	// TODO Auto-generated method stub
	return ms.getAllCanceledMission();
}


@Override
public List<Mission> getAllConfirmedMission() {
	// TODO Auto-generated method stub
	return ms.getAllConfirmedMission();
}


@Override
public Mission cancelMissionAdminById(@Valid Long id) {
	// TODO Auto-generated method stub
	return ms.cancelMissionAdmin(id);
}


@Override
public boolean getVoitureStatus(Long id) {
	// TODO Auto-generated method stub
	return ms.areAllMissionsNewTaskByAffectationVoiture(id);
}





}
