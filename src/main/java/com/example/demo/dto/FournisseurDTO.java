//package com.example.demo.dto;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.example.demo.model.Fournisseur;
//import com.example.demo.model.Mission;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//public class FournisseurDTO {
//private long idFournisseur;
//	
//@NotNull
//@NotEmpty
//@NotBlank
//	private String NomSociete;
//	
//@NotNull
//	private AdresseDTO adresseDto;
//	
//	@NotNull
//	@NotBlank
//	private long numTel;
//	
//	@NotEmpty
//	@JsonIgnore
//	private List<EntretienDTO> entretienDto;
//	
//	@NotEmpty
//	@JsonIgnore
//	private List<MaintenanceDTO> maintenanceDto;
//	
//	public static FournisseurDTO fromEntity(Fournisseur fournisseur) {
//		if(fournisseur==null) {
//			return null;
//		}
//		return FournisseurDTO.builder()
//				.idFournisseur(fournisseur.getIdFournisseur())
//				.NomSociete(fournisseur.getNomSociete())
//				.numTel(fournisseur.getNumTel())
//				.adresseDto(AdresseDTO.fromEntity(fournisseur.getAdresse()))
//				.entretienDto(fournisseur.getEntretien()!=null ? fournisseur.getEntretien().stream()
//						.map(EntretienDTO::fromEntity)
//						.collect(Collectors.toList()):null)
//				.maintenanceDto(fournisseur.getMaintenance()!=null? fournisseur.getMaintenance().stream()
//						.map(MaintenanceDTO::fromEntity)
//						.collect(Collectors.toList()):null)
//				.build();
//	}
//
//
//	public static Fournisseur toEntity(FournisseurDTO fournisseurDto) {
//		if(fournisseurDto==null) {
//			return null;
//		}
//		return Fournisseur.builder()
//				.idFournisseur(fournisseurDto.getIdFournisseur())
//				.NomSociete(fournisseurDto.getNomSociete())
//				.numTel(fournisseurDto.getNumTel())
//				.adresse(AdresseDTO.toEntity(fournisseurDto.getAdresseDto()))
//				.entretien(fournisseurDto.getEntretienDto()!=null ? fournisseurDto.getEntretienDto().stream()
//						.map(EntretienDTO::toEntity)
//						.collect(Collectors.toList()):null)
//				.maintenance(fournisseurDto.getMaintenanceDto()!=null? fournisseurDto.getMaintenanceDto().stream()
//						.map(MaintenanceDTO::toEntity)
//						.collect(Collectors.toList()):null)
//				.build();
//	}
//
//}
