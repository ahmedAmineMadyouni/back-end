package com.example.demo.service.impl;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffectationDTO {
	private Long idAffectation;

	private Date dateFin;

	private Date dateDebut;
	
	private long idVoiture;
	
	private long idChauffeur;
	
    private String voitureMarque;
	
	private String voitureModele;
	
	private String chauffeurName;
	
	private String chauffeurUserName;
	
	private String chauffeurEamil;
	
	private long chauffeurPhotoId;
	
	private long voiturePhotoId;
}