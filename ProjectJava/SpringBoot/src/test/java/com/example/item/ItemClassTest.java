package com.example.item;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.demo.Model.Item;

public class ItemClassTest {
	

	Item item = new Item();
	
	@Test
	public void usernameTests() {
		item.setUsername("user");
		assertEquals("user", item.getUsername());
	}
	@Test
	public void titleTests() {
		item.setTitle("title");
		assertEquals("title", item.getTitle());
	}
	
	@Test
	public void descriptionTests() {
		item.setDescription("description");
		assertEquals("description", item.getDescription());
	}
	
	@Test
	public void dueByTests() {
		item.setDueBy("01-01-01");
		assertEquals("01-01-01", item.getDueBy());
	}
	
	@Test
	public void completeTests() {
		item.setComplete(true);
		assertEquals(true, item.getComplete());
	}
	
	
	
}
