package com.ecotage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecotage.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
