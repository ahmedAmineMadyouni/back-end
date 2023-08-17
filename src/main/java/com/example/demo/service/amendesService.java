package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Accident;
//import com.example.demo.dto.AmendesDTO;
import com.example.demo.model.Amendes;

public interface amendesService {
//    List<AmendesDTO> getAllAmendes();
//
//    AmendesDTO getAmendesById(Long id);
//
//    AmendesDTO addAmendes(AmendesDTO amendesDto);
//
//    AmendesDTO updateAmendes(Long id, AmendesDTO amendesDto);
//
//    void deleteAmendes(Long id);
	
	
	
	   List<?> getAllAmendes();

	   Amendes getAmendesById(Long id);
	   
	   Amendes addValidAmendes(Long id);

	   Amendes addAmendes(Amendes amendes);

	   Amendes updateAmendes(Long id, Amendes amendes);

	    void deleteAmendes(Long id);
}