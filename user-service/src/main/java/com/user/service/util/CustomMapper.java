package com.user.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.service.dto.UserDTO;
import com.user.service.model.User;

public class CustomMapper {
	public static User convertDtoToModel(UserDTO userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		return user;
	}
	
	public static List<UserDTO> convertToDtoFromList(List<User> user) {
		List<UserDTO> userList = new ArrayList<UserDTO>();
		user.stream().forEach(u->{
			UserDTO userDTO = new UserDTO();
			userDTO.setName(u.getName());
			userDTO.setPassword(u.getPassword());
			userDTO.setRole(u.getRole());
			userList.add(userDTO);
		});
		return userList;
	}

	public static UserDTO convertModelToDto(Optional<User> user) {
		UserDTO userDto = new UserDTO();
		if(user.isPresent()){
			User u = user.get();
			userDto.setName(u.getName());
			userDto.setId(u.getId());
			userDto.setPassword(u.getPassword());
			userDto.setRole(u.getRole());
		}
		return userDto;
	}
}
