package com.ecotage.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.Category;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCategory;

@Service
public interface CategoryDAO {
	
	public List<Category> getAllCategories() throws ProductServiceException;
	
	public ResponseMessage addCategories(LinkedList<AddCategory>  categoryList)  throws ProductServiceException;
	

}
