package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import com.example.demo.dto.AdresseDTO;
//import com.example.demo.dto.AffectationVoitureDTO;
//import com.example.demo.dto.ChauffeurDTO;
//import com.example.demo.dto.MaintenanceDTO;
//import com.example.demo.dto.MissionDTO;
//
//import com.example.demo.dto.VoitureDTO;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.model.Accident;
import com.example.demo.model.AffectationVoiture;
import com.example.demo.model.Mission;
import com.example.demo.model.MissionStatus;
import com.example.demo.repository.AffectationVoitureRepository;
import com.example.demo.repository.MissionRepository;
import com.example.demo.service.missionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MissionServiceImpl implements missionService {
	@Autowired
	private  MissionRepository miRepo;
	@Autowired
	private AffectationVoitureRepository afRepo;

	public MissionServiceImpl(MissionRepository miRepo,AffectationVoitureRepository afRepo) {
		super();
		this.miRepo = miRepo;
		this.afRepo=afRepo;
	}

	@Override
	public List<?> getAllMission() {
		List<Mission> missions = miRepo.findAll();
		List<MissionDTO> missionDTOs = new ArrayList<>();

		for (Mission mission : missions) {
			MissionDTO missionDTO = new MissionDTO();
			missionDTO.setIdMission(mission.getIdMission());
			missionDTO.setAdresse(mission.getAdresse());
			missionDTO.setAffectationVoitureChauffeurNom(mission.getAffectationVoiture().getChauffeur().getNom());
			missionDTO.setType(mission.getType());
			missionDTO.setAffectationVoitureVoiturePhotoId(mission.getAffectationVoiture().getVoiture().getPhoto().getPhoto_id());
			missionDTO.setAffectationVoitureCarteGrise(mission.getAffectationVoiture().getVoiture().getCarteGrise());
			missionDTO.setTitre(mission.getTitre());
			missionDTO.setMissionStatus(mission.getMissionStatus());
			missionDTO.setDescription(mission.getDescription());
			missionDTO.setDateMission(mission.getDateMission());
			missionDTO.setAffectationVoitureChauffeurId(mission.getAffectationVoiture().getChauffeur().getIdConducteur());
			missionDTO.setIdAffectationVoiture(mission.getAffectationVoiture().getIdAffectation());
			missionDTO.setAffectationVoitureChauffeurPhotoId(mission.getAffectationVoiture().getChauffeur().getPhoto().getPhoto_id());
			missionDTO.setAffectationVoitureUsername(mission.getAffectationVoiture().getChauffeur().getProfile().getUsername());
			missionDTO.setAffectationVoitureMarque(mission.getAffectationVoiture().getVoiture().getLibelleMarque());
			missionDTO.setAffectationVoitureMatricule(mission.getAffectationVoiture().getVoiture().getMatriculeV());
			missionDTO.setAffectationVoitureModele(mission.getAffectationVoiture().getVoiture().getLibellemodele());
			
		    
		    
			missionDTOs.add(missionDTO);
		}
		return missionDTOs;
//		return miRepo.findAll().stream().map(MissionDTO::fromEntity).collect(Collectors.toList());
		//return miRepo.findAll();
	}

	@Override
	public Mission getMissionById(Long id) {

		Optional<Mission> optionalMission = miRepo.findById(id);
		if (optionalMission.isPresent()) {
//			return  MissionDTO.fromEntity(optionalMission.get()); 
			return  optionalMission.get(); 
			
		} else {

			throw new EntityNotFoundException("mission not found", ErrorCodes.MISSION_NOT_FOUND);
		}
	}

	@Override
	public Mission addMission(Mission mission) {
		
//		if (miRepo.existsById(mission.getIdMission())) {
//			throw new EntityAlreadyExistsException("mission already exists");
//		} else {
			
//			return MissionDTO.fromEntity(miRepo.save(MissionDTO.toEntity(missionDto)));
		mission.setMissionStatus(MissionStatus.NEW_TASK);
			return miRepo.save(mission);

		//}
	}
	
	//TODO implement a update methode for admin that makes canceld mission newTask again 
	public Mission updateMissionAdmin(Long id ,Mission mission) {
		return null;
	}

	@Override
	public Mission updateMission(Long id, Mission mission) {
		
		Mission miss =miRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("voiture"));
			Optional<Mission> optionalMission = miRepo.findById(id);
			if (optionalMission.isPresent()&& optionalMission.get().getMissionStatus().equals(MissionStatus.NEW_TASK)) {
				
				miss.setTitre(mission.getTitre());
				miss.setType(mission.getType());
				optionalMission.get().setAdresse(mission.getAdresse());
				miss.setDescription(mission.getDescription());
				miss.setDateMission(mission.getDateMission());
				miss.setAffectationVoiture(mission.getAffectationVoiture());
//				opMission.setChauffeur(mission.getChauffeur());
//				opMission.setVoiture(VoitureDTO.toEntity(missionDto.getVoitureDto()));
//				opMission.setAffectationVoiture(missionDto.getAffectationVoitureDto().stream().map(AffectationVoitureDTO::toEntity).collect(Collectors.toList()));
//				return MissionDTO.fromEntity(miRepo.save(mission));
				return miRepo.save(miss);
			} else {
				throw new InvalidEntityException("can't update IN progress Missions", ErrorCodes.MISSION_NOT_FOUND);
			}
		}

	

	@Override
	public void deleteMission(Long id) {
		// TODO Auto-generated method stub
		if (miRepo.existsById(id)) {
			Optional<Mission> mis =miRepo.findById(id);
			if(mis.get().getMissionStatus().equals(MissionStatus.IN_PROGRESS)) {
				throw new InvalidEntityException("can't delete In progress Missions",ErrorCodes.MISSION_NOT_FOUND);
			}else {
				miRepo.deleteById(id);
			}
			
		} else {
			throw new EntityNotFoundException("mission not found", ErrorCodes.MISSION_NOT_FOUND);
		}
	}

	@Override
	public List<?> getMissionsByAffectationVoitureId(Long idAffectationVoiture) {
		Optional<AffectationVoiture> affectationVoiture = afRepo.findById(idAffectationVoiture);
	    if (affectationVoiture.isPresent()) {
			List<Mission> missions = miRepo.findByAffectationVoiture(idAffectationVoiture);
			List<MissionDTO> missionDTOs = new ArrayList<>();

			for (Mission mission : missions) {
				MissionDTO missionDTO = new MissionDTO();
				missionDTO.setIdMission(mission.getIdMission());
				missionDTO.setAdresse(mission.getAdresse());
				missionDTO.setAffectationVoitureChauffeurNom(mission.getAffectationVoiture().getChauffeur().getNom());
				missionDTO.setType(mission.getType());
				missionDTO.setTitre(mission.getTitre());
				missionDTO.setMissionStatus(mission.getMissionStatus());
				missionDTO.setDescription(mission.getDescription());
				missionDTO.setDateMission(mission.getDateMission());
				missionDTO.setAffectationVoitureChauffeurId(mission.getAffectationVoiture().getChauffeur().getIdConducteur());
				missionDTO.setIdAffectationVoiture(mission.getAffectationVoiture().getIdAffectation());
				missionDTO.setAffectationVoitureChauffeurPhotoId(mission.getAffectationVoiture().getChauffeur().getPhoto().getPhoto_id());
				missionDTO.setAffectationVoitureUsername(mission.getAffectationVoiture().getChauffeur().getProfile().getUsername());
				missionDTO.setAffectationVoitureMarque(mission.getAffectationVoiture().getVoiture().getLibelleMarque());
				missionDTO.setAffectationVoitureMatricule(mission.getAffectationVoiture().getVoiture().getMatriculeV());
				missionDTO.setAffectationVoitureModele(mission.getAffectationVoiture().getVoiture().getLibellemodele());
				missionDTO.setAffectationVoitureVoiturePhotoId(mission.getAffectationVoiture().getVoiture().getPhoto().getPhoto_id());
				missionDTO.setAffectationVoitureCarteGrise(mission.getAffectationVoiture().getVoiture().getCarteGrise());
				
				
				missionDTOs.add(missionDTO);
			}
			return missionDTOs;
	    }
	    return Collections.emptyList();
	  }

	@Override
	public Mission startMission(Long id) {
		Optional<Mission> opMission =miRepo.findById(id);
		if(opMission.isPresent()&& opMission.get().getMissionStatus().equals(MissionStatus.NEW_TASK)) {
			opMission.get().setMissionStatus(MissionStatus.IN_PROGRESS);
			return miRepo.save(opMission.get());
		} else {

			throw new EntityNotFoundException("mission not found", ErrorCodes.MISSION_NOT_FOUND);
		}
	}

	@Override
	public Mission cancelMission(Long id) {
		Optional<Mission> opMission =miRepo.findById(id);
		if(opMission.isPresent() && (opMission.get().getMissionStatus().equals(MissionStatus.IN_PROGRESS))) {
			opMission.get().setMissionStatus(MissionStatus.CANCELED);
			return miRepo.save(opMission.get());
		} else {

			throw new EntityNotFoundException("mission not found", ErrorCodes.MISSION_NOT_FOUND);
		}
	}
	
	@Override
	public Mission cancelMissionAdmin(Long id) {
		Optional<Mission> opMission =miRepo.findById(id);
		if(opMission.isPresent() && opMission.get().getMissionStatus().equals(MissionStatus.NEW_TASK)) {
			opMission.get().setMissionStatus(MissionStatus.CANCELED);
			return miRepo.save(opMission.get());
		} else {

			throw new EntityNotFoundException("mission not found", ErrorCodes.MISSION_NOT_FOUND);
		}
	}

	@Override
	public Mission confirmMission(Long id) {
		Optional<Mission> opMission =miRepo.findById(id);
		if(opMission.isPresent()&& opMission.get().getMissionStatus().equals(MissionStatus.IN_PROGRESS)) {
			opMission.get().setMissionStatus(MissionStatus.SUCCESS);
			return miRepo.save(opMission.get());
		} else {

			throw new EntityNotFoundException("mission not found", ErrorCodes.MISSION_NOT_FOUND);
		}
	}

	@Override
	public List<Mission> getAllStartedMission() {
		// TODO Auto-generated method stub
		return miRepo.findByInProgress();
	}

	@Override
	public List<Mission> getAllCanceledMission() {
		// TODO Auto-generated method stub
		return miRepo.findByCanceled();
	}

	@Override
	public List<Mission> getAllConfirmedMission() {
		// TODO Auto-generated method stub
		return miRepo.findByCompleted();
	}

	@Override
	public boolean areAllMissionsNewTaskByAffectationVoiture(Long id) {
		// TODO Auto-generated method stub
		return miRepo.areAllMissionsNewTaskByAffectationVoiture(id);
	}
	}

	

	
	


