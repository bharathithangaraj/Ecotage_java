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

import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.handler.UserManagementHandler;
import com.ecotage.vo.AddCartDetails;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.ShowUser;

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

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public void login() {

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
	
	@GetMapping(value = "/Users/{loginId}")
	public ShowUser getUser(@PathVariable("loginId") String loginId) throws ResourceNotFoundException, UserManagementException{
		
		return userHandler.getUser(loginId);
		
	}
}
