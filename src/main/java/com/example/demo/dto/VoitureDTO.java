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
//import javax.validation.constraints.Past;
//
//import com.example.demo.model.Voiture;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Builder
//public class VoitureDTO {
//
//	private long idVoiture;
//
//	private long MatriculeV;
//	// @NotNull
//	// @NotEmpty
//	// @NotBlank
//	private final String type;
//
//	// @NotNull
//	// @NotBlank
//	// @Past(message = "Time must be in the past")
//	private final Date dateCirculation;
//	// @NotNull
//	// @NotBlank
//	private final Date dateAssurance;
//	@NotNull
//
//	@NotBlank
//	private final Date dateFinVisite;
//
//	@NotNull
//	@NotBlank
//	private final long CarteGrise;
//	@NotNull
//	@NotBlank
//	private final int nbrCylindre;
//	@NotNull
//	@NotEmpty
//	@NotBlank
//	private final String libellemodele;
//
//	@NotNull
//	@NotEmpty
//	@NotBlank
//	private final String libelleMarque;
//
//
//
//
//	// @NotNull
//	// @NotEmpty
//	private List<AffectationVoitureDTO> affectationVoitureDto;
//	// @NotNull
//	// @NotEmpty
//	private List<AccidentDTO> accidentDto;
//	// @NotNull
//	// @NotEmpty
//	private List<AmendesDTO> amendesDto;
//	// @NotNull
//	// @NotEmpty
//	private List<EntretienDTO> entretienDto;
//	// @NotNull
//	// @NotEmpty
//	private List<MaintenanceDTO> maintenanceDto;
//	// @NotNull
//	// @NotEmpty
//	private List<MissionDTO> missionDto;
//
//	public static VoitureDTO fromEntity(Voiture voiture) {
//		if (voiture == null) {
//			return null;
//		}
//		return VoitureDTO.builder()
//				.idVoiture(voiture.getIdVoiture())
//				.MatriculeV(voiture.getMatriculeV())
//				.type(voiture.getType())
//				.dateCirculation(voiture.getDateCirculation())
//				.dateAssurance(voiture.getDateAssurance())
//				.dateFinVisite(voiture.getDateFinVisite())
//				.CarteGrise(voiture.getCarteGrise())
//				.nbrCylindre(voiture.getNbrCylindre())
//				.libelleMarque(voiture.getLibelleMarque())
//				.libellemodele(voiture.getLibellemodele())
//				.affectationVoitureDto(
//						voiture.getAffectationVoiture() != null ? voiture.getAffectationVoiture().stream()
//								.map(AffectationVoitureDTO::fromEntity)
//								.collect(Collectors.toList()) : null)
//				.accidentDto(voiture.getAccident() != null ? voiture.getAccident().stream()
//						.map(AccidentDTO::fromEntity)
//						.collect(Collectors.toList()) : null)
//				.amendesDto(voiture.getAmendes() != null ? voiture.getAmendes().stream()
//						.map(AmendesDTO::fromEntity)
//						.collect(Collectors.toList()) : null)
//				.entretienDto(voiture.getEntretien() != null ? voiture.getEntretien().stream()
//						.map(EntretienDTO::fromEntity)
//						.collect(Collectors.toList()) : null)
//				.maintenanceDto(voiture.getMaintenance() != null ? voiture.getMaintenance().stream()
//						.map(MaintenanceDTO::fromEntity)
//						.collect(Collectors.toList()) : null)
//				.missionDto(voiture.getMission() != null ? voiture.getMission().stream()
//						.map(MissionDTO::fromEntity)
//						.collect(Collectors.toList()) : null)
//				.build();
//	}
//
//	public static Voiture toEntity(VoitureDTO voitureDto) {
//		if (voitureDto == null) {
//			return null;
//		}
//		return Voiture.builder()
//				.idVoiture(voitureDto.getIdVoiture())
//				.MatriculeV(voitureDto.getMatriculeV())
//				.type(voitureDto.getType())
//				.dateCirculation(voitureDto.getDateCirculation())
//				.dateAssurance(voitureDto.getDateAssurance())
//				.dateFinVisite(voitureDto.getDateFinVisite())
//				.CarteGrise(voitureDto.getCarteGrise())
//				.nbrCylindre(voitureDto.getNbrCylindre())
//				.libelleMarque(voitureDto.getLibelleMarque())
//				.libellemodele(voitureDto.getLibellemodele())
//				// .visite_Technique(Visite_TechniqueDTO.toEntity(voitureDto.getVisite_TechniqueDto()))
//				// .type_Carburant(Type_CarburantDTO.toEntity(voitureDto.getType_CarburantDto()))
//				.affectationVoiture(
//						voitureDto.getAffectationVoitureDto() != null ? voitureDto.getAffectationVoitureDto().stream()
//								.map(AffectationVoitureDTO::toEntity)
//								.collect(Collectors.toList()) : null)
//				.accident(voitureDto.getAccidentDto() != null ? voitureDto.getAccidentDto().stream()
//						.map(AccidentDTO::toEntity)
//						.collect(Collectors.toList()) : null)
//				.amendes(voitureDto.getAmendesDto() != null ? voitureDto.getAmendesDto().stream()
//						.map(AmendesDTO::toEntity)
//						.collect(Collectors.toList()) : null)
//				.entretien(voitureDto.getEntretienDto() != null ? voitureDto.getEntretienDto().stream()
//						.map(EntretienDTO::toEntity)
//						.collect(Collectors.toList()) : null)
//				.maintenance(voitureDto.getMaintenanceDto() != null ? voitureDto.getMaintenanceDto().stream()
//						.map(MaintenanceDTO::toEntity)
//						.collect(Collectors.toList()) : null)
//				.mission(voitureDto.getMissionDto() != null ? voitureDto.getMissionDto().stream()
//						.map(MissionDTO::toEntity)
//						.collect(Collectors.toList()) : null)
//				.build();
//	}
//
//}
