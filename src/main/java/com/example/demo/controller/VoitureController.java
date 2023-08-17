package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.api.VoitureApi;
//import com.example.demo.dto.VoitureDTO;
import com.example.demo.model.Voiture;
import com.example.demo.service.voitureService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class VoitureController  implements VoitureApi{
	
	private voitureService vs;
	@Autowired
	public VoitureController(voitureService vs) {
		this.vs=vs;
	}
	
	@Override
	public List<Voiture> getAllVoiture() {
		// TODO Auto-generated method stub
		return vs.getAllVoiture();
	}
	
	
	

	@Override
	public List<Voiture> getNotVoiture() {
		// TODO Auto-generated method stub
		return vs.getNOTaffected();
	}

	@Override
	public Voiture getVoitureById(@Valid Long id) {
		// TODO Auto-generated method stub
		return vs.getVoitureById(id);
	}

	@Override
	public Voiture addVoiture(@Valid Voiture Voiture,MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return vs.addVoiture(Voiture,file);
	}

	@Override
	public Voiture updateVoiture( Long id,  Voiture Voiture,MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return vs.updateVoiture(id, Voiture,file);
	}

	@Override
	public void deleteVoiture(@Valid Long id) {
		vs.deleteVoiture(id);
		
	}

}
