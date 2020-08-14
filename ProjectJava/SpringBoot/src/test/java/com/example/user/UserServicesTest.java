package com.example.user;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Application;
import com.example.demo.Model.Item;
import com.example.demo.Model.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.UserServices;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServicesTest {

	@MockBean
	UserRepository repo;
	
	@Autowired
	UserServices service;
	
	@Test
	public void getUserByIdTest() {
		User user = new User("username", "password", "email", "firstName", "surname");
		Optional<User> users = Optional.of(user);
		when(repo.findById(1)).thenReturn(users);
		assertEquals(service.getUserById(1), users);
	}
	
	@Test
	public void getAllTest() {
		User user = new User("username", "password", "email", "firstName", "surname");
		List <User> users = new ArrayList<User>();
		users.add(user);
		when(repo.findAll()).thenReturn(users);
		assertEquals(service.getAll(), users);
		
	}
	
	@Test
	public void updateUserTest() {
		User user = new User("username", "password", "email", "firstName", "surname");
		List <User> users = new ArrayList<User>();
		users.add(user);
		when(repo.findAll()).thenReturn(users);
		assertEquals(service.updateUser("username", "newemail", "newfirstname", "newsurname"), "Successfully Updated");
	}
	
	@Test
	public void updateUserTest2() {
		User user = new User("username", "password", "email", "firstName", "surname");
		List <User> users = new ArrayList<User>();
		users.add(user);
		when(repo.findAll()).thenReturn(users);
		assertEquals(service.updateUser("wrongusername", "newemail", "newfirstname", "newsurname"), "Error: User not found");
		
	}
	
	@Test
	public void createTest() {
		User user = new User("username", "password", "email", "firstName", "surname");
		List <User> users = new ArrayList<User>();
		users.add(user);
		when(repo.findAll()).thenReturn(users);
		assertEquals(service.create("username", "password", "email", "firstName", "surname"), "User already exist");
		assertEquals(service.create("newusername", "newpassword", "newemail", "newfirstName", "newsurname"), "User created");
	}
	
	@Test
	public void authUser() {
		User user = new User("username", "password", "email", "firstName", "surname");
		List <User> users = new ArrayList<User>();
		users.add(user);
		when(repo.findAll()).thenReturn(users);
		assertEquals(service.authUser("username", "password"), "Succesful");
		assertEquals(service.authUser("Wrongusername", "wrongpassword"), "Fail");
		assertEquals(service.authUser("username", "wrongpassword"), "Fail");
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User("username", "password", "email", "firstName", "surname");
		assertEquals(service.deleteUser(user.getUsername()), "User deleted");
	}
	

}
