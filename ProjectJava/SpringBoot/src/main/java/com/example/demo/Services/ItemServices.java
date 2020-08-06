package com.example.demo.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Item;
import com.example.demo.Repositories.ItemRepository;

@Service
public class ItemServices {
	
	@Autowired
	ItemRepository repo;

	public List<Item> readAll(){
		return repo.findAll();
	}
	
	public void create(int itemID, String title, String description, String dueBy, Boolean complete) {
		Item I = new Item();
		I.setItemID(itemID);
		I.setTitle(title);
		I.setDescription(description);
		I.setDueBy(dueBy);
		I.setComplete(complete);
		repo.save(I);
	}
	
	public String delete(int itemID) {
		if (repo.existsById(itemID)){
			repo.deleteById(itemID);
			return ("Record Deleted");
		}
		else {
			return ("Record not found");
		}
	}
	
	public List<Item> readByIncompletion() {
		return repo.findByIncomplete();
	}
	
	public Item readByID(int id) {
		return repo.findByItemID(id);
	}
}
