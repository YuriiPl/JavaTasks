package com.home.urix.regform.repos;

import com.home.urix.regform.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
