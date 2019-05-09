package com.ecotage.response.dao;

import java.util.List;

public class CategoryRes {

	
		private String categoryName;
		private Long categoryId;
		private String categoryType;
		private String cateUrl;
		private ResponseMessage responseMsg;
		private List<ProductRes> productResList;
		
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public Long getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryType() {
			return categoryType;
		}
		public void setCategoryType(String categoryType) {
			this.categoryType = categoryType;
		}
		public String getCateUrl() {
			return cateUrl;
		}
		public void setCateUrl(String cateUrl) {
			this.cateUrl = cateUrl;
		}
		public ResponseMessage getResponseMsg() {
			return responseMsg;
		}
		public void setResponseMsg(ResponseMessage responseMsg) {
			this.responseMsg = responseMsg;
		}
		public List<ProductRes> getProductResList() {
			return productResList;
		}
		public void setProductResList(List<ProductRes> productResList) {
			this.productResList = productResList;
		}
		
		
		
		
		
		
}
