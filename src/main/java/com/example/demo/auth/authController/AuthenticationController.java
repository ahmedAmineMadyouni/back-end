package com.example.demo.auth.authController;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.auth.authService.AuthenticationRequest;
import com.example.demo.auth.authService.AuthenticationService;
//import com.example.demo.model.Personne;
import com.example.demo.model.Profile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
 

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Profile request) {
      return ResponseEntity.ok(service.register(request));
    }
   
    
    @PostMapping("/register/Admin")
    public ResponseEntity<?> registerAdmin( Profile request, MultipartFile file) throws IOException  {
      return ResponseEntity.ok(service.registerAdmin(request,file));
    }
   
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
      return ResponseEntity.ok(service.authenticate(request));
    }
    
    @PostMapping("/authenticateAdmin")
    public ResponseEntity<?> authenticateAdmin(@RequestBody AuthenticationRequest request) {
      return ResponseEntity.ok(service.authenticateAdmin(request));
    }
}
