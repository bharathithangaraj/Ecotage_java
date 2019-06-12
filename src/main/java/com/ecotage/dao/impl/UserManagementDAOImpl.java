package com.ecotage.dao.impl;

import static com.ecotage.util.CommonUtil.CURRENT_TIME;
import static com.ecotage.util.CommonUtil.VALID_EMAIL_ADDRESS_REGEX;
import static com.ecotage.util.CommonUtil.VALID_PHONE_NO;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecotage.dao.UserManagementDAO;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.model.User;
import com.ecotage.model.UserDetail;
import com.ecotage.repo.UserDetailsRepository;
import com.ecotage.repo.UserRepository;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.ResponseMessage;
import com.ecotage.vo.ShowUser;
import com.ecotage.vo.ShowUserDetails;

@Component
public class UserManagementDAOImpl implements UserManagementDAO {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserDetailsRepository userDetRepo;

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

	@Override
	public ShowUser getUser(String loginId) throws UserManagementException {
		
		ShowUser showUser = null;
		ResponseMessage res = null;
		
		try {
			res = new ResponseMessage();
			
			Optional<User> userEntity = userRepo.findByLoginId(loginId);
			
			if(userEntity.isPresent()) {
				showUser = new ShowUser();
				
				showUser.setEmail(userEntity.get().getEmail());
				showUser.setFirstName(userEntity.get().getFirstName());
				showUser.setIsActive(userEntity.get().getIsActive());
				showUser.setIsEmailVerified(userEntity.get().getIsEmailVerified());
				showUser.setIsGuest(userEntity.get().getIsGuest());
				showUser.setMobileNumber(userEntity.get().getMobileNumber());
				showUser.setUserId(userEntity.get().getUserId());
				showUser.setLastName(userEntity.get().getLastName());
				showUser.setLoginId(userEntity.get().getLoginId());
				
				
				List<UserDetail> userDetailEntity = userDetRepo.findByUserId(userEntity.get().getUserId());
				
				
				for(UserDetail userDetail : userDetailEntity) {
					
					if(userDetail.getIsPrimaryAddress() == 1) {
						ShowUserDetails showUserDtls = new ShowUserDetails();
						
						showUserDtls.setAddress1(userDetail.getAddress1());
						showUserDtls.setAddress2(userDetail.getAddress2());
						//showUserDtls.setAddressType(userDetail.getAddressType().name());
						showUserDtls.setCity(userDetail.getCity());
						//showUserDtls.setGender(userDetail.getGender().name());
						showUserDtls.setHouseNo(userDetail.getHouseNo());
						showUserDtls.setLandMark(userDetail.getLandMark());
						showUserDtls.setLocation(userDetail.getLocation());
						showUserDtls.setState(userDetail.getState());
						showUserDtls.setZip(userDetail.getPincode());
						showUser.setShowUserDetails(showUserDtls);
					}
					
				}
				
				res.setErrorCode("0000");
				res.setMessage("success");
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			 res.setErrorCode("E001");
			 res.setMessage(ex.getMessage());
			 showUser.setResponse(res);
			throw new UserManagementException("Unable to add User " + ex.getMessage());
			
		}
		return showUser;
		
		
		
	}

}
