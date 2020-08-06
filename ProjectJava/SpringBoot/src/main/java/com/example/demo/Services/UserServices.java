package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository repo;
	
	public Optional <User> getUserById(int id) {
		return repo.findById(id);
	}
	
	public List <User> getAll(){
		return repo.findAll();
	}
	
	public void updateUser(int id, String email, String firstname, String surname) {
		if (repo.existsById(id)){
			repo.updateUser(id, email, firstname, surname);
		}
	}
	
	public void create(String username, String password, String email, String firstName, String surname) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setSurname(surname);
		repo.save(user);
	}
}
