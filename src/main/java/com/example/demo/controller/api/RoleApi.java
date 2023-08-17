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
//import com.example.demo.dto.AmendesDTO;
//
//import jakarta.validation.Valid;
//
//public interface RoleApi {
//
//	
//	@GetMapping(value=APP_ROOT+"/Role/all",produces=MediaType.APPLICATION_JSON_VALUE)
//	 List<AmendesDTO> getAllRole();
//	 @GetMapping(value=APP_ROOT+"/Role/{idRole}",produces=MediaType.APPLICATION_JSON_VALUE)
//	    AmendesDTO getRoleById(@PathVariable("idRole")@Valid Long id);
//	 @PostMapping(value= APP_ROOT+"/Role/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	    AmendesDTO addRole(@Valid @RequestBody AmendesDTO AmendesDTO);
//	 @PutMapping(value= APP_ROOT+"/Role/update/{idRole}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	    AmendesDTO updateRole(@Valid @PathVariable("idRole") Long id,@Valid @RequestBody AmendesDTO AmendesDTO);
//	 @DeleteMapping(value=APP_ROOT+"/Role/delete/{idRole}")
//	    void deleteRole(@PathVariable("idRole")@Valid Long id);
//}
