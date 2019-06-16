package com.ecotage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecotage.exception.ProductServiceException;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.handler.UserManagementHandler;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.AddUserDetails;
import com.ecotage.vo.ShowCartDetails;
import com.ecotage.vo.ShowUser;
import com.ecotage.vo.ShowUserDetails;

@RestController()
@CrossOrigin("*")
public class UserManagementController {
	
	@Autowired
	UserManagementHandler userHandler;

	// @RequestMapping(value = "/login/signUp", method = RequestMethod.POST)
	@PostMapping(value = "/signUp/")
	public ShowUser createUser(@RequestBody AddUser userDetail) throws ResourceNotFoundException, UserManagementException {
		
		return userHandler.createUser(userDetail);

	}

	@GetMapping(value = "/login/{loginId}/password/{password}")
	public ShowUser login(@PathVariable("loginId") String loginId, @PathVariable("password") String password)  
			throws ResourceNotFoundException, UserManagementException{
		if(loginId.contains("@")) {
			loginId = loginId.replaceAll("@.+", "");
			System.out.println("getUserName :::"+loginId);
		} 
		return userHandler.loginUser(loginId, password);

	}

	@RequestMapping(value = "/forgotLogin", method = RequestMethod.POST)
	public void forgetLogin() {

	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public void forgetPassword() {

	}

	@RequestMapping(value = "/OTP/initiate", method = RequestMethod.POST)
	public void initiateOTP() {

	}

	@RequestMapping(value = "/OTP/verify", method = RequestMethod.POST)
	public void verifyOTP() {

	}
	
	@GetMapping(value = "/Users/{loginId}/token/{access_token}")
	public ShowUser getUserAdditionalInfo(@PathVariable("loginId") String loginId, @PathVariable("access_token") String access_token) throws ResourceNotFoundException, UserManagementException{
		
		return userHandler.getUserAdditionalInfo(loginId,access_token);
		
	}
	
	@PostMapping(value = "/UserDetails/add/")
	public ShowUser addUserDetails(@RequestBody AddUserDetails userdetails)
			throws ResourceNotFoundException, ProductServiceException {

		return userHandler.addUserDetails(userdetails);
	}
}
