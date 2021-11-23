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

@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/")
    public List<UserDTO> users(){
		return userService.findAllBooks();
    }
    
    @GetMapping(value="/{userId}")
    public UserDTO users(@PathVariable("userId") Long userId){
    	return userService.findBook(userId);
    }
    
    @PostMapping(value="/")
    public String saveBooks(@RequestBody UserDTO user){
    	userService.saveUser(user);
    	return "User added successfully.";
    }
    
    @DeleteMapping(value="/{userId}")
    public String deleteUser(@PathVariable Long userId){
    	userService.deleteBook(userId);
    	return "User deleted successfully";
    }
    @PutMapping(value="/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserDTO user){
    	userService.updateUser(user,userId);
    	return "User updated successfully";
    }

}
