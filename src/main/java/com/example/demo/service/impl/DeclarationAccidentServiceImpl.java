package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.model.AffectationVoiture;
import com.example.demo.model.DeclarationAccident;
import com.example.demo.model.DeclarationAmendes;
import com.example.demo.model.DeclarationStatus;
import com.example.demo.model.Photo;
import com.example.demo.repository.DeclarationAccidentRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.service.DeclarationAccidentService;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeclarationAccidentServiceImpl implements DeclarationAccidentService {
	@Autowired
	private DeclarationAccidentRepository accRepo;
	@Autowired
	private PhotoRepository pRepo;
	

	public DeclarationAccidentServiceImpl(DeclarationAccidentRepository accRepo, PhotoRepository pRepo) {
		super();
		this.accRepo = accRepo;
		this.pRepo = pRepo;
	}

	@Override
	public List<DeclarationAccident> getAllDeclarationAccident() {
		// TODO Auto-generated method stub
		return accRepo.findAll();
	}

	@Override
	public DeclarationAccident getDeclarationAccidentById(Long id) {
		Optional<DeclarationAccident> optionalDeclarationAccident = accRepo.findById(id);
		if (optionalDeclarationAccident.isPresent()) {
			

			return optionalDeclarationAccident.get(); 
		} else {

			throw new EntityNotFoundException("Declaration Accident  not found", ErrorCodes.DECLARATION_ACCIDENT_NOT_FOUND);
		}
		
	}
	
	@Override
	public List<?> getDeclarationNotValide() {
		List<DeclarationAccident> declarationAccidents = accRepo.findByStatusNotValide();
		List<DeclarationAccidentDTO> declarationAccidentDTOs = new ArrayList<>();

		for (DeclarationAccident declarationAccident : declarationAccidents) {
			DeclarationAccidentDTO x =new DeclarationAccidentDTO();
			x.setVoiturePhotoId(declarationAccident.getVoiture().getPhoto().getPhoto_id());
			x.setVoitureModele(declarationAccident.getVoiture().getLibellemodele());
			x.setVoitureMatricule(declarationAccident.getVoiture().getMatriculeV());
			x.setVoitureMarque(declarationAccident.getVoiture().getLibelleMarque());
			x.setVoitureDateCirculation(declarationAccident.getVoiture().getDateCirculation());
			x.setType(declarationAccident.getType());
			x.setStatus(declarationAccident.isStatus());
			x.setPhotoName(declarationAccident.getPhoto().getName());
			x.setNumConstat2(declarationAccident.getNumConstat1());
			x.setNumConstat1(declarationAccident.getNumConstat2());
			x.setLieu(declarationAccident.getLieu());
			x.setIdVoiture(declarationAccident.getVoiture().getIdVoiture());
			x.setIdPhotoDec(declarationAccident.getPhoto().getPhoto_id());
			x.setIdDeclarationAcc(declarationAccident.getIdDeclarationAcc());
			x.setIdChauffeur(declarationAccident.getChauffeur().getIdConducteur());
			x.setDescription(declarationAccident.getDescription());
			x.setDecStatus(declarationAccident.getDecStatus());
			x.setDateDeclaration(declarationAccident.getDateDeclaration());
			x.setDateAcident(declarationAccident.getDateAcident());
			x.setChauffeurUserName(declarationAccident.getChauffeur().getProfile().getUsername());
			x.setChauffeurPrename(declarationAccident.getChauffeur().getPrenom());
			x.setChauffeurPhotoId(declarationAccident.getChauffeur().getPhoto().getPhoto_id());
			x.setChauffeurNumTel(declarationAccident.getChauffeur().getNumTelephone());
			x.setChauffeurNumCNSS(declarationAccident.getChauffeur().getNumCNSS());
			x.setChauffeurName(declarationAccident.getChauffeur().getNom());
			x.setChauffeurEamil(declarationAccident.getChauffeur().getEmail());
			declarationAccidentDTOs.add(x);
		}
		return declarationAccidentDTOs;
	}
	
	@Override
	public List<DeclarationAccident> getDeclarationAccidentByStatus() {
		// TODO Auto-generated method stub
		return accRepo.findByStatus();
	}

	@Override
	public List<?> getDeclarationAccidentByChauffeurId(Long idConducteur) {
		List<DeclarationAccident> accident = accRepo.findByChauffeur(idConducteur);
	    if (accident !=null) {
	    	List<DeclarationAccident> declarationAccidents = accRepo.findByChauffeur(idConducteur);
			List<DeclarationAccidentDTO> declarationAccidentDTOs = new ArrayList<>();

			for (DeclarationAccident declarationAccident : declarationAccidents) {
				DeclarationAccidentDTO x =new DeclarationAccidentDTO();
				x.setVoiturePhotoId(declarationAccident.getVoiture().getPhoto().getPhoto_id());
				x.setVoitureModele(declarationAccident.getVoiture().getLibellemodele());
				x.setVoitureMatricule(declarationAccident.getVoiture().getMatriculeV());
				x.setVoitureMarque(declarationAccident.getVoiture().getLibelleMarque());
				x.setVoitureDateCirculation(declarationAccident.getVoiture().getDateCirculation());
				x.setType(declarationAccident.getType());
				x.setStatus(declarationAccident.isStatus());
				x.setPhotoName(declarationAccident.getPhoto().getName());
				x.setNumConstat2(declarationAccident.getNumConstat1());
				x.setNumConstat1(declarationAccident.getNumConstat2());
				x.setLieu(declarationAccident.getLieu());
				x.setIdVoiture(declarationAccident.getVoiture().getIdVoiture());
				x.setIdPhotoDec(declarationAccident.getPhoto().getPhoto_id());
				x.setIdDeclarationAcc(declarationAccident.getIdDeclarationAcc());
				x.setIdChauffeur(declarationAccident.getChauffeur().getIdConducteur());
				x.setDescription(declarationAccident.getDescription());
				x.setDecStatus(declarationAccident.getDecStatus());
				x.setDateDeclaration(declarationAccident.getDateDeclaration());
				x.setDateAcident(declarationAccident.getDateAcident());
				x.setChauffeurUserName(declarationAccident.getChauffeur().getProfile().getUsername());
				x.setChauffeurPrename(declarationAccident.getChauffeur().getPrenom());
				x.setChauffeurPhotoId(declarationAccident.getChauffeur().getPhoto().getPhoto_id());
				x.setChauffeurNumTel(declarationAccident.getChauffeur().getNumTelephone());
				x.setChauffeurNumCNSS(declarationAccident.getChauffeur().getNumCNSS());
				x.setChauffeurName(declarationAccident.getChauffeur().getNom());
				x.setChauffeurEamil(declarationAccident.getChauffeur().getEmail());
				declarationAccidentDTOs.add(x);
			}
			return declarationAccidentDTOs;
	    }
	    return Collections.emptyList();
	  }
	

	@Override
	public DeclarationAccident addDeclarationAccident(DeclarationAccident declarationAccident, MultipartFile file)
			throws IOException {
		Photo photo = Photo.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.imageData(ImageEncoder.compressImage(file.getBytes())).build();
		photo = pRepo.save(photo);
		declarationAccident.setPhoto(photo);
		declarationAccident.setDecStatus(DeclarationStatus.NOT_APROVED_YET);
		declarationAccident.setStatus(false);
		return accRepo.save(declarationAccident);
	}

	@Override
	public DeclarationAccident updateDeclarationAccident(Long id, DeclarationAccident declarationAccident,
			MultipartFile file) throws IOException {
		
			DeclarationAccident optionalDeclarationAccident =accRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Declaration Accident not found",ErrorCodes.DECLARATION_ACCIDENT_NOT_FOUND));
			if (file != null && !file.isEmpty()) {
		        // Get the associated photo entity
				Optional<Photo> newPhoto = pRepo.findById(optionalDeclarationAccident.getPhoto().getPhoto_id());
		        // Compare the file type and content with the existing photo
		        if ( newPhoto.isPresent() || !newPhoto.get().getType().equals(file.getContentType()) ||
		                !Arrays.equals(newPhoto.get().getImageData(), file.getBytes())) {
		        	newPhoto.get().setImageData(ImageEncoder.compressImage(file.getBytes()));
		        	newPhoto.get().setName(file.getOriginalFilename());
		        	newPhoto.get().setType(file.getContentType());
		        	optionalDeclarationAccident.setPhoto(pRepo.save(newPhoto.get()));
		        }
		    }
			
			if(!optionalDeclarationAccident.isStatus()) {
				optionalDeclarationAccident.setChauffeur(declarationAccident.getChauffeur());
				optionalDeclarationAccident.setVoiture(declarationAccident.getVoiture());
				optionalDeclarationAccident.setDateAcident(declarationAccident.getDateAcident());
				optionalDeclarationAccident.setDateDeclaration(declarationAccident.getDateDeclaration());
				optionalDeclarationAccident.setDescription(declarationAccident.getDescription());
				optionalDeclarationAccident.setLieu(declarationAccident.getLieu());
				optionalDeclarationAccident.setNumConstat1(declarationAccident.getNumConstat1());
				optionalDeclarationAccident.setNumConstat2(declarationAccident.getNumConstat2());
				optionalDeclarationAccident.setType(declarationAccident.getType());
				return accRepo.save(optionalDeclarationAccident);
				
				}else {
					throw new InvalidEntityException("you can not  update approved declaration ");
				}
				
			}

	@Override
	public void deleteDeclarationAccident(Long id) {
		if(accRepo.existsById(id)) {
			accRepo.deleteById(id);
		}else {
			throw new EntityNotFoundException("Declaration Accident not found",ErrorCodes.DECLARATION_ACCIDENT_NOT_FOUND);
		}
	}

	@Override
	public DeclarationAccident cancelDeclaration(Long id) {
		DeclarationAccident x = accRepo.findById(id).orElseThrow(()->new EntityNotFoundException("not found ",ErrorCodes.DECLARATION_ACCIDENT_NOT_FOUND));
		if(x.getDecStatus().equals(DeclarationStatus.NOT_APROVED_YET)) {
			x.setDecStatus(DeclarationStatus.CANCELED);
			return accRepo.save(x);
		}else {
			throw new IllegalStateException("can't find declaration");
		}	
	}
}

