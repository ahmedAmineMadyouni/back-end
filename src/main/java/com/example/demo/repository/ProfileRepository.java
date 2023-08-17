package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Photo;
import com.example.demo.model.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>  {

	boolean existsByEmail(String email);

	Optional<Profile> findByEmail(String email);

	Photo save(Photo photo);

	Optional<Profile> findByUsername(String username);
	
//
//	  Boolean existsByUsername(String username);
//	  @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//				attributePaths = {"authorities"})
//		Optional<Profile> findByUsername(String username);
//		
//		@EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//				attributePaths = {"authorities"})
//		List<Profile> findAll();


}
