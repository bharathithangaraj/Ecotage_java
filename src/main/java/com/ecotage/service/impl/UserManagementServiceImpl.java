package com.ecotage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.UserManagementDAO;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.service.UserManagementService;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.AddUserDetails;
import com.ecotage.vo.ShowUser;

@Component
public class UserManagementServiceImpl implements UserManagementService {
	
	Logger log = LoggerFactory.getLogger(UserManagementServiceImpl.class);
	
	@Autowired
	UserManagementDAO userDao;

	@Override
	public ShowUser createUser(AddUser userDetail) throws ResourceNotFoundException, UserManagementException {
		
		ShowUser addedUser;
		try {
			addedUser = userDao.createUser(userDetail);
			log.info("add User datail",userDetail);
		} catch(Exception ex) {
			throw new UserManagementException("Unable to add User");
		}
		return addedUser;
	}

	@Override
	public ShowUser getUserAdditionalInfo(String loginId, String access_token) throws ResourceNotFoundException, UserManagementException {
		
		ShowUser addedUser;
		try {
			addedUser = userDao.getUserAdditionalInfo(loginId, access_token);
			log.info("add User datail",loginId);
		} catch(Exception ex) {
			throw new UserManagementException("Unable to add User");
		}
		return addedUser;
	}

	@Override
	public ShowUser loginUser(String loginId, String password)
			throws ResourceNotFoundException, UserManagementException {
		
		ShowUser addedUser;
		try {
			addedUser = userDao.loginUser(loginId,password);
			log.info("add User datail",loginId);
		} catch(Exception ex) {
			throw new UserManagementException("Unable to add User");
		}
		return addedUser;
	}

	@Override
	public ShowUser addUserDetails(AddUserDetails userDetail)
			throws ResourceNotFoundException, UserManagementException {
	
		ShowUser addUserDetail;
		try {
			addUserDetail = userDao.addUserDetails(userDetail);
			log.info("add User datail",userDetail);
		} catch(Exception ex) {
			throw new UserManagementException("Unable to add User");
		}
		return addUserDetail;
	}

}
