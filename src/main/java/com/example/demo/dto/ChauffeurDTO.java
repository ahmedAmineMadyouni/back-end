//package com.example.demo.dto;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.example.demo.model.AffectationVoiture;
//import com.example.demo.model.Chauffeur;
//import com.example.demo.model.Profile;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.ToString;
//	
//	@Data
//	@Builder
//	public class ChauffeurDTO {
//		
//	private long idConducteur;
//		
//	@NotNull
//	@NotEmpty
//	@NotBlank
//		private String Nom;
//		
//	@NotNull
//	@NotEmpty
//	@NotBlank
//		private String prenom;
//		
//	@NotNull
////	@NotEmpty
////	@NotBlank
//	//@Email(message="e-mail not valide ")
//		private String email;
//	
//	
//		
//	    @NotNull
//		private String password;
//		
//	    @NotNull
//		private String photo;
//		
//		
//	     @NotNull
//		 private AdresseDTO adresseDto;
//		@NotNull
//		private long numCIN;
//		@NotNull
//		private long numCNSS;
//		@NotNull
//		private long numTelephone;
//		@NotNull
//		private ProfileDTO profileDto;
//		@NotNull
//		private List<AffectationVoitureDTO> affectationVoitureDto;
//		@NotNull
//		private List<AccidentDTO> accidentDto;
//		@NotNull
//		private List<AmendesDTO> amendesDto;
//		@NotNull
//		private List<MissionDTO> missionDto;
//	
//		
//		public static ChauffeurDTO fromEntity(Chauffeur chauffeur) {
//			if(chauffeur==null) {
//				return null;
//			}
//			return ChauffeurDTO.builder()
//					.idConducteur(chauffeur.getIdConducteur())
//					.Nom(chauffeur.getNom())
//					.prenom(chauffeur.getPrenom())
//					.email(chauffeur.getEmail())
//					.password(chauffeur.getPassword())
//					.photo(chauffeur.getPhoto())
//					.numCIN(chauffeur.getNumCIN())
//					.numCNSS(chauffeur.getNumCNSS())
//					.numTelephone(chauffeur.getNumTelephone())
//					.adresseDto(AdresseDTO.fromEntity(chauffeur.getAdresse()))
//					.profileDto(ProfileDTO.fromEntity(chauffeur.getProfile()))
//					.affectationVoitureDto(
//							chauffeur.getAffectationVoiture()!=null ? 
//									chauffeur.getAffectationVoiture().stream()
//									.map(AffectationVoitureDTO::fromEntity)
//									.collect(Collectors.toList()):null)
//					.accidentDto(chauffeur.getAccident()!=null ? chauffeur.getAccident().stream()
//							.map(AccidentDTO::fromEntity)
//							.collect(Collectors.toList()):null)
//					.amendesDto(chauffeur.getAmendes()!=null ? chauffeur.getAmendes().stream()
//							.map(AmendesDTO::fromEntity)
//							.collect(Collectors.toList()):null)
//					.missionDto(chauffeur.getMission()!=null ? chauffeur.getMission().stream()
//							.map(MissionDTO::fromEntity)
//							.collect(Collectors.toList()):null)
//					.build();
//		}
//		
//		public static Chauffeur toEntity(ChauffeurDTO chauffeurDto) {
//			if(chauffeurDto==null) {
//				return null;
//			}
//			return Chauffeur.builder()
//					.idConducteur(chauffeurDto.getIdConducteur())
//					.Nom(chauffeurDto.getNom())
//					.prenom(chauffeurDto.getPrenom())
//					.email(chauffeurDto.getEmail())
//					.password(chauffeurDto.getPassword())
//					.photo(chauffeurDto.getPhoto())
//					.numCIN(chauffeurDto.getNumCIN())
//					.numCNSS(chauffeurDto.getNumCNSS())
//					.numTelephone(chauffeurDto.getNumTelephone())
//					.adresse(AdresseDTO.toEntity(chauffeurDto.getAdresseDto()))
//					.profile(ProfileDTO.toEntity(chauffeurDto.getProfileDto()))
//					.affectationVoiture(
//							chauffeurDto.getAffectationVoitureDto()!=null ? 
//									chauffeurDto.getAffectationVoitureDto().stream()
//									.map(AffectationVoitureDTO::toEntity)
//									.collect(Collectors.toList()):null)
//					.accident(chauffeurDto.getAccidentDto()!=null ? chauffeurDto.getAccidentDto().stream()
//							.map(AccidentDTO::toEntity)
//							.collect(Collectors.toList()):null)
//					.amendes(chauffeurDto.getAmendesDto()!=null ? chauffeurDto.getAmendesDto().stream()
//							.map(AmendesDTO::toEntity)
//							.collect(Collectors.toList()):null)
//					.mission(chauffeurDto.getMissionDto()!=null ? chauffeurDto.getMissionDto().stream()
//							.map(MissionDTO::toEntity)
//							.collect(Collectors.toList()):null)
//					.build();
//		}
//		
//	}
