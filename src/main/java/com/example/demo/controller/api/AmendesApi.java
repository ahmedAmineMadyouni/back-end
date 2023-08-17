package com.example.demo.controller.api;

import static com.example.demo.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Accident;
//import com.example.demo.dto.AmendesDTO;
import com.example.demo.model.Amendes;

import jakarta.validation.Valid;

public interface AmendesApi {
//	@GetMapping(value=APP_ROOT+"/amendes/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	 List<AmendesDTO> getAllAmendes();
//	
//	 @GetMapping(value=APP_ROOT+"/amendes/{idamendes}",produces=MediaType.APPLICATION_JSON_VALUE)
//	    AmendesDTO getAmendesById(@PathVariable("idAccident")@Valid Long id);
//	 
//	 @PostMapping(value= APP_ROOT+"/amendes/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	    AmendesDTO addAmendes(@Valid @RequestBody AmendesDTO AmendesDTO);
//	 
//	 @PutMapping(value= APP_ROOT+"/amendes/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	    AmendesDTO updateAmendes(@Valid @PathVariable("id") Long id,@Valid @RequestBody AmendesDTO AmendesDTO);
//	
//	 @DeleteMapping(value=APP_ROOT+"/amendes/delete/{idAmendes}")
//	    void deleteAmendes(@PathVariable("idAmendes")@Valid Long id);
//	 
	 
	 
	 @GetMapping(value=APP_ROOT+"/amendes/all",produces=MediaType.APPLICATION_JSON_VALUE)
	 List<?> getAllAmendes();
	
	 @GetMapping(value=APP_ROOT+"/amendes/{idamendes}",produces=MediaType.APPLICATION_JSON_VALUE)
	 Amendes getAmendesById(@PathVariable("idAccident")@Valid Long id);
	 
	 @PostMapping(value= APP_ROOT+"/amendes/validate/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	 Amendes validateAmendes(@Valid @PathVariable("id") Long id);
	 
	 @PostMapping(value= APP_ROOT+"/amendes/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	 Amendes addAmendes(@Valid @RequestBody Amendes amendes);
	 
	 @PutMapping(value= APP_ROOT+"/amendes/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	 Amendes updateAmendes(@Valid @PathVariable("id") Long id,@Valid @RequestBody Amendes amendes);
	
	 @DeleteMapping(value=APP_ROOT+"/amendes/delete/{idAmendes}")
	    void deleteAmendes(@PathVariable("idAmendes")@Valid Long id);
	}