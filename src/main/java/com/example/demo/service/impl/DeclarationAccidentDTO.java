package com.example.demo.service.impl;

import java.sql.Date;


import com.example.demo.model.DeclarationStatus;
import com.example.demo.model.Photo;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationAccidentDTO {
	
	private long idDeclarationAcc;
	
	private long numConstat1;
	
	private long numConstat2;
	
	private String description;

	private String type;

	private String lieu;

    private long idPhotoDec;
	
	private String photoName;
	
	private Date dateDeclaration;
	
	@Enumerated(EnumType.STRING)
	private DeclarationStatus decStatus;
	
	private boolean status;
	
	private Date dateAcident;
	
	private long chauffeurNumCNSS;
	
	private long chauffeurNumTel;
	
    private long idVoiture;
	
	private long idChauffeur;
	
    private String voitureMarque;
	
	private String voitureModele;
	
	private String voitureMatricule;
	
	private Date voitureDateCirculation;
	
	private String chauffeurName;
	
	private String chauffeurPrename;
	
	private String chauffeurUserName;
	
	private String chauffeurEamil;
	
	private long chauffeurPhotoId;
	
	private long voiturePhotoId;
}