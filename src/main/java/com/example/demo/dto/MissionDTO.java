//package com.example.demo.dto;
//
//import java.sql.Date;
//import java.time.Instant;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.example.demo.model.Mission;
////import com.example.demo.model.Type_Carburant;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//public class MissionDTO {
//private long idMission;
//@NotNull
//@NotEmpty
//@NotBlank
//	private String titre;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//	private String type;
//	
//	@NotNull
//	private AdresseDTO adresseDto;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//	private String description;
//	@NotNull
//	@NotBlank
//	private Date dateMission;
//	
//	@NotNull
//	ChauffeurDTO chauffeurDto;
//	
//	@NotNull
//	VoitureDTO voitureDto;
//	@NotNull
//	@NotEmpty
//	private List<AffectationVoitureDTO> affectationVoitureDto;
//	
//	
//	
//	public static MissionDTO fromEntity(Mission mission) {
//		if(mission==null) {
//			return null;
//		}
//		return MissionDTO.builder()
//				.idMission(mission.getIdMission())
//				.titre(mission.getTitre())
//				.type(mission.getType())
//				.adresseDto(AdresseDTO.fromEntity(mission.getAdresse()))
//				.description(mission.getDescription())
//				.dateMission(mission.getDateMission())
//				.chauffeurDto(ChauffeurDTO.fromEntity(mission.getChauffeur()))
//				.voitureDto(VoitureDTO.fromEntity(mission.getVoiture()))
//				.affectationVoitureDto(mission.getAffectationVoiture()!=null?mission.getAffectationVoiture().stream()
//						.map(AffectationVoitureDTO::fromEntity)
//						.collect(Collectors.toList()):null)
//				.build();
//	}
//
//
//	public static Mission toEntity(MissionDTO missionDto) {
//		if(missionDto==null) {
//			return null;
//		}
//		return Mission.builder()
//				.idMission(missionDto.getIdMission())
//				.titre(missionDto.getTitre())
//				.type(missionDto.getType())
//				.adresse(AdresseDTO.toEntity(missionDto.getAdresseDto()))
//				.description(missionDto.getDescription())
//				.dateMission(missionDto.getDateMission())
//				.chauffeur(ChauffeurDTO.toEntity(missionDto.getChauffeurDto()))
//				.voiture(VoitureDTO.toEntity(missionDto.getVoitureDto()))
//				.affectationVoiture(missionDto.getAffectationVoitureDto()!=null?missionDto.getAffectationVoitureDto().stream()
//						.map(AffectationVoitureDTO::toEntity)
//						.collect(Collectors.toList()):null)
//				.build();
//	}
//
//}
