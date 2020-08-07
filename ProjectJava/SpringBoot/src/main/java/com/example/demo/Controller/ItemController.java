package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Item;
import com.example.demo.Services.ItemServices;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
	
	
	@Autowired
	ItemServices service;
	
	
	@GetMapping("/readAll/{username}")
	public List<Item> readAll(@PathVariable(value="username") String username){
		return service.readAll(username);
	}
	
	@GetMapping("/readByID/{id}")
	public Item readByID (@PathVariable(value="id") int itemID){
		return service.readByID(itemID);
	}
	
	// localhost:8030/item/addItem/user4/go to work/leave early and go work/18-12-2020/true
	@GetMapping("/addItem/{username}/{title}/{description}/{dueBy}/{complete}")
	public void addItem(@PathVariable(value="username") String username,
			@PathVariable(value="title") String title,
			@PathVariable(value="description") String description,
			@PathVariable(value="dueBy") String dueBy,
			@PathVariable(value="complete") Boolean complete) {
		
		service.create(username, title, description, dueBy, complete);
		
	}
	
	@GetMapping("/delete/{username}/{itemID}")
	public String deleteItem(@PathVariable(value="username") String username, @PathVariable(value="itemID") int itemID) {
		return service.delete(username, itemID);
	}
	
	//Only shows items for a specific user that is marked as incomplete
	@GetMapping("/readByIncompled/{username}")
	public List <Item> readByIncompleted(@PathVariable(value="username") String username) {
		return service.readByIncompletion(username);
	}
	
	@GetMapping("/updateItem/{username}/{itemID}/{title}/{description}/{dueBy}/{complete}")
	public String updateItem(@PathVariable(value="username") String username, 
			@PathVariable(value="itemID") int itemID,
			@PathVariable(value="title") String title,
			@PathVariable(value="description") String description,
			@PathVariable(value="dueBy") String dueBy,
			@PathVariable(value="complete") Boolean complete) {
		return service.update(username, itemID, title, description, dueBy, complete);
	}

}
