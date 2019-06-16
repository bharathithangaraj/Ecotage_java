package com.ecotage.dao.impl;

import static com.ecotage.util.CommonUtil.CURRENT_TIME;
import static com.ecotage.util.CommonUtil.VALID_EMAIL_ADDRESS_REGEX;
import static com.ecotage.util.CommonUtil.VALID_PHONE_NO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ecotage.dao.UserManagementDAO;
import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.model.User;
import com.ecotage.model.UserDetail;
import com.ecotage.repo.UserDetailsRepository;
import com.ecotage.repo.UserRepository;
import com.ecotage.util.CommonUtil;
import com.ecotage.vo.AddOrders;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.AddUserDetails;
import com.ecotage.vo.OauthDetail;
import com.ecotage.vo.OauthHeader;
import com.ecotage.vo.ResponseMessage;
import com.ecotage.vo.ShowOrderDetails;
import com.ecotage.vo.ShowUser;
import com.ecotage.vo.ShowUserDetails;

@Component
public class UserManagementDAOImpl implements UserManagementDAO {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserDetailsRepository userDetRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RestTemplate template2;

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

			User saveUser = new User(/*loginId, userDetail.getPassword(), userDetail.getFirstName(),
					userDetail.getMiddleName(), userDetail.getLastName(), userDetail.getEmail(),
					userDetail.getMobileNumber(), userDetail.getIsActive(), 0, 0, CURRENT_TIME, CURRENT_TIME*/);

			User userEntity = userRepo.save(saveUser);

			if (userEntity != null) {
				// addedUser.setLoginId(userEntity.getLoginId());
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
	public ShowUser getUserAdditionalInfo(String loginId, String access_token) throws UserManagementException {

		ShowUser showUser = null;
		ShowUserDetails showUserDetail = null;
		ResponseMessage res = null;

		try {

			res = new ResponseMessage();
			showUser = new ShowUser();


			String url = "http://localhost:8180/user/login/{userId}";

			// URI (URL) parameters
			Map<String, String> uriParams = new HashMap<String, String>();
			uriParams.put("userId", loginId);

			// Query parameters
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					// Add query parameter
					.queryParam("access_token", access_token);

			System.out.println(builder.buildAndExpand(uriParams).toUri());

			ResponseEntity<ShowUser> response = null;
			try {
				HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());
				response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.POST, entity,
						ShowUser.class);
				showUser = response.getBody();
				res.setErrorCode("0000");
				res.setMessage("success");
				showUser.setResponse(res);
				
			} catch (Exception e) {
				throw new UserManagementException();
			}
			
			
			String user_det_url = "http://localhost:8180/user/userdetail/{userId}";

			// URI (URL) parameters
			Map<String, Object> user_det_params = new HashMap<String, Object>();
			user_det_params.put("userId", showUser.getUserId());

			// Query parameters
			UriComponentsBuilder user_det_builder = UriComponentsBuilder.fromUriString(user_det_url)
					// Add query parameter
					.queryParam("access_token", access_token);

			System.out.println(user_det_builder.buildAndExpand(user_det_params).toUri());

			ResponseEntity<ShowUserDetails> user_det_response = null;
			try {
				HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());
				user_det_response = restTemplate.exchange(user_det_builder.buildAndExpand(user_det_params).toUri(), HttpMethod.POST, entity,
						ShowUserDetails.class);
				showUserDetail = user_det_response.getBody();
				showUser.setShowUserDetails(showUserDetail);
				res.setErrorCode("0000");
				res.setMessage("success");
				showUser.setResponse(res);
				
			} catch (Exception e) {
				e.printStackTrace();
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

	@Override
	public ShowUser loginUser(String loginId, String password) throws UserManagementException {

		ShowUser showUser = null;
		ResponseMessage res = null;

		try {
			res = new ResponseMessage();
			showUser = new ShowUser();

			OauthDetail auth = CommonUtil.getAuth(loginId,password);
			//if(auth.getAccess_token() != "") {
				
				String url = "http://localhost:8180/user/login/{userId}";

				// URI (URL) parameters
				Map<String, String> uriParams = new HashMap<String, String>();
				uriParams.put("userId", loginId);

				// Query parameters
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
						// Add query parameter
						.queryParam("access_token", auth.getAccess_token());

				System.out.println(builder.buildAndExpand(uriParams).toUri());

				ResponseEntity<ShowUser> response = null;
				try {
					HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());
					response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.POST, entity,
							ShowUser.class);
					showUser = response.getBody();
					res.setErrorCode("0000");
					res.setMessage("success");
					showUser.setToken(auth.getAccess_token());
					showUser.setResponse(res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			

			

		} catch (Exception ex) {
			ex.printStackTrace();
			res.setErrorCode("E001");
			res.setMessage(ex.getMessage());
			showUser.setResponse(res);
			//throw new UserManagementException("Unable to add User " + ex.getMessage());

		}

		return showUser;
	}




	@Override
	public ShowUser addUserDetails(AddUserDetails userDetail) throws UserManagementException {
		
		ShowUser showUser = null;
		ShowUserDetails showUserDetail = null;
		ResponseMessage res = null;
		try {
			showUser = new ShowUser();
			showUserDetail = new ShowUserDetails();
			res = new ResponseMessage();
			
		
		String user_det_url = "http://localhost:8180/user/userdetail/add";
		
		 MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);
		

		// URI (URL) parameters
//		Map<String, Object> user_det_params = new HashMap<String, Object>();
//		user_det_params.put("userId", showUser.getUserId());

		// Query parameters
		UriComponentsBuilder user_det_builder = UriComponentsBuilder.fromUriString(user_det_url)
				// Add query parameter
				.queryParam("access_token", userDetail.getToken());

		System.out.println(user_det_builder.buildAndExpand().toUri());

		ResponseEntity<ShowUserDetails> user_det_response = null;
		try {
			HttpEntity<AddUserDetails> entity = new HttpEntity<>(userDetail,headers);
			user_det_response = restTemplate.exchange(user_det_builder.buildAndExpand().toUri(), HttpMethod.POST, entity,
					ShowUserDetails.class);
			showUserDetail = user_det_response.getBody();
			showUser.setShowUserDetails(showUserDetail);
			res.setErrorCode("0000");
			res.setMessage("success");
			showUser.setResponse(res);
			
		} catch (Exception e) {
			e.printStackTrace();
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
