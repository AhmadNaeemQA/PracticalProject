package com.example.demo.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE user SET email=:email, first_name = :firstName, surname = :surname WHERE username = :username ;", nativeQuery=true)
	public void updateUser(@Param("username") String username, @Param("email") String email, @Param("firstName") String firstName, @Param("surname") String surname);

	@Query(value="UPDATE user SET email=:email, first_name = :firstName, surname = :surname WHERE id = :id ;", nativeQuery=true)
	public void updateUser(@Param("id") int id, @Param("email") String email, @Param("firstName") String firstName, @Param("surname") String surname);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM item WHERE username =:username ;", nativeQuery=true)
	public void deleteUserItems(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM user WHERE username =:username ;", nativeQuery=true)
	public void deleteByUsername(@Param("username") String username);


}
