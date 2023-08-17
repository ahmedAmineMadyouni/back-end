package com.example.demo.auth.authService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class entretienRequest {

	private String numDemandeAchat;
	private double montant;
}
