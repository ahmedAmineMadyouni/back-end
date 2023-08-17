package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.dto.AccidentDTO;
//import com.example.demo.dto.ChauffeurDTO;
//import com.example.demo.dto.VoitureDTO;
//import com.example.demo.dto.AccidentMapper;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Accident;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationStatus;
import com.example.demo.model.Entretien;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.repository.AccidentRepository;
import com.example.demo.repository.DeclarationAccidentRepository;
import com.example.demo.service.accidentService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccidentServiceImpl implements accidentService {
	@Autowired
	private  AccidentRepository mRepo;
	@Autowired
	private DeclarationAccidentRepository decRepo;
	public AccidentServiceImpl(AccidentRepository mRepo,DeclarationAccidentRepository decRepo) {
		super();
		this.mRepo = mRepo;
		this.decRepo=decRepo;
	}

	@Override
	public List<?> getAllAccident() {
		List<Accident> accidents = mRepo.findAll();
		List<AccidentDTO> accidentDTOs = new ArrayList<>();

		for (Accident accident : accidents) {
			AccidentDTO accidentDTO = new AccidentDTO();
			accidentDTO.setChauffeurUsername(accident.getChauffeur().getProfile().getUsername());
			accidentDTO.setDateAcident(accident.getDateAcident());
			accidentDTO.setDetail(accident.getDetail());
			accidentDTO.setIdAccident(accident.getIdAccident());
			accidentDTO.setLieu(accident.getLieu());
			accidentDTO.setNumConstat1(accident.getNumConstat1());
			accidentDTO.setNumConstat2(accident.getNumConstat2());
			accidentDTO.setPhotoId(accident.getPhoto().getPhoto_id());
			accidentDTO.setPhotoName(accident.getPhoto().getName());
			accidentDTO.setType(accident.getType());
			accidentDTO.setVoitureMatricule(accident.getVoiture().getMatriculeV());
			accidentDTO.setIdConducteur(accident.getChauffeur().getIdConducteur());
			accidentDTO.setIdVoiture(accident.getVoiture().getIdVoiture());
			
		    
		    
			accidentDTOs.add(accidentDTO);
		}
		return accidentDTOs;
		
//		return mRepo.findAll().stream().map(AccidentDTO::fromEntity).collect(Collectors.toList());
		//return mRepo.findAll();
	}

	@Override
	public Accident getAccidentById(Long id) {
		Optional<Accident> optionalAccident = mRepo.findById(id);
		if (optionalAccident.isPresent()) {
			return optionalAccident.get();
			 
		} else {

			throw new EntityNotFoundException("accident not found", ErrorCodes.ACCIDENT_NOT_FOUND);
		}
	}
	
	
	@Override
	public Accident addValidAccident(Long id) {
		Accident acc=new Accident();
		Optional<DeclarationAccident> x=decRepo.findById(id);
		if(x.isPresent() && !x.get().isStatus()) {
			acc.setChauffeur(x.get().getChauffeur());
			acc.setVoiture(x.get().getVoiture());
			acc.setDateAcident(x.get().getDateAcident());
			acc.setDetail(x.get().getDescription());
			acc.setLieu(x.get().getLieu());
			acc.setNumConstat1(x.get().getNumConstat1());
			acc.setNumConstat2(x.get().getNumConstat2());
			acc.setPhoto(x.get().getPhoto());
			acc.setType(x.get().getType());
			x.get().setStatus(true);
			x.get().setDecStatus(DeclarationStatus.ADMIN_APROVED);
			decRepo.save(x.get());
			return mRepo.save(acc);
		
		}else {
			throw new EntityNotFoundException("Declaration Accident not found", ErrorCodes.DECLARATION_ACCIDENT_NOT_FOUND);
		}
		
		
	}

	@Override
	public Accident addAccident(Accident accident) {
		if (mRepo.existsById(accident.getIdAccident())) {
			throw new EntityAlreadyExistsException("accident already exists");
		} else {
			
			return mRepo.save(accident);
		}
	}

	@Override
	public Accident updateAccident(Long id, Accident accident) {
		// TODO Auto-generated method stub
		if (!mRepo.existsById(accident.getIdAccident())) {
			throw new EntityNotFoundException("accident not found", ErrorCodes.ACCIDENT_NOT_FOUND);
		} else {
			Optional<Accident> optionalAccident = mRepo.findById(id);
			if (optionalAccident.isPresent()) {
				Accident opAccident = optionalAccident.get();
				opAccident.setIdAccident(accident.getIdAccident());
				opAccident.setNumConstat1(accident.getNumConstat1());
				opAccident.setNumConstat2(accident.getNumConstat2());
				opAccident.setLieu(accident.getLieu());
				opAccident.setType(accident.getType());
				opAccident.setChauffeur(accident.getChauffeur());
				opAccident.setDateAcident(accident.getDateAcident());
				opAccident.setDetail(accident.getDetail());
				opAccident.setVoiture(accident.getVoiture());
				return mRepo.save(opAccident);
			} else {
				throw new EntityNotFoundException("accident not found", ErrorCodes.ACCIDENT_NOT_FOUND);
			}
		}
	}

	@Override
	public void deleteAccident(Long id) {
		// TODO Auto-generated method stub
		if (mRepo.existsById(id)) {
			mRepo.deleteById(id);
		} else {
			throw new EntityNotFoundException("accident not found", ErrorCodes.ACCIDENT_NOT_FOUND);
		}
	}

}
