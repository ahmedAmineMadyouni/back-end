package com.example.demo.service.impl;

import java.sql.Date;

import com.example.demo.model.Chauffeur;
import com.example.demo.model.Fournisseur;
import com.example.demo.model.Voiture;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntretienUserDTO {
	
	private long IdEntretien;
	
	private Date dateE;
	
	private double montant;
	
	private String NumDemandeAchat;
	
	private String libellee;
	
	private String detail;
	
	private String type;
	
	private Fournisseur fournisseur;
	
	private String voitureMarque;
	
	private String voitureModele;
	
	private String chauffeurName;
	
	private String chauffeurUserName;
	
	private long chauffeurPhotoId;
	
	private long voiturePhotoId;
}