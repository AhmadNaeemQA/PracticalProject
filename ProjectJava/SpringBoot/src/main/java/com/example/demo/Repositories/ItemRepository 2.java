package com.example.demo.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{
	
	// find item by product ID
	public Item findByItemID(int itemID);
	
	@Query(value="select * from item where completed = False", nativeQuery=true)
	public List<Item> findByIncomplete();
	
	

}