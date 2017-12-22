package es.techedge.isban.authorization.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@RequestMapping(value= "/user", method = RequestMethod.POST)
	public Principal user(Principal user) {
		return user;
	}

}
