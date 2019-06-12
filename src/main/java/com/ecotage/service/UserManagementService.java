package com.ecotage.service;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.ShowUser;

@Service
public interface UserManagementService {
	
	public ShowUser createUser(AddUser userDetail) throws ResourceNotFoundException, UserManagementException;
	
	public ShowUser getUser(String loginId) throws ResourceNotFoundException, UserManagementException;

}
