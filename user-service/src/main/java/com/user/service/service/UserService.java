package com.user.service.service;

import java.util.List;

import com.user.service.dto.UserDTO;

public interface UserService {

	List<UserDTO> findAll();

	UserDTO findById(Long userId);

	void save(UserDTO user);

	void delete(Long userId);

	void update(UserDTO user, Long userId);

}
