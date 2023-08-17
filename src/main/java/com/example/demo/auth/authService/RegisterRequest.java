package com.example.demo.auth.authService;


import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	private long idConducteur;
	private String nom;	
	private String prenom;	
	private String photo;
	private long numCIN;
	private long numCNSS;
	private long numTelephone;
    private String email ; 
    private String adresse ; 
	private User user ;
}
