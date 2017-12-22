package es.techedge.isban.authorization.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.techedge.isban.authorization.persistence.entities.Users;
import es.techedge.isban.authorization.persistence.entities.pk.UsersPK;

public interface UsersRepository extends JpaRepository<Users, UsersPK> {

}
