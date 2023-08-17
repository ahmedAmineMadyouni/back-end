package com.example.demo.model;

import java.sql.Date;

import com.example.demo.service.impl.DeclarationAccidentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationAmendesDTO {
	private long idDeclarationAmendes;
	
	private long numAmendes;
	
	private String detail;
	
	private String type;

	private String lieu;
	
	private long idPhotoDec;
	
	private String photoName;
	 
	private float montant;

	private Date datedeclaration;

	private Date dateAmendes;
	
	@Enumerated(EnumType.STRING)
	private DeclarationStatus decStatus;
	
	private boolean status;
	

	
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