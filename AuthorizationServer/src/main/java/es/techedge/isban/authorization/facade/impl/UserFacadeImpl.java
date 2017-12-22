package es.techedge.isban.authorization.facade.impl;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.techedge.isban.authorization.beans.BaseUserDTO;
import es.techedge.isban.authorization.beans.UserDTO;
import es.techedge.isban.authorization.facade.UserFacade;
import es.techedge.isban.authorization.persistence.entities.Users;
import es.techedge.isban.authorization.persistence.entities.pk.UsersPK;
import es.techedge.isban.authorization.persistence.repositories.UsersRepository;

@Service
@Transactional
public class UserFacadeImpl implements UserFacade {

	private static final Logger log = LoggerFactory.getLogger(UserFacadeImpl.class);

	@Autowired
	private UsersRepository usersRepositoy;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UsersPK usersPK = new UsersPK(username);
			Users userJpa = usersRepositoy.findOne(usersPK);
			if (userJpa != null) {
				UserDTO userDto = new UserDTO();
				try {
					BeanUtils.copyProperties(userDto, userJpa);
				} catch (Exception ex) {
					log.error("Error copiando usuario de base de datos al usuario de autenticacion :", ex);
				}
				return userDto;
			} else {
				throw new UsernameNotFoundException("Usuario no encontrado");
			}
		} catch (Exception e) {
			log.error("Error en la autenticación del usuario: ", e.getMessage());
		}
		return null;
	}
	
	@Override
	public BaseUserDTO addUser(BaseUserDTO user){
		if (user.getUsername()!=null){
			UsersPK usersPk = new UsersPK(user.getUsername());
			if (usersRepositoy.findOne(usersPk)==null){
				Users userJpa = new Users();
				userJpa.setUsername(user.getUsername());
				String passEncoded = new BCryptPasswordEncoder().encode(user.getPassword());
				userJpa.setPassword(passEncoded);
				userJpa.setAccountNonExpired(true);
				userJpa.setAccountNonlocked(true);
				userJpa.setCredentialsNonExpired(true);
				userJpa.setEnabled(true);
				usersRepositoy.save(userJpa);
			}
		}
		
		return user;
	}
	
	@Override
	public UserDTO editUser(UserDTO user){
		if (user.getUsername()!=null){
			UsersPK usersPk = new UsersPK(user.getUsername());
			if (usersRepositoy.exists(usersPk)){
				Users userJpa = new Users();
				try {
					BeanUtils.copyProperties(user, userJpa);
				} catch (Exception ex) {
					log.error("Error copiando usuario de base de datos al usuario de autenticacion :", ex);
				}
				usersRepositoy.save(userJpa);
			}
		}
		
		return user;
	}
	
	@Override
	public BaseUserDTO getUser(String username){
		if (username!=null){
			UsersPK usersPk = new UsersPK(username);
			if (usersRepositoy.exists(usersPk)){
				Users userJpa = usersRepositoy.findOne(usersPk);
				UserDTO user = new UserDTO();
				try {
					BeanUtils.copyProperties(user, userJpa);
				} catch (Exception ex) {
					log.error("Error copiando usuario de base de datos al usuario de autenticacion :", ex);
				}
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	

}
