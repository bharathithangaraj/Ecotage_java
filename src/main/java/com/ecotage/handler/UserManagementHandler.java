package com.ecotage.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecotage.exception.ResourceNotFoundException;
import com.ecotage.exception.UserManagementException;
import com.ecotage.service.UserManagementService;
import com.ecotage.vo.AddUser;
import com.ecotage.vo.ShowUser;

@Component
public class UserManagementHandler {
	
	@Autowired
	UserManagementService userService;
	
	
	public ShowUser createUser(@RequestBody AddUser userDetail) throws ResourceNotFoundException, UserManagementException {
		
		ShowUser showUser;
		
		try {
			showUser = userService.createUser(userDetail);
			
			/*menuCategories = categories.stream().map(c -> mapper.map(c, MenuCategory.class)).collect(Collectors.toList());
			if (categories == null) {
				throw new ResourceNotFoundException("Unable to Fetch Catgory");
			}*/

		} catch (UserManagementException px) {
			throw new UserManagementException("Internal Server Exception while add User "+px.getMessage());
		}
		return showUser;
	}

}