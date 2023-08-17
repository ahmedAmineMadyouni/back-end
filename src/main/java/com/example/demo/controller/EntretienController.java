package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.api.EntretienApi;
//import com.example.demo.dto.EntretienDTO;
import com.example.demo.repository.EntretienRepository;
import com.example.demo.service.entretienService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class EntretienController implements EntretienApi{
  
	private entretienService es;
	private EntretienRepository er;
	@Autowired
	public EntretienController(entretienService es,EntretienRepository er) {
		this.er=er;
		this.es = es;
	}
@GetMapping("/test")
public List<Entretien> getAllEntretien(){
	return er.findAll();
}


	@Override
	public List<?> getAllEntretiens() {
		// TODO Auto-generated method stub
		return es.getAllEntretiens();
	}
	@Override
	public Entretien getEntretienById(@Valid Long id) {
		// TODO Auto-generated method stub
		return es.getEntretienById(id);
	}
	@Override
	public Entretien addEntretien(@Valid Entretien Entretien) {
		// TODO Auto-generated method stub
		return es.addEntretien(Entretien);
	}
	@Override
	public Entretien updateEntretien(@Valid Long id, @Valid Entretien Entretien) {
		// TODO Auto-generated method stub
		return es.updateEntretien(id, Entretien);
	}
	@Override
	public void deleteEntretien(@Valid Long id) {
		es.deleteEntretien(id);
		
	}
	@Override
	public Entretien validateDemandeEntretien(@Valid Long id) {
		// TODO Auto-generated method stub
		return es.validateDemnadeEntretien(id);
	}
	@Override
	public boolean chachVoitureStillThereById(@Valid Long id) {
		// TODO Auto-generated method stub
		return es.checkVoitureStillThere(id);
	}
	@Override
	public List<?> getEntretienByIdConducteur(@Valid Long id) {
		// TODO Auto-generated method stub
		return es.getEntretienByIdConducteur(id);
	}
	
	
	
}
