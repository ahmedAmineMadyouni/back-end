package com.example.demo.model;
import java.sql.Date;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Amendes {//extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAmendes;
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
	@Column(name="dateAmendes")
	private Date dateAmendes;
	
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
