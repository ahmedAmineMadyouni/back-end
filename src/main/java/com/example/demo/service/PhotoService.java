package com.example.demo.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.auth.authService.ImageUploadResponse;
import com.example.demo.model.Photo;

public interface PhotoService {
	public ResponseEntity<ImageUploadResponse> uplaodImage(MultipartFile file) throws IOException ;
	
	public ResponseEntity<byte[]> getImage(long name) throws IOException ;
	
	public Photo getImageDetails(String name) throws IOException ;
	
}
