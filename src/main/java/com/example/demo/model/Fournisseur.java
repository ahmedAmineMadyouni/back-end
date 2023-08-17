package com.example.demo.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@EqualsAndHashCode()
@Entity
@Table
public class Fournisseur { //extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFournisseur;
	
	@Column(name="nomSociete")
	private String nomSociete;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="numTel")
	private long numTel;
	
//	@OneToMany(mappedBy="fournisseur")
//	private List<Entretien> entretien;
	
	
}
