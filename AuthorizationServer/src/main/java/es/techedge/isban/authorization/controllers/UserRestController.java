package es.techedge.isban.authorization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.techedge.isban.authorization.beans.BaseUserDTO;
import es.techedge.isban.authorization.beans.UserDTO;
import es.techedge.isban.authorization.facade.UserFacade;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserFacade userFacade;
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public BaseUserDTO user(@PathVariable String username) {
		return userFacade.getUser(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	public BaseUserDTO user(BaseUserDTO user) {
		return userFacade.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public UserDTO user(UserDTO user) {
		return userFacade.editUser(user);
	}
}
