package com.example.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@Entity
@Table
public class DemandeEntretien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdDemandeEntretien;
	@Column(name="dateDemandes")
	private Date dateDemandes;
	
	@Column(name="obligation")
	private String obligation;
	
	@Column(name="description")
	private String description;
	@Column(name="type")
	private String type;
	
	@Column(name="NumDemandeAchat",unique = true)
	private String NumDemandeAchat;
	
	@Column(name="montant")
	private double montant= 0.0;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idFournisseur", nullable=true)
	Fournisseur fournisseur;
	//,cascade = CascadeType.ALL
	@Enumerated(EnumType.STRING)
	private EntretienCompletation completed;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idConducteur", nullable=false)
	
	Chauffeur chauffeur;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idVoiture", nullable=false)
	Voiture voiture;

}
