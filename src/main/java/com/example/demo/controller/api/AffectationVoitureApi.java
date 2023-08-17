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

//import com.example.demo.dto.AffectationVoitureDTO;
import com.example.demo.model.AffectationVoiture;

import jakarta.validation.Valid;

public interface AffectationVoitureApi {
//    @GetMapping(value = APP_ROOT + "/affectationvoiture/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    List<AffectationVoitureDTO> getAllAffectationVoitures();
//
//    @GetMapping(value = APP_ROOT
//            + "/affectationvoiture/{idaffectationvoiture}", produces = MediaType.APPLICATION_JSON_VALUE)
//    AffectationVoitureDTO getAffectationVoitureById(@PathVariable("idAffectationVoiture") @Valid Long id);
//
//    @PostMapping(value = APP_ROOT
//            + "/affectationvoiture/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    AffectationVoitureDTO addAffectationVoiture(@Valid @RequestBody AffectationVoitureDTO AffectationVoitureDTO);
//
//    // @PutMapping(value=
//    // APP_ROOT+"/amendes/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    // AffectationVoitureDTO updateAmendes(@Valid @PathVariable("id") Long id,@Valid
//    // @RequestBody AmendesDTO AmendesDTO);
//
//    @DeleteMapping(value = APP_ROOT + "/affectationvoiture/delete/{idaffectationvoiture}")
//    void deleteAffectationVoiture(@PathVariable("idaffectationvoiture") @Valid Long id);
	
	
	 @GetMapping(value = APP_ROOT + "/affectationvoiture/all", produces = MediaType.APPLICATION_JSON_VALUE)
	    List<?> getAllAffectationVoitures();

	    @GetMapping(value = APP_ROOT+ "/affectationvoiture/{idaffectationvoiture}", produces = MediaType.APPLICATION_JSON_VALUE)
	    AffectationVoiture getAffectationVoitureById(@PathVariable("idAffectationVoiture") @Valid Long id);

	    @GetMapping(value = APP_ROOT+ "/affectationvoiture/check/{id}")
	    boolean checkAffectationVoitureById(@PathVariable("id")  Long id);

	    @PostMapping(value = APP_ROOT
	            + "/affectationvoiture/create")
	    AffectationVoiture addAffectationVoiture(@Valid @RequestBody AffectationVoiture affectationVoiture);

	     @PutMapping(value=
	     APP_ROOT+"/AffectationVoiture/update/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	     AffectationVoiture updateAmendes(@Valid @PathVariable("id") Long id,@Valid
	     @RequestBody AffectationVoiture affectationVoiture);

	    @DeleteMapping(value = APP_ROOT + "/affectationvoiture/delete/{idaffectationvoiture}")
	    void deleteAffectationVoiture(@PathVariable("idaffectationvoiture") @Valid Long id);
    
    
    
}
