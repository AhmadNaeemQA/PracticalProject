package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserServices service;
	
	
	@GetMapping("/readAll")
	public List<User> readAll(){
		return service.getAll();
	}
	
	@GetMapping("/readUserByID/{id}")
	public Optional <User> readByID (@PathVariable(value="id") int userID){
		return service.getUserById(userID);
	}
	
	//localhost:8030/user/createUser/username1/password1/email2/firstname2/surname2
	@GetMapping("/createUser/{username}/{password}/{email}/{firstname}/{surname}")
	public void addItem(@PathVariable(value="username") String username,
			@PathVariable(value="password") String password,
			@PathVariable(value="email") String email,
			@PathVariable(value="firstname") String firstname,
			@PathVariable(value="surname") String surname) {
		
		service.create(username, password, email, firstname, surname);
		
	}
	
	// localhost:8030/user/updateUser/2/email3/firstname3/surname3
	@GetMapping("/updateUser/{userID}/{email}/{firstname}/{surname}")
	public void updateUser(@PathVariable(value="userID") int id,
			@PathVariable(value="email") String email,
			@PathVariable(value="firstname") String firstname,
			@PathVariable(value="surname") String surname) {
		
		service.updateUser(id, email, firstname, surname);
	}
	
	@GetMapping("/delete/{username}")
	public String deleteUser(@PathVariable(value="username") String username) {
		return service.deleteUser(username);
	}

}
