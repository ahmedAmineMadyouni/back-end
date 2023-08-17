package com.example.demo.auth.authService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseAdmin {

  private String token;
  private String username ;
  private long idPhoto;
  
}
