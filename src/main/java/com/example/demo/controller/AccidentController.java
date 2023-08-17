package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.api.AccidentApi;
//import com.example.demo.dto.AccidentDTO;
import com.example.demo.model.Accident;
import com.example.demo.service.accidentService;
import jakarta.validation.Valid;
@RestController
@RequestMapping
@Validated
public class AccidentController implements AccidentApi{
  private accidentService accidentS;
  @Autowired
  public AccidentController(accidentService accidentS ) {
	  this.accidentS=accidentS;
  }
	@Override
	public List<?> getAllAccident() {
		// TODO Auto-generated method stub
		return accidentS.getAllAccident();
	}

	@Override
	public Accident getAccidentById(@Valid Long id) {
		// TODO Auto-generated method stub
		return accidentS.getAccidentById(id);
	}

	@Override
	public Accident addAccident(@Valid Accident accident) {
		// TODO Auto-generated method stub
		return accidentS.addAccident(accident);
	}

	@Override
	public Accident updateAccident(@Valid Long id, @Valid Accident accident) {
		// TODO Auto-generated method stub
		return accidentS.updateAccident(id, accident);
	}

	@Override
	public void deleteAccident(@Valid Long id) {
		// TODO Auto-generated method stub
		accidentS.deleteAccident(id);
	}
	@Override
	public Accident validateAccident(@Valid Long id) {
		// TODO Auto-generated method stub
		return accidentS.addValidAccident(id);
	}

}
