package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.api.AffectationVoitureApi;
//import com.example.demo.dto.AffectationVoitureDTO;
import com.example.demo.model.AffectationVoiture;
import com.example.demo.service.affectationVoitureService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping
public class AffectationVoitureController implements AffectationVoitureApi {
    private affectationVoitureService af;

    @Autowired
    public AffectationVoitureController(affectationVoitureService af) {
        this.af = af;
    }

    @Override
    public List<?> getAllAffectationVoitures() {
        // TODO Auto-generated method stub
        return af.getAllAffectationVoitures();

    }

    @Override
    public AffectationVoiture getAffectationVoitureById(@Valid Long id) {
        // TODO Auto-generated method stub
        return af.getAffectationVoitureById(id);

    }

    @Override
    public AffectationVoiture addAffectationVoiture(@Valid AffectationVoiture AffectationVoiture) {
        // TODO Auto-generated method stub
        return af.addAffectationVoiture(AffectationVoiture);
    }

    @Override
    public void deleteAffectationVoiture(@Valid Long id) {
        // TODO Auto-generated method stub
        af.deleteAffectationVoiture(id);
    }

	@Override
	public AffectationVoiture updateAmendes(@Valid Long id, @Valid AffectationVoiture affectationVoiture) {
		// TODO Auto-generated method stub
		return af.updateAffectationVoiture(id, affectationVoiture);
	}

	@Override
	public boolean checkAffectationVoitureById( Long id) {
		// TODO Auto-generated method stub
		return af.checkAffectationVoiture(id);
	}

}
