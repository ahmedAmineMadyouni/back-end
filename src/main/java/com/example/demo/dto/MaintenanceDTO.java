//package com.example.demo.dto;
//
//import java.sql.Date;
//import java.time.Instant;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.example.demo.model.Maintenance;
//import com.example.demo.model.Mission;
//
//import jakarta.validation.constraints.Positive;
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//public class MaintenanceDTO {
//private long Idreparation;
//@NotNull
//@NotBlank
//	private Date DateR;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//	private String NatureR;
//	@NotNull
//	@NotBlank
//	@Positive
//	private  float Montant;
//	@NotNull
//	@NotBlank
//	private long numDemandeAchat;
//	
//	@NotNull
//	FournisseurDTO fournisseurDto;
//	
//	@NotNull
//	VoitureDTO voitureDto;
//	
//	
//	public static MaintenanceDTO fromEntity(Maintenance maintenance) {
//		if(maintenance==null) {
//			return null;
//		}
//		return MaintenanceDTO.builder()
//				.Idreparation(maintenance.getIdreparation())
//				.DateR(maintenance.getDateR())
//				.NatureR(maintenance.getNatureR())
//				.Montant(maintenance.getMontant())
//				.numDemandeAchat(maintenance.getNumDemandeAchat())
//				.fournisseurDto(FournisseurDTO.fromEntity(maintenance.getFournisseur()))
//				.voitureDto(VoitureDTO.fromEntity(maintenance.getVoiture()))
//				.build();
//	}
//
//
//	public static Maintenance toEntity(MaintenanceDTO maintenanceDto) {
//		if(maintenanceDto==null) {
//			return null;
//		}
//		return Maintenance.builder()
//				.Idreparation(maintenanceDto.getIdreparation())
//				.DateR(maintenanceDto.getDateR())
//				.NatureR(maintenanceDto.getNatureR())
//				.Montant(maintenanceDto.getMontant())
//				.numDemandeAchat(maintenanceDto.getNumDemandeAchat())
//				.fournisseur(FournisseurDTO.toEntity( maintenanceDto.getFournisseurDto()))
//				.voiture(VoitureDTO.toEntity(maintenanceDto.getVoitureDto()))
//				.build();
//	}
//
//}
