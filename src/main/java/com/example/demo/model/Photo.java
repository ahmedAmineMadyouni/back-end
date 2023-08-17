package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "photo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photo_id;

    @Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
	private byte[] imageData;

    
}
