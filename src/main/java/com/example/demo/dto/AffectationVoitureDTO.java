//package com.example.demo.dto;
//
//import java.sql.Date;
//import java.time.Instant;
//
//import com.example.demo.model.AffectationVoiture;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class AffectationVoitureDTO {
//private long idAffectation;
//	
//	private Date dateFin;
//	private Date dateDebut;
//	
//	
//	VoitureDTO voitureDto;
//	
//	
//	ChauffeurDTO chauffeurDto;
//	
//	
//	MissionDTO missionDto;
//	
//	
//	public static  AffectationVoitureDTO fromEntity(AffectationVoiture affectationVoiture) {
//		if(affectationVoiture==null) {
//			return null;
//		}
//		return AffectationVoitureDTO.builder()
//				.dateDebut(affectationVoiture.getDateDebut())
//				.dateFin(affectationVoiture.getDateFin())
//				.chauffeurDto(ChauffeurDTO.fromEntity(affectationVoiture.getChauffeur()))
//				.missionDto(MissionDTO.fromEntity(affectationVoiture.getMission()))
//				.voitureDto(VoitureDTO.fromEntity(affectationVoiture.getVoiture()))
//				.build();
//	}
//
//	public static  AffectationVoiture toEntity(AffectationVoitureDTO affectationVoitureDto) {
//		if(affectationVoitureDto==null) {
//			return null;
//		}
//		return AffectationVoiture.builder()
//				.dateDebut(affectationVoitureDto.getDateDebut())
//				.dateFin(affectationVoitureDto.getDateFin())
//				.chauffeur(ChauffeurDTO.toEntity(affectationVoitureDto.getChauffeurDto()))
//				.mission(MissionDTO.toEntity(affectationVoitureDto.getMissionDto()))
//				.voiture(VoitureDTO.toEntity(affectationVoitureDto.getVoitureDto()))
//				.build();
//				
//	}
//
//}
