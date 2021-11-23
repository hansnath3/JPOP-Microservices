package com.user.service.service;

import java.util.List;

import com.user.service.dto.UserDTO;

public interface UserService {

	List<UserDTO> findAllBooks();

	UserDTO findBook(Long userId);

	void saveUser(UserDTO user);

	void deleteBook(Long userId);

	void updateUser(UserDTO user, Long userId);

}
