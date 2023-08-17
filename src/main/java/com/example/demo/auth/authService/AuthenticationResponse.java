package com.example.demo.auth.authService;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String username ;
  private long idConducteur;
  private long idVoiture;
  private long idPhoto;
  private  long idAffectations;
}

