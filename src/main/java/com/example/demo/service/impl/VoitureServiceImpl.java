package com.example.demo.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//
//import com.example.demo.dto.AccidentDTO;
//import com.example.demo.dto.AffectationVoitureDTO;
//import com.example.demo.dto.AmendesDTO;
//import com.example.demo.dto.EntretienDTO;
//import com.example.demo.dto.MaintenanceDTO;
//import com.example.demo.dto.VoitureDTO;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.model.Photo;
import com.example.demo.model.Voiture;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.VoitureRepository;
import com.example.demo.service.voitureService;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class VoitureServiceImpl  implements voitureService{
	
	@Autowired
	private final VoitureRepository vRepo;
	@Autowired
	private PhotoRepository pRepo;
	
	
	public VoitureServiceImpl(VoitureRepository vRepo, PhotoRepository pRepo) {
		this.vRepo=vRepo;
		this.pRepo=pRepo;
	}

	@Override
	public List<Voiture> getAllVoiture() {
//		return  vRepo.findAll().stream().map(VoitureDTO::fromEntity).collect(Collectors.toList());
		return  vRepo.findAll();
	}

	@Override
	public Voiture getVoitureById(Long id) {
		Optional<Voiture> optionalVoiture = vRepo.findById(id);
		if (optionalVoiture.isPresent()) {
			
//			return VoitureDTO.fromEntity(optionalVoiture.get());
			return optionalVoiture.get(); 
		} else {

			throw new EntityNotFoundException("voiture not found", ErrorCodes.VOITURE_NOT_FOUND);
		}
	}
	
	
	

//	@Override
//	public Voiture addVoiture(Voiture voiture) {
//		if (vRepo.existsById(voiture.getIdVoiture())) {
//			throw new EntityAlreadyExistsException("voiture already exists");
//		} else {
//			return vRepo.save(voiture);
//
//		}
//	}

	@Override
	public List<Voiture> getNOTaffected() {
		// TODO Auto-generated method stub
		return vRepo.getNotAffectedVoiture();
	}

	@Override
	public Voiture updateVoiture(Long id, Voiture voiture,MultipartFile file) throws IOException {
		Voiture existingVoit = vRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("voiture"));
		if (file != null && !file.isEmpty()) {
	        // Get the associated photo entity
			Optional<Photo> newPhoto = pRepo.findById(existingVoit.getPhoto().getPhoto_id());
	        // Compare the file type and content with the existing photo
	        if ( newPhoto.isPresent() || !newPhoto.get().getType().equals(file.getContentType()) ||
	                !Arrays.equals(newPhoto.get().getImageData(), file.getBytes())) {
	        	newPhoto.get().setImageData(ImageEncoder.compressImage(file.getBytes()));
	        	newPhoto.get().setName(file.getOriginalFilename());
	        	newPhoto.get().setType(file.getContentType());
	            existingVoit.setPhoto(pRepo.save(newPhoto.get()));
	        }
	    }
		existingVoit.setMatriculeV(voiture.getMatriculeV());
		existingVoit.setCarteGrise(voiture.getCarteGrise());
		existingVoit.setNbrCylindre(voiture.getNbrCylindre());
		existingVoit.setLibellemodele(voiture.getLibellemodele());
		existingVoit.setDateAssurance(voiture.getDateAssurance());
		existingVoit.setDateCirculation(voiture.getDateCirculation());
		existingVoit.setDateFinVisite(voiture.getDateFinVisite());
		existingVoit.setLibelleMarque(voiture.getLibelleMarque());
		existingVoit.setType(voiture.getType());
		return vRepo.save(existingVoit);
//		existingVoit.setAccident(voiture.getAccident());
//		existingVoit.setAmendes(voiture.getAmendesDto().stream().map(AmendesDTO::toEntity).collect(Collectors.toList()));
//		existingVoit.setMaintenance(voitureDto.getMaintenanceDto().stream().map(MaintenanceDTO::toEntity).collect(Collectors.toList()));
//		existingVoit.setAffectationVoiture(voitureDto.getAffectationVoitureDto().stream().map(AffectationVoitureDTO::toEntity).collect(Collectors.toList()));
//		existingVoit.setEntretien(voitureDto.getEntretienDto().stream().map(EntretienDTO::toEntity).collect(Collectors.toList()));
//		return VoitureDTO.fromEntity(vRepo.save(existingVoit));
		
	}

	@Override
	public void deleteVoiture(Long id) {
		if(vRepo.existsById(id)) {
			vRepo.deleteById(id);
		}else {
			throw new EntityNotFoundException("voiture not found",ErrorCodes.VOITURE_NOT_FOUND);
		}
		
	}

	@Override
	public Voiture addVoiture(Voiture voiture, MultipartFile file) throws IOException {
		Photo photo = Photo.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.imageData(ImageEncoder.compressImage(file.getBytes())).build();
		photo = pRepo.save(photo);
		voiture.setPhoto(photo);
		
		return vRepo.save(voiture);
	}

}
