package com.example.demo.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToMany;
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
@EqualsAndHashCode()
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idConducteur")

@Entity
@Table
public class Chauffeur { //extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConducteur;
	@Column(name="Nom")
	private String Nom;
	
	@Column(name="prenom")
	private String prenom;
	
	//jsoniginore
    @Column(name="password")
    private String password;
    
//    @Enumerated(EnumType.STRING)
//    private Role role ; 
	
	@Embedded
	private Adresse adresse;
	@Column(name="numCIN",unique = true)
	private long numCIN;
	
	@Column(name="email", unique = true)
    private String email;
	
	@Column(name="numCNSS",unique = true)
	private long numCNSS;
	
	@Column(name="numTelephone",unique = true)
	private long numTelephone;
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Photo photo;
	
	//@JsonIdentityReference(alwaysAsId = false)
	@JsonIgnore
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;
//	@JsonIdentityReference(alwaysAsId = false)
//	@OneToOne(mappedBy="chauffeur",cascade = CascadeType.ALL)
//	private  AffectationVoiture affectationVoiture;
	
//	@OneToMany(mappedBy="chauffeur" ,cascade = CascadeType.ALL)
//	@JsonBackReference
//	private List<DemandeEntretien> demande;
//	@OneToMany(mappedBy="chauffeur", cascade = CascadeType.ALL)
//	private List<Amendes> amendes;
//	@OneToMany(mappedBy="chauffeur", cascade = CascadeType.ALL)
//	private List<Mission> mission;
}
