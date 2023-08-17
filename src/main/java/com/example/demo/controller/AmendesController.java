package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.api.AmendesApi;
import com.example.demo.model.Amendes;
//import com.example.demo.dto.AmendesDTO;
import com.example.demo.service.amendesService;

import jakarta.validation.Valid;
@RestController
@Validated
@RequestMapping
public class AmendesController  implements AmendesApi{
	private amendesService as;
	@Autowired
	public AmendesController(amendesService as) {
		this.as = as;
	}
	@Override
	public List<?> getAllAmendes() {
		// TODO Auto-generated method stub
		return as.getAllAmendes();
	}
	@Override
	public Amendes getAmendesById(@Valid Long id) {
		// TODO Auto-generated method stub
		return as.getAmendesById(id);
	}
	@Override
	public Amendes addAmendes(@Valid Amendes Amendes) {
		// TODO Auto-generated method stub
		return as.addAmendes(Amendes);
	}
	@Override
	public Amendes updateAmendes(@Valid Long id, @Valid Amendes Amendes) {
		// TODO Auto-generated method stub
		return as.updateAmendes(id, Amendes);
	}
	@Override
	public void deleteAmendes(@Valid Long id) {
		as.deleteAmendes(id);
		
	}
	@Override
	public Amendes validateAmendes(@Valid Long id) {
		// TODO Auto-generated method stub
		return as.addValidAmendes(id);
	}
	
	
}
