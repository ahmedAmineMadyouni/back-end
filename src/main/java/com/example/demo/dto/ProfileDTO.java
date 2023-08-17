//package com.example.demo.dto;
//
//import java.time.Instant;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.example.demo.model.Chauffeur;
//import com.example.demo.model.Profile;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import jakarta.validation.constraints.Size;
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class ProfileDTO {
//	private Long profile_id;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//	@Size(max = 20)
//	private String username;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//    
//    private String firstName;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//    private String lastName;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//    private String email;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//    private String password;
//    @NotEmpty
//	ChauffeurDTO chauffeurDto;
//    
//    public static ProfileDTO fromEntity(Profile profile) {
//    	if(profile==null) {
//    		return null;
//    	}
//    	return ProfileDTO.builder()
//    			.profile_id(profile.getProfile_id())
//    			.firstName(profile.getFirstName())
//    			.lastName(profile.getLastName())
//    			.email(profile.getEmail())
//    			.password(profile.getPassword())
//    			.chauffeurDto(ChauffeurDTO.fromEntity(profile.getChauffeur()))
//    			.build();
//    }
//
//    
//    public static Profile toEntity (ProfileDTO profileDto) {
//    	if(profileDto==null) {
//    		return null;
//    	}
//    	return Profile.builder()
//    			.profile_id(profileDto.getProfile_id())
//    			.firstName(profileDto.getFirstName())
//    			.lastName(profileDto.getLastName())
//    			.email(profileDto.getEmail())
//    			.password(profileDto.getPassword())
//    			.chauffeur(ChauffeurDTO.toEntity(profileDto.getChauffeurDto()))
//    			.build();
//    }
//}
