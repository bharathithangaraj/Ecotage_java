package com.ecotage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
	Optional<Image> findByImageUrl(String imageUrl);

}
