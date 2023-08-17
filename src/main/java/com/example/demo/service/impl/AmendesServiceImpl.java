package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import com.example.demo.dto.AmendesDTO;
//import com.example.demo.dto.ChauffeurDTO;
//import com.example.demo.dto.VoitureDTO;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.Accident;
import com.example.demo.model.Amendes;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationAmendes;
import com.example.demo.model.DeclarationStatus;
import com.example.demo.repository.AmendesRepository;
import com.example.demo.repository.DeclarationAmendesRepository;
import com.example.demo.service.amendesService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AmendesServiceImpl implements amendesService {
	@Autowired
	private  AmendesRepository aRepo;
	@Autowired
	private DeclarationAmendesRepository amRepo;

	public AmendesServiceImpl(AmendesRepository aRepo,DeclarationAmendesRepository amRepo) {
		super();
		this.aRepo = aRepo;
		this.amRepo=amRepo;
	}

	@Override
	public List<?> getAllAmendes() {
		List<Amendes> amendes = aRepo.findAll();
		List<AmendesDTO> amendesDTOs = new ArrayList<>();

		for (Amendes amende : amendes) {
			AmendesDTO amendesDTO = new AmendesDTO();
			amendesDTO.setChauffeurUsername(amende.getChauffeur().getProfile().getUsername());
			amendesDTO.setDateAmendes(amende.getDateAmendes());
			amendesDTO.setDetail(amende.getDetail());
			amendesDTO.setIdAmendes(amende.getIdAmendes());
			amendesDTO.setLieu(amende.getLieu());
			amendesDTO.setNumAmendes(amende.getNumAmendes());
			amendesDTO.setMontant(amende.getMontant());
			amendesDTO.setPhotoId(amende.getPhoto().getPhoto_id());
			amendesDTO.setPhotoName(amende.getPhoto().getName());
			amendesDTO.setType(amende.getType());
			amendesDTO.setIdVoiture(amende.getVoiture().getIdVoiture());
			amendesDTO.setIdConducteur(amende.getChauffeur().getIdConducteur());
			amendesDTO.setVoitureMatricule(amende.getVoiture().getMatriculeV());
			
		    
		    
			amendesDTOs.add(amendesDTO);
		}
		return amendesDTOs;
		
//		return aRepo.findAll().stream().map(AmendesDTO::fromEntity).collect(Collectors.toList());
		//return aRepo.findAll();
	}

	@Override
	public Amendes getAmendesById(Long id) {
		// TODO Auto-generated method stub
		Optional<Amendes> optionalAmendes = aRepo.findById(id);
		if (optionalAmendes.isPresent()) {
//			return  AmendesDTO.fromEntity(optionalAmendes.get());
			return optionalAmendes.get();
			
		} else {

			throw new EntityNotFoundException("amendes not found", ErrorCodes.AMENDES_NOT_FOUND);
		}
	}

	@Override
	public Amendes addAmendes(Amendes amendes) {
		// TODO Auto-generated method stub
		if (aRepo.existsById(amendes.getIdAmendes())) {
			throw new EntityAlreadyExistsException("amendes already exists");
		} else {
//			return AmendesDTO.fromEntity(aRepo.save(AmendesDTO.toEntity(amendesDto)));
			return aRepo.save(amendes);
		}
	}

	@Override
	public Amendes updateAmendes(Long id, Amendes amendes) {
		// TODO Auto-generated method stub
		if (aRepo.existsById(amendes.getIdAmendes())) {
			throw new EntityAlreadyExistsException("amendes already exists");
		} else {
			Optional<Amendes> optionalAmendes = aRepo.findById(id);
			if (optionalAmendes.isPresent()) {
				Amendes opAmendes = optionalAmendes.get();
				opAmendes.setNumAmendes(amendes.getNumAmendes());
				opAmendes.setChauffeur(amendes.getChauffeur());
				opAmendes.setLieu(amendes.getLieu());
				opAmendes.setType(amendes.getType());
				opAmendes.setMontant(amendes.getMontant());
				opAmendes.setDetail(amendes.getDetail());
				opAmendes.setVoiture(amendes.getVoiture());
				opAmendes.setDateAmendes(amendes.getDateAmendes());
				
//				return AmendesDTO.fromEntity(aRepo.save(amendes));
				return aRepo.save(opAmendes);
			} else {
				throw new EntityNotFoundException("amendes not found", ErrorCodes.AMENDES_NOT_FOUND);
			}
		}
	}

	@Override
	public void deleteAmendes(Long id) {
		// TODO Auto-generated method stub
		if (aRepo.existsById(id)) {
			aRepo.deleteById(id);
		} else {
			throw new EntityNotFoundException("amendes not found", ErrorCodes.AMENDES_NOT_FOUND);
		}
	}

	@Override
	public Amendes addValidAmendes(Long id) {
		Amendes acc=new Amendes();
		Optional<DeclarationAmendes> x=amRepo.findById(id);
		if(x.isPresent()&& !x.get().isStatus()) {
			acc.setChauffeur(x.get().getChauffeur());
			acc.setVoiture(x.get().getVoiture());
			acc.setDateAmendes(x.get().getDateAmendes());
			acc.setDetail(x.get().getDetail());
			acc.setLieu(x.get().getLieu());
			acc.setNumAmendes(x.get().getNumAmendes());
			acc.setMontant(x.get().getMontant());
			acc.setPhoto(x.get().getPhoto());
			acc.setType(x.get().getType());
			x.get().setDecStatus(DeclarationStatus.ADMIN_APROVED);
			x.get().setStatus(true);
			amRepo.save(x.get());
				return aRepo.save(acc);
			
		}else {
			throw new EntityNotFoundException("amendes not found", ErrorCodes.AMENDES_NOT_FOUND);
		}
	}

}
