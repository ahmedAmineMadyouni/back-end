//package com.example.demo.controller.api;
//
//import static com.example.demo.utils.Constants.APP_ROOT;
//
//import java.util.List;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
////import com.example.demo.dto.MaintenanceDTO;
//
//import jakarta.validation.Valid;
//
//public interface MaintenanceApi {
//	@GetMapping(value=APP_ROOT+"/Maintenance/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	List<MaintenanceDTO> getAllMaintenace();
//	@GetMapping(value=APP_ROOT+"/Maintenance/{idMaintenance}",produces=MediaType.APPLICATION_JSON_VALUE)
//	MaintenanceDTO getMaintenaceById(@PathVariable("idMaintenance")@Valid Long id);
//	@PostMapping(value= APP_ROOT+"/Maintenance/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	MaintenanceDTO addMaintenace(@Valid @RequestBody MaintenanceDTO MaintenanceDTO);
//	@PutMapping(value= APP_ROOT+"/Maintenance/update/{idMaintenance}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	MaintenanceDTO updateMaintenace(@Valid @PathVariable("idMaintenance") Long id,@Valid @RequestBody MaintenanceDTO MaintenanceDTO);
//	@DeleteMapping(value=APP_ROOT+"/Maintenance/delete/{idMaintenance}")
//	void deleteMaintenace(@PathVariable("idMaintenance")@Valid Long id);
//
//
//}