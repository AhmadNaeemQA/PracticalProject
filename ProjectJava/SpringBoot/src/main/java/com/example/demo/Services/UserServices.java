package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

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
	
	public String updateUser(String username, String email, String firstname, String surname) {
		List <User> allUsers= repo.findAll();
		for (int i = 0; i < allUsers.size(); i++) {
			if (allUsers.get(i).getUsername().equals(username)) {
				repo.updateUser(username, email, firstname, surname);
				return ("Successfully Updated");
			}
		}
		return ("Error: User not found");
	}
	
	public String create(String username, String password, String email, String firstName, String surname) {
		List <User> allUsers= repo.findAll();
		for (int i = 0; i < allUsers.size(); i++) {
			if (allUsers.get(i).getUsername().equals(username)) {
				return ("User already exist");
			}
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);	
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setSurname(surname);
		repo.save(user);
		return ("User created");
	}

	public String authUser(String username, String password) {
		List <User> allUsers= repo.findAll();
		for (int i = 0; i < allUsers.size(); i++) {
			if (allUsers.get(i).getUsername().equals(username)) {
				if (allUsers.get(i).getPassword().equals(password)){
					return ("Succesful");
				}
				else {
					return ("Fail");
				}
			}
		}
		return ("Fail");
	}
}
