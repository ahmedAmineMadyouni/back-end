package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.api.AccidentApi;
//import com.example.demo.dto.AccidentDTO;
import com.example.demo.model.Accident;
import com.example.demo.model.DeclarationAccident;

public interface accidentService {
//    List<AccidentDTO> getAllAccident();
//
//    AccidentDTO getAccidentById(Long id);
//
//    AccidentDTO addAccident(AccidentDTO accidentDto);
//
//    AccidentDTO updateAccident(Long id, AccidentDTO accidentDto);
//
//    void deleteAccident(Long id);
    List<?> getAllAccident();

    Accident getAccidentById(Long id);
    
    Accident addValidAccident(Long id);

    Accident addAccident(Accident accident);

    Accident updateAccident(Long id, Accident accident);

    void deleteAccident(Long id);
}