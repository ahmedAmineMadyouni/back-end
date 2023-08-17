//package com.example.demo.dto;
//
//import java.sql.Date;
//import java.time.Instant;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//
//import com.example.demo.model.Accident;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class AccidentDTO {
//	
//    private long idAccident;
//    @NotNull
//	private long numConstat1;
//    @NotNull
//	private long numConstat2;
//    @NotNull
//    @NotEmpty
//    @NotBlank
//	private String detail;
//    @NotNull
//    @NotEmpty
//    @NotBlank
//	private String type;
//    @NotNull
//    @NotEmpty
//    @NotBlank
//	private String lieu;
//    @NotNull
//    @Past(message = "Time must be in the past")
//	private Date dateAcident;
//	
//    @NotNull
//	ChauffeurDTO chauffeurDto;
//	
//    @NotNull
//	VoitureDTO voitureDto;
//	  public static  AccidentDTO fromEntity(Accident accident) {
//		  if(accident==null) {
//			  return null;
//		  }
//		  return AccidentDTO.builder()
//				  .idAccident(accident.getIdAccident())
//				  .numConstat1(accident.getNumConstat1())
//				  .numConstat2(accident.getNumConstat2())
//				  .detail(accident.getDetail())
//				  .type(accident.getType())
//				  .lieu(accident.getLieu())
//				  .dateAcident(accident.getDateAcident())
//				  .chauffeurDto(ChauffeurDTO.fromEntity(accident.getChauffeur()))
//				  .voitureDto(VoitureDTO.fromEntity(accident.getVoiture()))
//				  .build();
//	  }
//	  
//	  
//	  public static Accident toEntity(AccidentDTO accidentDto) {
//		  if(accidentDto==null) {
//			  return null;
//		  }return Accident.builder()
//				  .idAccident(accidentDto.getIdAccident())
//				  .numConstat1(accidentDto.getNumConstat1())
//				  .numConstat2(accidentDto.getNumConstat2())
//				  .detail(accidentDto.getDetail())
//				  .type(accidentDto.getType())
//				  .lieu(accidentDto.getLieu())
//				  .dateAcident(accidentDto.getDateAcident())
//				  .chauffeur(ChauffeurDTO.toEntity(accidentDto.getChauffeurDto()))
//				  .voiture(VoitureDTO.toEntity(accidentDto.getVoitureDto()))
//				  .build();
//		 
//		  
//	  }
//	
//
//	
//	}
