package es.techedge.isban.authorization.facade;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import es.techedge.isban.authorization.beans.BaseUserDTO;
import es.techedge.isban.authorization.beans.UserDTO;

@Service
public interface UserFacade extends UserDetailsService {
	
	public BaseUserDTO addUser(BaseUserDTO user);
	public UserDTO editUser(UserDTO user);
	public BaseUserDTO getUser(String username);

}
