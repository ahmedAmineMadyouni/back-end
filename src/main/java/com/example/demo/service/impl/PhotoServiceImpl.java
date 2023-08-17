package com.example.demo.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.auth.authService.ImageUploadResponse;
import com.example.demo.model.Photo;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.service.PhotoService;
import com.example.demo.utils.ImageEncoder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PhotoServiceImpl  implements PhotoService {
	
	@Autowired
    private PhotoRepository imageRepository;

	public ResponseEntity<ImageUploadResponse> uplaodImage( MultipartFile file)
            throws IOException {

        imageRepository.save(Photo.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageEncoder.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    public Photo getImageDetails(String name) throws IOException {

        final Optional<Photo> dbImage = imageRepository.findByName(name);

        return Photo.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageEncoder.decompressImage(dbImage.get().getImageData())).build();
    }

    
    public ResponseEntity<byte[]> getImage(long name) throws IOException {

//        final Optional<Image> dbImage = imageRepository.findByName(name);
    	 final Optional<Photo> dbImage = imageRepository.findById(name);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageEncoder.decompressImage(dbImage.get().getImageData()));
    }
}
