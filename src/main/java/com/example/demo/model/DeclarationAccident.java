package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@EqualsAndHashCode//(callSuper=true)
@Entity
@Table
public class DeclarationAccident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDeclarationAcc;
	@Column(name="numConstat1")
	private long numConstat1;
	@Column(name="numConstat2")
	private long numConstat2;
	@Column(name="description")
	private String description;
	@Column(name="type")
	private String type;
	@Column(name="lieu")
	private String lieu;
	@OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
	
	@Column(name="dateDeclaration")
	private Date dateDeclaration;
	
	@Enumerated(EnumType.STRING)
	private DeclarationStatus decStatus;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="dateAcident")
	private Date dateAcident;
	@ManyToOne
	@JoinColumn(name="idConducteur", nullable=false)
	Chauffeur chauffeur;
	@ManyToOne
	@JoinColumn(name="idVoiture", nullable=false)
	Voiture voiture;
}
