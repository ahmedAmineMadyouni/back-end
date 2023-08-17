package com.example.demo.service.impl;

import java.sql.Date;

import com.example.demo.model.Adresse;
import com.example.demo.model.AffectationVoiture;
import com.example.demo.model.MissionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {
	
    private Long idMission;	
	
	private String titre;
	
	private String type;
	
	@Embedded
	private Adresse adresse;
	
	@Enumerated(EnumType.STRING)
	private MissionStatus missionStatus;
	 
	
	private String description;
	
	
	private Date  dateMission;
	
	private long idAffectationVoiture;
	
	private String affectationVoitureMatricule;
	
	private String affectationVoitureModele;
	
	private String affectationVoitureMarque;
	
	private String affectationVoitureCarteGrise;
	
	private String affectationVoitureChauffeurNom;
	
	private String affectationVoitureUsername;

	private long affectationVoitureChauffeurId;
	
	private long affectationVoitureVoiturePhotoId;
	
	private long affectationVoitureChauffeurPhotoId;

}

