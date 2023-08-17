package com.example.demo.model;
import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Mission {//extends AbstractEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMission;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="type")
	private String type;
	
	@Embedded
	private Adresse adresse;
	
	@Enumerated(EnumType.STRING)
	private MissionStatus missionStatus;
	
	@Column(name="description")
	private String description;
	
	@Column(name="dateMission")
	private Date  dateMission;
	@ManyToOne()
	@JoinColumn(name="idAffectation", nullable=false)
	private AffectationVoiture affectationVoiture;

}
