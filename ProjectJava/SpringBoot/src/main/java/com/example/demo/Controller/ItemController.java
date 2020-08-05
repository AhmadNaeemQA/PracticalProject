package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Item;
import com.example.demo.Services.ItemServices;

@RestController
public class ItemController {
	
	
	@Autowired
	ItemServices service;
	
	@GetMapping("/")
	public String home(){
		return ("<h1>Welome to this page<h1>");
	}
	
	@GetMapping("/readAll")
	public List<Item> readAll(){
		return service.readAll();
	}
	
	@GetMapping("/addItem/{itemID}/{title}/{description}/{dueBy}/{complete}")
	public void addItem(@PathVariable(value="itemID") int itemID,
			@PathVariable(value="title") String title,
			@PathVariable(value="description") String description,
			@PathVariable(value="dueBy") String dueBy,
			@PathVariable(value="complete") Boolean complete) {
		
		service.create(itemID, title, description, dueBy, complete);
		
	}
	
	@GetMapping("/delet/{itemID")
	public String deleteItem(@PathVariable(value="itemID") int itemID) {
		return (service.delete(itemID));
	}

}