package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.utils.Constants.APP_ROOT;
//import com.example.demo.dto.AccidentDTO;
import com.example.demo.model.Accident;

import jakarta.validation.Valid;

public interface AccidentApi {
//	  @GetMapping(value=APP_ROOT+"/accident/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	  List<AccidentDTO> getAllAccident();
//	  @GetMapping(value=APP_ROOT+"/accident/{idAccident}",produces=MediaType.APPLICATION_JSON_VALUE)
//	    AccidentDTO getAccidentById(@PathVariable("idAccident")@Valid Long id);
//	    
//	    @PostMapping(value= APP_ROOT+"/accident/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	    AccidentDTO addAccident(@Valid @RequestBody AccidentDTO AccidentDTO);
//	    @PutMapping(value= APP_ROOT+"/accident/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	    AccidentDTO updateAccident(@Valid @PathVariable("id") Long id, @Valid @RequestBody AccidentDTO AccidentDTO);
//	    @DeleteMapping(value=APP_ROOT+"/accident/delete/{idAccident}")
//	    void deleteAccident(@PathVariable("idAccident")@Valid Long id);
	    
	    
	    
	    
	
	
	@GetMapping(value=APP_ROOT+"/accident/all",produces=MediaType.APPLICATION_JSON_VALUE)	
	List<?> getAllAccident();
		  
	    @GetMapping(value=APP_ROOT+"/accident/{idAccident}",produces=MediaType.APPLICATION_JSON_VALUE)
		Accident getAccidentById(@PathVariable("idAccident")@Valid Long id);
		    
	    @PostMapping(value= APP_ROOT+"/accident/validate/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    Accident validateAccident(@Valid @PathVariable("id") Long id);
	    
	    
	    
		    @PostMapping(value= APP_ROOT+"/accident/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		    Accident addAccident(@Valid @RequestBody Accident accident);
		    
		    @PutMapping(value= APP_ROOT+"/accident/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		    Accident updateAccident(@Valid @PathVariable("id") Long id, @Valid @RequestBody Accident accident);
		    
		    @DeleteMapping(value=APP_ROOT+"/accident/delete/{idAccident}")
		    void deleteAccident(@PathVariable("idAccident")@Valid Long id);
	}