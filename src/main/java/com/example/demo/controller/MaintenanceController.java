//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.controller.api.MaintenanceApi;
//import com.example.demo.dto.MaintenanceDTO;
//import com.example.demo.service.maintenanceService;
//
//import jakarta.validation.Valid;
//@RestController
//@RequestMapping
//@Validated
//public class MaintenanceController implements MaintenanceApi{
//	private maintenanceService ms;
//	@Autowired
//	public MaintenanceController(maintenanceService ms) {
//		this.ms = ms;
//	}
//	@Override
//	public List<MaintenanceDTO> getAllMaintenace() {
//		// TODO Auto-generated method stub
//		return ms.getAllMaintenace();
//	}
//	@Override
//	public MaintenanceDTO getMaintenaceById(@Valid Long id) {
//		// TODO Auto-generated method stub
//		return ms.getMaintenaceById(id);
//	}
//	@Override
//	public MaintenanceDTO addMaintenace(@Valid MaintenanceDTO MaintenanceDTO) {
//		// TODO Auto-generated method stub
//		return ms.addMaintenace(MaintenanceDTO);
//	}
//	@Override
//	public MaintenanceDTO updateMaintenace(@Valid Long id, @Valid MaintenanceDTO MaintenanceDTO) {
//		// TODO Auto-generated method stub
//		return ms.updateMaintenace(id, MaintenanceDTO);
//	}
//	@Override
//	public void deleteMaintenace(@Valid Long id) {
//		ms.deleteMaintenace(id);
//		
//	}
//}
