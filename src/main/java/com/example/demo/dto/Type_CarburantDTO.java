//package com.example.demo.dto;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
//
//import com.example.demo.model.Type_Carburant;
//import com.example.demo.model.Visite_Technique;
//import com.example.demo.model.Voiture;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//public class Type_CarburantDTO {
//private long idCarburant;
//	
//@NotNull
//@NotEmpty
//@NotBlank
//	private String libellecarburant;
//	
//@NotNull
//@NotBlank
//@Positive
//	private float prix;
//	
//@NotNull
//@NotBlank
//@Positive
//	private int QteBon;
//	
//@NotNull
//@NotEmpty
//	private List<VoitureDTO> voitureDto;
//
//
//public static Type_CarburantDTO fromEntity(Type_Carburant type_Carburant) {
//	if(type_Carburant==null) {
//		return null;
//	}
//	return Type_CarburantDTO.builder()
//			.idCarburant(type_Carburant.getIdCarburant())
//			.libellecarburant(type_Carburant.getLibellecarburant())
//			.prix(type_Carburant.getPrix())
//			.QteBon(type_Carburant.getQteBon())
//			.voitureDto(type_Carburant.getVoiture()!=null?type_Carburant.getVoiture().stream()
//					.map(VoitureDTO::fromEntity)
//					.collect(Collectors.toList()):null)
//			.build();
//}
//
//
//public static Type_Carburant toEntity(Type_CarburantDTO type_CarburantDto) {
//	if(type_CarburantDto==null) {
//		return null;
//	}
//	return Type_Carburant.builder()
//			.idCarburant(type_CarburantDto.getIdCarburant())
//			.libellecarburant(type_CarburantDto.getLibellecarburant())
//			.prix(type_CarburantDto.getPrix())
//			.QteBon(type_CarburantDto.getQteBon())
//			.voiture(type_CarburantDto.getVoitureDto()!=null?type_CarburantDto.getVoitureDto().stream()
//					.map(VoitureDTO::toEntity)
//					.collect(Collectors.toList()):null)
//			.build();
//}
//
//}
