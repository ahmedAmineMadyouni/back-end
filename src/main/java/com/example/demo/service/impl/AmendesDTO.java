package com.example.demo.service.impl;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmendesDTO {

	private Long idAmendes;
	
	private long numAmendes;
	
	private float montant;
	
	private String detail;

	private String type;
	
	private String lieu;

	
    private String photoName;
    
    private long photoId;
	
	
	private Date dateAmendes;
	
	private long idVoiture;
	
	private long idConducteur;
	
	private String chauffeurUsername;
	
	private String voitureMatricule;
	
	
	
}