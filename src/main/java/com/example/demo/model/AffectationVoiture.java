package com.example.demo.model;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAffectation")
@Entity
@Table(name="AffectationVoiture", uniqueConstraints=@UniqueConstraint(columnNames={"idVoiture", "idConducteur"}))
public class AffectationVoiture{// extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffectation;
	@Column(name="dateFin")
	private Date dateFin;
	@Column(name="dateDebut")
	private Date dateDebut;
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToOne
	@JoinColumn(name="idVoiture", nullable=false)
	private Voiture voiture;
	@OneToOne
	@JoinColumn(name="idConducteur", nullable=false)
	private Chauffeur chauffeur;
	//@JsonIdentityReference(alwaysAsId = true)
//	@OneToMany(mappedBy="affectationVoiture")
//	@JsonIgnore
//	private List<Mission> mission;
//	public List<Mission> getMission() {
//	    return this.mission;
//	}
}
