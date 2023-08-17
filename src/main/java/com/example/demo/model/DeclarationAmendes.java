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
public class DeclarationAmendes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDeclarationAmendes;
	@Column(name="numAmendes")
	private long numAmendes;
	@Column(name="detail")
	private String detail;
	@Column(name="type")
	private String type;
	@Column(name="lieu")
	private String lieu;
	@Column(name="montant")
	private float montant;
	@Column(name="datedeclaration")
	private Date datedeclaration;
	@Column(name="dateAmendes")
	private Date dateAmendes;
	
	@Enumerated(EnumType.STRING)
	private DeclarationStatus decStatus;
	
	@Column(name="status")
	private boolean status;
	
	@OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
	@ManyToOne
	@JoinColumn(name="idConducteur", nullable=false)
	Chauffeur chauffeur;
	@ManyToOne
	@JoinColumn(name="idVoiture", nullable=false)
	Voiture voiture;
}
