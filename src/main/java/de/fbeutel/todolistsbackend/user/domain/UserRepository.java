package de.fbeutel.todolistsbackend.user.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
