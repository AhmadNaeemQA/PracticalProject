package com.example.demo.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Item;
import com.example.demo.Repositories.ItemRepository;

@Service
public class ItemServices {
	
	@Autowired
	ItemRepository repo;

	public List<Item> readAll(String username){
		return repo.findAllByUsername(username);
	}
	
	public void create(String username, String title, String description, String dueBy, Boolean complete) {
		Item I = new Item();
		I.setUsername(username);
		I.setTitle(title);
		I.setDescription(description);
		I.setDueBy(dueBy);
		I.setComplete(complete);
		repo.save(I);
	}
	
	public String delete(String username, int itemID) {
		if (repo.findByItemID(itemID).getUsername().equals(username)) {
			repo.deleteById(itemID);
			return ("Deleted Successfully");
		}
		else {
			return ("Task not found");
		}
	}
	
	public List<Item> readByIncompletion(String username) {
		return repo.findByIncomplete(username);
	}
	
	public Item readByID(int id) {
		return repo.findByItemID(id);
	}
	
	public String update(String username, int itemId, String title, String description, String dueBy, Boolean complete) {
		if (repo.existsById(itemId)){
			if (repo.findByItemID(itemId).getUsername().equals(username)) {
				repo.updateItem(itemId, title, description, dueBy, complete);
				return ("Updated");
			}
		}
		return ("Update Failed");
	}
	
	public String markCompleted(String username, int itemID) {
		repo.markCompleted(username, itemID);
		return ("successful");
	}
}
