package com.example.demo.model;

import java.time.Instant;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Entretien { //extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdEntretien;
	@Column(name="DateE")
	private Date DateE;
	@Column(name="montant")
	private double montant;
	@Column(name="NumDemandeAchat",unique = true)
	private String NumDemandeAchat;
	@Column(name="libellee")
	private String libellee;
	@Column(name="detail")
	private String detail;
	@Column(name="type")
	private String type;
	@ManyToOne
	@JoinColumn(name="idFournisseur", nullable=false)
	Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name="idVoiture", nullable=false)
	Voiture voiture;
	@ManyToOne
	@JoinColumn(name="idConducteur", nullable=false)
	Chauffeur chauffeur;
	
}
