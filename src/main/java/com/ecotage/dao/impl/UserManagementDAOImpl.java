package com.ecotage.dao.impl;

import static com.ecotage.util.CommonUtil.CURRENT_TIME;
import static com.ecotage.util.CommonUtil.VALID_EMAIL_ADDRESS_REGEX;
import static com.ecotage.util.CommonUtil.VALID_PHONE_NO;
import java.util.Optional;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.UserManagementDAO;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.model.User;
import com.ecotage.repo.UserRepository;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.ResponseMessage;
import com.ecotage.vo.ShowUser;

@Component
public class UserManagementDAOImpl implements UserManagementDAO {

	@Autowired
	UserRepository userRepo;

	@Override
	public ShowUser createUser(AddUser userDetail) throws UserManagementException {

		ShowUser addedUser = null;
		ResponseMessage res = null;

		try {
			addedUser = new ShowUser();
			 res = new ResponseMessage();
			if (userDetail.getEmail() != "") {
				Optional<User> emailAvailable = userRepo.findByEmail(userDetail.getEmail());

				if (emailAvailable.isPresent()) {
					throw new UserManagementException("Email ID already registered");
				}
			}

			if (userDetail.getMobileNumber() != "") {
				Optional<User> mobileAvailable = userRepo.findByMobileNumber(userDetail.getMobileNumber());

				if (mobileAvailable.isPresent()) {
					throw new UserManagementException("MobileNo already registered");
				}
			}

			Matcher emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(userDetail.getEmail());
			if (!emailMatcher.matches()) {
				throw new UserManagementException("Email ID is not a Valid One");
			}
			
			Matcher phoneMatcher = VALID_PHONE_NO.matcher(userDetail.getMobileNumber());
			
			if (!phoneMatcher.matches()) {
				throw new UserManagementException("PhoneNo is not a Valid One");
			}
			
			String loginId = userDetail.getEmail().replaceAll("@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", "");

			User saveUser = new User(loginId, userDetail.getPassword(), userDetail.getFirstName(),
					userDetail.getMiddleName(), userDetail.getLastName(), userDetail.getEmail(),
					userDetail.getMobileNumber(), userDetail.getIsActive(), 0, 0, CURRENT_TIME, CURRENT_TIME);
			
			
			User userEntity = userRepo.save(saveUser);
			
			if(userEntity != null) {
				addedUser.setLoginId(userEntity.getLoginId());
				addedUser.setIsEmailVerified(1);
				addedUser.setMobileNumber(userEntity.getMobileNumber());
				addedUser.setEmail(userEntity.getEmail());
			} else {
				throw new Exception("Unable to save the user");
			}
			
			
			 res.setErrorCode("0000");
			 res.setMessage("success");
			addedUser.setResponse(res);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			 res.setErrorCode("E001");
			 res.setMessage(ex.getMessage());
			 addedUser.setResponse(res);
			throw new UserManagementException("Unable to add User " + ex.getMessage());
			
		}
		return addedUser;
	}

}
