package com.example.demo.service.impl;

import com.example.demo.model.Adresse;
import com.example.demo.model.Photo;
import com.example.demo.model.Profile;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChauffeurDTO {
    private Long idConducteur;
    private String nom;
    private String prenom;
    // Other non-lazy properties
    
    private String password;
    

	@Embedded
	private Adresse adresse;
	private long numCIN;
	
    private String email;
	
	private long numCNSS;
	
	private long numTelephone;
	
    private Long photo;
    private String photoName;
    private Long idProfile;
	private String username;
	
	

    // Getters and setters
}
