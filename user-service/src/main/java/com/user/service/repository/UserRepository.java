package com.user.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.service.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
