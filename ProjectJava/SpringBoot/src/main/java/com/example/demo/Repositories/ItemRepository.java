package com.example.demo.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{
	
	
	@Modifying
	@Transactional
	@Query(value="SELECT * FROM item WHERE username = :username AND complete = false", nativeQuery=true)
	public List<Item> findByIncomplete(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value="SELECT * FROM item WHERE username = :username", nativeQuery=true)
	public List<Item> findAllByUsername(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE item SET title = :title, description = :description, due_by = :dueBy, complete = :complete WHERE itemid = :itemId", nativeQuery=true)
	public void updateItem(@Param("itemId") int itemId ,@Param("title") String title, @Param("description") String description, @Param("dueBy") String dueBy, @Param("complete") Boolean complete);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE item SET complete = True  WHERE username = :username AND itemid = :itemId ;", nativeQuery=true)
	public void markCompleted(@Param("username") String username, @Param("itemId") int itemId);

}
