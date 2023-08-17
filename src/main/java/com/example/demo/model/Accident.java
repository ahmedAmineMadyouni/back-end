package com.example.demo.model;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//(callSuper=true)
@Entity
@Table(name="accident")
public class Accident {//extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccident;
	@Column(name="numConstat1")
	private long numConstat1;
	@Column(name="numConstat2")
	private long numConstat2;
	@Column(name="detail")
	private String detail;
	@Column(name="type")
	private String type;
	@Column(name="lieu")
	private String lieu;

	@OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
	
	@Column(name="dateAcident")
	private Date dateAcident;
	@ManyToOne
	@JoinColumn(name="idConducteur", nullable=false)
	Chauffeur chauffeur;
	@ManyToOne
	@JoinColumn(name="idVoiture", nullable=false)
	Voiture voiture;
	
	
	
}
