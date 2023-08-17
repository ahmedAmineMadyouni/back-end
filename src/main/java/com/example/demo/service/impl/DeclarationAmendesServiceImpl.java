package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationAmendes;
import com.example.demo.model.DeclarationAmendesDTO;
import com.example.demo.model.DeclarationStatus;
import com.example.demo.model.DemandeEntretien;
import com.example.demo.model.Photo;
import com.example.demo.model.Voiture;
import com.example.demo.repository.DeclarationAmendesRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.service.DeclarationAmendesService;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class DeclarationAmendesServiceImpl implements DeclarationAmendesService {
	private DeclarationAmendesRepository decRepo;
	private PhotoRepository pRepo;
	

	public DeclarationAmendesServiceImpl(DeclarationAmendesRepository decRepo, PhotoRepository pRepo) {
		super();
		this.decRepo = decRepo;
		this.pRepo = pRepo;
	}

	@Override
	public List<DeclarationAmendes> getAllDeclarationAmendes() {
		return  decRepo.findAll();
	}

	@Override
	public DeclarationAmendes getDeclarationAmendesById(Long id) {
		Optional<DeclarationAmendes> optionalDeclarationAmendes = decRepo.findById(id);
		if (optionalDeclarationAmendes.isPresent()) {
			
			return optionalDeclarationAmendes.get(); 
		} else {

			throw new EntityNotFoundException("Declaration Amendes not found", ErrorCodes.DECLARATION_AMENDES_NOT_FOUND);
		}
	}
	
	
	@Override
	public List<?> getDeclarationAmendesNotValide() {
		List<DeclarationAmendes> declarationAmendes = decRepo.findByStatusNotValide();
		List<DeclarationAmendesDTO> declarationAmendesDTOs = new ArrayList<>();

		for (DeclarationAmendes declarationAmende : declarationAmendes) {
			
			DeclarationAmendesDTO x =new DeclarationAmendesDTO();
			x.setVoiturePhotoId(declarationAmende.getVoiture().getPhoto().getPhoto_id());
			x.setVoitureModele(declarationAmende.getVoiture().getLibellemodele());
			x.setVoitureMatricule(declarationAmende.getVoiture().getMatriculeV());
			x.setVoitureMarque(declarationAmende.getVoiture().getLibelleMarque());
			x.setVoitureDateCirculation(declarationAmende.getVoiture().getDateCirculation());
			x.setType(declarationAmende.getType());
			x.setStatus(declarationAmende.isStatus());
			x.setPhotoName(declarationAmende.getPhoto().getName());
			x.setNumAmendes(declarationAmende.getNumAmendes());
			x.setMontant(declarationAmende.getMontant());
			x.setLieu(declarationAmende.getLieu());
			x.setIdVoiture(declarationAmende.getVoiture().getIdVoiture());
			x.setIdPhotoDec(declarationAmende.getPhoto().getPhoto_id());
			x.setIdDeclarationAmendes(declarationAmende.getIdDeclarationAmendes());
			x.setIdChauffeur(declarationAmende.getChauffeur().getIdConducteur());
			x.setDetail(declarationAmende.getDetail());
			x.setDecStatus(declarationAmende.getDecStatus());
			x.setDatedeclaration(declarationAmende.getDatedeclaration());
			x.setDateAmendes(declarationAmende.getDateAmendes());
			x.setChauffeurUserName(declarationAmende.getChauffeur().getProfile().getUsername());
			x.setChauffeurPrename(declarationAmende.getChauffeur().getPrenom());
			x.setChauffeurPhotoId(declarationAmende.getChauffeur().getPhoto().getPhoto_id());
			x.setChauffeurNumTel(declarationAmende.getChauffeur().getNumTelephone());
			x.setChauffeurNumCNSS(declarationAmende.getChauffeur().getNumCNSS());
			x.setChauffeurName(declarationAmende.getChauffeur().getNom());
			x.setChauffeurEamil(declarationAmende.getChauffeur().getEmail());
			declarationAmendesDTOs.add(x);
		}
		return declarationAmendesDTOs;
	}
	
	@Override
	public List<DeclarationAmendes> getDeclarationAmendesByStatus() {
		// TODO Auto-generated method stub
		return decRepo.findByStatus();
	}
	
	
	
	@Override
	public List<?> getDeclarationAmendesByChauffeur(Long id) {
		List<DeclarationAmendes> amendes = decRepo.findByChauffeur(id);
	    if (amendes !=null) {
	    	List<DeclarationAmendes> declarationAmendes = decRepo.findByChauffeur(id);
			List<DeclarationAmendesDTO> declarationAmendesDTOs = new ArrayList<>();

			for (DeclarationAmendes declarationAmende : declarationAmendes) {
				
				DeclarationAmendesDTO x =new DeclarationAmendesDTO();
				x.setVoiturePhotoId(declarationAmende.getVoiture().getPhoto().getPhoto_id());
				x.setVoitureModele(declarationAmende.getVoiture().getLibellemodele());
				x.setVoitureMatricule(declarationAmende.getVoiture().getMatriculeV());
				x.setVoitureMarque(declarationAmende.getVoiture().getLibelleMarque());
				x.setVoitureDateCirculation(declarationAmende.getVoiture().getDateCirculation());
				x.setType(declarationAmende.getType());
				x.setStatus(declarationAmende.isStatus());
				x.setPhotoName(declarationAmende.getPhoto().getName());
				x.setNumAmendes(declarationAmende.getNumAmendes());
				x.setMontant(declarationAmende.getMontant());
				x.setLieu(declarationAmende.getLieu());
				x.setIdVoiture(declarationAmende.getVoiture().getIdVoiture());
				x.setIdPhotoDec(declarationAmende.getPhoto().getPhoto_id());
				x.setIdDeclarationAmendes(declarationAmende.getIdDeclarationAmendes());
				x.setIdChauffeur(declarationAmende.getChauffeur().getIdConducteur());
				x.setDetail(declarationAmende.getDetail());
				x.setDecStatus(declarationAmende.getDecStatus());
				x.setDatedeclaration(declarationAmende.getDatedeclaration());
				x.setDateAmendes(declarationAmende.getDateAmendes());
				x.setChauffeurUserName(declarationAmende.getChauffeur().getProfile().getUsername());
				x.setChauffeurPrename(declarationAmende.getChauffeur().getPrenom());
				x.setChauffeurPhotoId(declarationAmende.getChauffeur().getPhoto().getPhoto_id());
				x.setChauffeurNumTel(declarationAmende.getChauffeur().getNumTelephone());
				x.setChauffeurNumCNSS(declarationAmende.getChauffeur().getNumCNSS());
				x.setChauffeurName(declarationAmende.getChauffeur().getNom());
				x.setChauffeurEamil(declarationAmende.getChauffeur().getEmail());
				declarationAmendesDTOs.add(x);
			}
			return declarationAmendesDTOs;
	    }
	    return Collections.emptyList();
	}

	@Override
	public DeclarationAmendes addDeclarationAmendes(DeclarationAmendes declarationAmendes, MultipartFile file)
			throws IOException {
		Photo photo = Photo.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.imageData(ImageEncoder.compressImage(file.getBytes())).build();
		photo = pRepo.save(photo);
		declarationAmendes.setPhoto(photo);
		declarationAmendes.setDecStatus(DeclarationStatus.NOT_APROVED_YET);
		declarationAmendes.setStatus(false);
		return decRepo.save(declarationAmendes);
	}

	@Override
	public DeclarationAmendes updateDeclarationAmendes(Long id, DeclarationAmendes declarationAmendes, MultipartFile file)
			throws IOException {
		
		DeclarationAmendes optionalDeclarationAmendes =decRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Declaration Amendes not found",ErrorCodes.DECLARATION_AMENDES_NOT_FOUND));
		if (file != null && !file.isEmpty()) {
	        // Get the associated photo entity
			Optional<Photo> newPhoto = pRepo.findById(optionalDeclarationAmendes.getPhoto().getPhoto_id());
	        // Compare the file type and content with the existing photo
	        if ( newPhoto.isPresent() || !newPhoto.get().getType().equals(file.getContentType()) ||
	                !Arrays.equals(newPhoto.get().getImageData(), file.getBytes())) {
	        	newPhoto.get().setImageData(ImageEncoder.compressImage(file.getBytes()));
	        	newPhoto.get().setName(file.getOriginalFilename());
	        	newPhoto.get().setType(file.getContentType());
	        	optionalDeclarationAmendes.setPhoto(pRepo.save(newPhoto.get()));
	        }
	    }
		if(!optionalDeclarationAmendes.isStatus()) {
			optionalDeclarationAmendes.setChauffeur(declarationAmendes.getChauffeur());
			optionalDeclarationAmendes.setVoiture(declarationAmendes.getVoiture());
			optionalDeclarationAmendes.setDateAmendes(declarationAmendes.getDateAmendes());
			optionalDeclarationAmendes.setDatedeclaration(declarationAmendes.getDatedeclaration());
			optionalDeclarationAmendes.setDetail(declarationAmendes.getDetail());
			optionalDeclarationAmendes.setLieu(declarationAmendes.getLieu());
			optionalDeclarationAmendes.setMontant(declarationAmendes.getMontant());
			optionalDeclarationAmendes.setNumAmendes(declarationAmendes.getNumAmendes());
			optionalDeclarationAmendes.setType(declarationAmendes.getType());
	            return decRepo.save(optionalDeclarationAmendes);
		}else {
			throw new InvalidEntityException("you can not  update approved declaration ");
		}
		
	}

	@Override
	public void deleteDeclarationAmendes(Long id) {
		if(decRepo.existsById(id)) {
			decRepo.deleteById(id);
		}else {
			throw new EntityNotFoundException("Declaration Amendes not found",ErrorCodes.DECLARATION_AMENDES_NOT_FOUND);
		}
		
	}

	@Override
	public DeclarationAmendes cancelDeclaration(Long id) {
		DeclarationAmendes x = decRepo.findById(id).orElseThrow(()->new EntityNotFoundException("not found ",ErrorCodes.DECLARATION_AMENDES_NOT_FOUND));
		if(x.getDecStatus().equals(DeclarationStatus.NOT_APROVED_YET)) {
			x.setDecStatus(DeclarationStatus.CANCELED);
			return decRepo.save(x);
		}else {
			throw new IllegalStateException("can't find declaration");
		}
		
	}

	

	

	

}
