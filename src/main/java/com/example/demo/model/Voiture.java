package com.example.demo.model;

import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@EqualsAndHashCode // (callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVoiture")
@Entity
@Table
public class Voiture {// extends AbstractEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;

	@Column(name = "MatriculeV", unique = true)
	private String MatriculeV;
	@Column(name = "type")
	private String type;
	@Column(name = "dateCirculation")
	private Date dateCirculation;
	@Column(name = "dateAssurance")
	private Date dateAssurance;
	@Column(name = "dateFinVisite")
	private Date dateFinVisite;
	@Column(name = "CarteGrise")
	private String CarteGrise;
	@Column(name = "libelleMarque")
	private String libelleMarque;
	@Column(name = "libellemodele")
	private String libellemodele;
	
	@Column(name = "nbrCylindre")
	private int nbrCylindre;
	@OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id" )
    private Photo photo;
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToOne(mappedBy = "voiture",cascade = CascadeType.ALL)
	private AffectationVoiture affectationVoiture;
//	@OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
//	private List<Accident> accident;
//	@OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
//	private List<Amendes> amendes;
//	@OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
//	private List<Entretien> entretien;
//	@OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
//	private List<Mission> mission;

}
