package com.example.demo.service.impl;

import java.sql.Date;

import com.example.demo.model.Adresse;
import com.example.demo.model.Chauffeur;
import com.example.demo.model.Photo;
import com.example.demo.model.Voiture;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccidentDTO {
	
	private Long idAccident;
	
	private long numConstat1;
	
	private long numConstat2;
	
	private String detail;

	private String type;
	
	private String lieu;

	
    private String photoName;
    
    private long photoId;
	
	
	private Date dateAcident;
	
	private long idVoiture;
	private long idConducteur;
	
	private String chauffeurUsername;
	
	private String voitureMatricule;
	
	
	
}
