package com.example.demo.auth.authController;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.auth.authService.AuthenticationService;
import com.example.demo.auth.authService.ImageUploadResponse;
import com.example.demo.model.Photo;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.utils.ImageEncoder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/api/v1/auth")
@RequiredArgsConstructor
public class ImageController {
	
	@Autowired
	PhotoRepository imageRepository;
	
	 @PostMapping("/upload/image")
	    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
	            throws IOException {

	        imageRepository.save(Photo.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageEncoder.compressImage(file.getBytes())).build());
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(new ImageUploadResponse("Image uploaded successfully: " +
	                        file.getOriginalFilename()));
	    }

	    @GetMapping(path = {"/get/image/info/{name}"})
	    public Photo getImageDetails(@PathVariable("name") long name) throws IOException {

	        //final Optional<Photo> dbImage = imageRepository.findByName(name);
	    	final Optional<Photo> dbImage = imageRepository.findById(name);
	        return Photo.builder()
	                .name(dbImage.get().getName())
	                .type(dbImage.get().getType())
	                .imageData(ImageEncoder.decompressImage(dbImage.get().getImageData())).build();
	    }

	    @GetMapping(path = {"/get/image/{name}"})
	    public ResponseEntity<byte[]> getImage(@PathVariable("name") long name) throws IOException {

//	        final Optional<Image> dbImage = imageRepository.findByName(name);
	    	 final Optional<Photo> dbImage = imageRepository.findById(name);
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.valueOf(dbImage.get().getType()))
	                .body(ImageEncoder.decompressImage(dbImage.get().getImageData()));
	    }
	}