//package com.example.demo.dto;
//
//import java.time.Instant;
//import java.sql.Date;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
//
//import com.example.demo.model.Entretien;
//import com.example.demo.model.Fournisseur;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class EntretienDTO {
//private long IdEntretien;
//@NotNull
//@NotBlank
//	private Date DateE;
//@NotNull
//@NotBlank
//@Positive
//	private float montant;
//@NotNull
//@NotBlank
//	private long NumDemandeAchat;
//
//@NotNull
//@NotEmpty
//@NotBlank
//	private String libellee;
//@NotNull
//@NotEmpty
//@NotBlank
//	private String detail;
//	@JsonIgnore
//	//@NotNull
//	FournisseurDTO fournisseurDto;
//	@JsonIgnore
//	//@NotNull
//	VoitureDTO voitureDto;
//	
//	
//	public static EntretienDTO fromEntity(Entretien entretien) {
//		if(entretien==null) {
//			return null;
//		}
//		return EntretienDTO.builder()
//				.IdEntretien(entretien.getIdEntretien())
//				.DateE(entretien.getDateE())
//				.montant(entretien.getMontant())
//				.NumDemandeAchat(entretien.getNumDemandeAchat())
//				.libellee(entretien.getLibellee())
//				.detail(entretien.getDetail())
//				.fournisseurDto(FournisseurDTO.fromEntity(entretien.getFournisseur()))
//				.voitureDto(VoitureDTO.fromEntity(entretien.getVoiture()))
//				.build();
//	}
//
//
//	public static Entretien toEntity(EntretienDTO entretienDto) {
//		if(entretienDto==null) {
//			return null;
//		}
//		return Entretien.builder()
//				.IdEntretien(entretienDto.getIdEntretien())
//				.DateE(entretienDto.getDateE())
//				.montant(entretienDto.getMontant())
//				.NumDemandeAchat(entretienDto.getNumDemandeAchat())
//				.libellee(entretienDto.getLibellee())
//				.detail(entretienDto.getDetail())
//				.fournisseur(FournisseurDTO.toEntity(entretienDto.getFournisseurDto()))
//				.voiture(VoitureDTO.toEntity(entretienDto.getVoitureDto()))
//				.build();
//	}
//	
//
//}
