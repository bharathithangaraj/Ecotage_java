package com.ecotage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecotage.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByCategoryType(String categoryType);
	

/*	public Optional<CategoryDAO> findByCategoryType(String categoryType);
	
	public List<CategoryDAO> findByCategoryName(String categoryName);*/
	
}
