package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dto.UserDTO;
import com.user.service.service.UserService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Finds all users data.",
		    notes = "No input value needed.",
		    response = UserDTO.class,
		    responseContainer = "List")
	@GetMapping(value="/")
    public List<UserDTO> users(){
		return userService.findAllBooks();
    }
	
	@ApiOperation(value = "Finds single user data.",
		    notes = "Provide user id in parameter.",
		    response = UserDTO.class)
    @GetMapping(value="/{userId}")
    public UserDTO users(@PathVariable("userId") Long userId){
    	return userService.findBook(userId);
    }
    

	@ApiOperation(value = "Save user data.",
		    notes = "Provide user Json request.",
		    response = UserDTO.class)
    @PostMapping(value="/")
    public String saveBooks(@RequestBody UserDTO user){
    	userService.saveUser(user);
    	return "User added successfully.";
    }
    

	@ApiOperation(value = "Delete user data.",
		    notes = "Provide user id in parameter",
		    response = UserDTO.class)
    @DeleteMapping(value="/{userId}")
    public String deleteUser(@PathVariable Long userId){
    	userService.deleteBook(userId);
    	return "User deleted successfully";
    }

	@ApiOperation(value = "Updates user data.",
		    notes = "Provide user id in parameter",
		    response = UserDTO.class)
    @PutMapping(value="/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserDTO user){
    	userService.updateUser(user,userId);
    	return "User updated successfully";
    }

}
