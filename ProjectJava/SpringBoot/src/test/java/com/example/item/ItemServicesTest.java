
package com.example.item;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Application;
import com.example.demo.Model.Item;
import com.example.demo.Repositories.ItemRepository;
import com.example.demo.Services.ItemServices;

//classes = Application.class

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ItemServicesTest {

	@MockBean
	ItemRepository repo;
	
	@Autowired
	ItemServices service;
	
	@Test
	public void readAllTest() {
		Item item = new Item("username", "title", "description" , "01-01-01", false);
		List<Item> items =  new ArrayList<Item>();
		items.add(item);
		when(repo.findAllByUsername("username")).thenReturn((items));
		assertEquals(service.readAll("username").get(0), item);
	}
	
	@Test
	public void creatTest() {
		Item item = new Item("username", "title", "description" , "01-01-01", false);
		when(repo.save(item)).thenReturn(item);
		assertEquals(service.create("username", "title", "description" , "01-01-01", false), "Task created Successfully");
	}
	
	@Test
	public void deleteTest() {
		Item item = new Item("username", "title", "description" , "01-01-01", false);
		Optional<Item> items = Optional.of(item);	
		when(repo.findById(1)).thenReturn(items);
		assertEquals(service.delete("username", 1), "Deleted Successfully");
		
	}
	
	@Test
	public void deleteTest2() {
		Item item = new Item("username", "title", "description" , "01-01-01", false);
		Optional<Item> items = Optional.of(item);	
		when(repo.findById(1)).thenReturn(items);
		assertEquals(service.delete("WrongUsername", 1), "Task not found");
		
	}
	
	@Test
	public void readByIncompletetionTest() {
		Item item = new Item("username", "title", "description" , "01-01-01", false);
		List<Item> items =  new ArrayList<Item>();
		items.add(item);
		when(repo.findByIncomplete(item.getUsername())).thenReturn(items);
		assertEquals(service.readByIncompletion(item.getUsername()).get(0), item);
	}
	
	
//	@Test
//	public void readByIDTest() {
//		Item item = new Item("username", "title", "description" , "01-01-01", false);
//		when(repo.findById(1)).thenReturn(item);
//		
//	}
	
	@Test
	public void markCompletedTest() {
		Item item = new Item("username", "title", "description" , "01-01-01", false);
		assertEquals(service.markCompleted(item.getUsername(), 1), "successful");
		
	}
	
	
	
}