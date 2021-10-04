package com.home.urix.regform.repos;

import com.home.urix.regform.entity.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDto,Long> {

}
