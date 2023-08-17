package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.api.FournisseurApi;
//import com.example.demo.dto.FournisseurDTO;
import com.example.demo.model.Fournisseur;
import com.example.demo.service.fournisseurService;

import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class FournisseurController implements FournisseurApi{
	private fournisseurService fs;
	@Autowired
	public FournisseurController(fournisseurService fs) {
		this.fs = fs;
	}
	@Override
	public List<Fournisseur> getAllFournisseur() {
		// TODO Auto-generated method stub
		return fs.getAllFournisseur();
	}
	@Override
	public Fournisseur getFournisseurById(@Valid Long id) {
		// TODO Auto-generated method stub
		return fs.getFournisseurById(id);
	}
	@Override
	public Fournisseur addFournisseur(@Valid Fournisseur Fournisseur) {
		// TODO Auto-generated method stub
		return fs.addFournisseur(Fournisseur);
	}
	@Override
	public Fournisseur updateFournisseur(@Valid Long id, @Valid Fournisseur Fournisseur) {
		// TODO Auto-generated method stub
		return fs.updateFournisseur(id, Fournisseur);
	}
	@Override
	public void deleteFournisseur(@Valid Long id) {
		fs.deleteFournisseur(id);
		
	}
	@Override
	public boolean checkFournisseur(Long id) {
		// TODO Auto-generated method stub
		return fs.checkFournisseur(id);
	}
	
	
}
