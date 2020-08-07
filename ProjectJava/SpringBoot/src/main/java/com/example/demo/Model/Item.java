package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int itemID;
	private String username;
	private String title;
	private String description;
	private String dueBy;
	private Boolean complete;
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueBy() {
		return dueBy;
	}
	public void setDueBy(String dueBy) {
		this.dueBy = dueBy;
	}
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	
	
	
	
	
}
