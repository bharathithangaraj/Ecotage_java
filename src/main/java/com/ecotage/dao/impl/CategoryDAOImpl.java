package com.ecotage.dao.impl;

import static com.ecotage.util.CommonUtil.CURRENT_TIME;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.CategoryDAO;
import com.ecotage.exception.ProductServiceException;
import com.ecotage.model.Category;
import com.ecotage.repo.CategoryRepository;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.AddCategory;

@Component
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategories() throws ProductServiceException {
		List<Category> categoryList = null;

		try {
			categoryList = categoryRepo.findAll();
			System.out.println(categoryList);

		} catch (Exception px) {

			throw new ProductServiceException("Unable to find categories");
		}
		return categoryList;
	}

	@Override
	public ResponseMessage addCategories(LinkedList<AddCategory> categoryList) throws ProductServiceException {

		ResponseMessage res = new ResponseMessage();

		for (AddCategory categoryItem : categoryList) {
			try {

				Optional<Category> cateEntity = categoryRepo.findByCategoryType(categoryItem.getCategoryType());

				if (cateEntity.isPresent()) {
					cateEntity.get().setCategoryDesc(categoryItem.getCategoryDesc());
					cateEntity.get().setCategoryName(categoryItem.getCategoryName());
					cateEntity.get().setModifiedOn(CURRENT_TIME);
					cateEntity.get().setNavigateTo(categoryItem.getNavigateTo());
					cateEntity.get().setStatus(categoryItem.getStatus());
					categoryRepo.save(cateEntity.get());
				} else {
					Category category = new Category(categoryItem.getCategoryName(), categoryItem.getCategoryType(),
							categoryItem.getCategoryDesc(), categoryItem.getStatus(), CURRENT_TIME, CURRENT_TIME,
							categoryItem.getNavigateTo());

					categoryRepo.save(category);

				}
				res.setMessage("success");
				res.setErrorCode("0000");

			} catch (Exception e) {
				res.setMessage("failure");
				res.setErrorCode("E001");
			}

		}
		return res;

	}
	
	

}
