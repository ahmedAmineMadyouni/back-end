package com.example.demo.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//(callSuper=false)
@Entity
@Table(name="profile")
public class Profile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;
	
	@NonNull
	@Column(name="username",unique=true)
	private String username;
	
	@Column(name="firstName")
    private String firstName;
	
	@Column(name="lastName")
    private String lastName;
	
	@Column(name="email", unique = true)
    private String email;
	
    @Column(name="password")
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role ; 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Photo photo;
    //@JsonManagedReference
    
    //@JsonIdentityReference(alwaysAsId = false)
	@OneToOne(mappedBy = "profile")
    private Chauffeur chauffeur;
    
    
//fetch = FetchType.EAGER 
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	User user ;

    
   

   }
