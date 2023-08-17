package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Amendes;
@Repository
public interface AmendesRepository extends JpaRepository<Amendes,Long>{

}
