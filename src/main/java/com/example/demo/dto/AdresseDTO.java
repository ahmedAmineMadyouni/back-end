//package com.example.demo.dto;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import com.example.demo.model.Adresse;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.Builder;
//import lombok.Data;
//@Data
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class AdresseDTO {
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String adresse1;
//	
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String adresse2;
//	
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String ville;
//	
//	@NotNull
//    @NotEmpty
//    @NotBlank
//    @Size(min=4,max=4)
//	private String codePostal;
//	
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String pays;
//	
//	public static  AdresseDTO fromEntity(Adresse adresse) {
//		if(adresse==null) {
//			return null;
//		}
//		return AdresseDTO.builder()
//				.adresse1(adresse.getAdresse1())
//				.adresse2(adresse.getAdresse2())
//				.codePostal(adresse.getCodePostal())
//				.ville(adresse.getVille())
//				.pays(adresse.getPays())
//				.build();
//	}
//
//	public static  Adresse toEntity(AdresseDTO adresseDto) {
//		if(adresseDto==null) {
//			return null;
//		}
//		return Adresse.builder()
//				.adresse1(adresseDto.getAdresse1())
//				.adresse2(adresseDto.getAdresse2())
//				.codePostal(adresseDto.getCodePostal())
//				.ville(adresseDto.getVille())
//				.pays(adresseDto.getPays())
//				.build();
//	}
//	
//}
