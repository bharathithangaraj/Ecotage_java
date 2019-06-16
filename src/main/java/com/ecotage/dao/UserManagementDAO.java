package com.ecotage.dao;

import org.springframework.stereotype.Service;

import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.AddUserDetails;
import com.ecotage.vo.ShowUser;

@Service
public interface UserManagementDAO {
	
	public ShowUser createUser(AddUser userDetail) throws  UserManagementException;
	
	public ShowUser getUserAdditionalInfo(String loginId, String access_token) throws  UserManagementException;
	
	public ShowUser loginUser(String loginId, String password) throws  UserManagementException;
	
	public ShowUser addUserDetails(AddUserDetails userDetail) throws  UserManagementException;

}
