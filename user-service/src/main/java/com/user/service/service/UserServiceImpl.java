package com.user.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.dto.UserDTO;
import com.user.service.model.User;
import com.user.service.repository.UserRepository;
import com.user.service.util.CustomMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<UserDTO> findAllBooks() {
		List<User> users = (List<User>) userRepository.findAll();
		return CustomMapper.convertToDtoFromList(users);
	}

	@Override
	public UserDTO findBook(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return CustomMapper.convertModelToDto(user);
	}

	@Override
	public void saveUser(UserDTO userDto) {
		User  user = CustomMapper.convertDtoToModel(userDto);
		userRepository.save(user);
	}

	@Override
	public void deleteBook(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public void updateUser(UserDTO userDto, Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User u = user.get();
			u.setName(userDto.getName());
			u.setPassword(userDto.getPassword());
			u.setRole(userDto.getRole());
			userRepository.save(u);
		}
		
	}
	
}
