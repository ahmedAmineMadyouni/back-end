//package com.example.demo.dto;
//
//import java.sql.Date;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Positive;
//
//import com.example.demo.model.Amendes;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class AmendesDTO {
//private long idAmendes;
//	
//	private long numAmendes;
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String detail;
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String type;
//	@NotNull
//    @NotEmpty
//    @NotBlank
//	private String lieu;
//	 @NotNull
//	 @NotBlank
//	 @Positive
//	private float montant;
//	@NotNull
//	@NotBlank
//	@Past(message = "Time must be in the past")
//	private Date dateAmendes;
//	
//	@NotNull
//	ChauffeurDTO chauffeurDto;
//
//	@NotNull
//	VoitureDTO voitureDto;
//	
//	
//	
//	public static AmendesDTO fromEntity(Amendes amendes) {
//		if(amendes==null) {
//			return null;
//		}
//		return AmendesDTO.builder()
//				.idAmendes(amendes.getIdAmendes())
//				.numAmendes(amendes.getNumAmendes())
//				.detail(amendes.getDetail())
//				.type(amendes.getType())
//				.lieu(amendes.getLieu())
//				.montant(amendes.getMontant())
//				.dateAmendes(amendes.getDateAmendes())
//				.chauffeurDto(ChauffeurDTO.fromEntity(amendes.getChauffeur()))
//				.voitureDto(VoitureDTO.fromEntity(amendes.getVoiture()))
//				.build();
//	}
//	
//	
//	public static Amendes toEntity(AmendesDTO amendesDto) {
//		if(amendesDto==null) {
//			return null;
//		}
//		return Amendes.builder()
//				.idAmendes(amendesDto.getIdAmendes())
//				.numAmendes(amendesDto.getNumAmendes())
//				.detail(amendesDto.getDetail())
//				.type(amendesDto.getType())
//				.lieu(amendesDto.getLieu())
//				.montant(amendesDto.getMontant())
//				.chauffeur(ChauffeurDTO.toEntity(amendesDto.getChauffeurDto()))
//				.voiture(VoitureDTO.toEntity(amendesDto.getVoitureDto()))
//				.build();
//	}
//
//}
