package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Model.User;
import com.example.demo.Services.UserServices;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
	
	@GetMapping("/authUser/{username}/{password}")
	public String authUser(@PathVariable(value="username") String username,
			@PathVariable(value="password") String password) {
		return service.authUser(username, password);
	}
	
	//localhost:8030/user/createUser/username1/password1/email2/firstname2/surname2
	@GetMapping("/createUser/{username}/{password}/{email}/{firstname}/{surname}")
	public String addItem(@PathVariable(value="username") String username,
			@PathVariable(value="password") String password,
			@PathVariable(value="email") String email,
			@PathVariable(value="firstname") String firstname,
			@PathVariable(value="surname") String surname) {
		
		return (service.create(username, password, email, firstname, surname));
		
	}
	
	// localhost:8030/user/updateUser/2/email3/firstname3/surname3
	@GetMapping("/updateUser/{username}/{email}/{firstname}/{surname}")
	public String updateUser(@PathVariable(value="username") String username,
			@PathVariable(value="email") String email,
			@PathVariable(value="firstname") String firstname,
			@PathVariable(value="surname") String surname) {
		return (service.updateUser(username, email, firstname, surname));
	}

}
