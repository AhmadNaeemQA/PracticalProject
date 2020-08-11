package come.exampe.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.Model.User;

public class UserClassTest {

	User user = new User();
	
	@Test
	public void usernameTest() {
		user.setUsername("user");
		assertEquals("user", user.getUsername());
	}
	
	@Test
	public void firstNameTest() {
		user.setFirstName("FName");
		assertEquals("FName", user.getFirstName());
	}
	
	@Test
	public void surnameTest() {
		user.setSurname("SName");
		assertEquals("SName", user.getSurname());
	}
	
	@Test
	public void emailTest() {
		user.setEmail("userEmail");
		assertEquals("userEmail", user.getEmail());
	}
	
	@Test
	public void passwordTest() {
		user.setPassword("root");
		assertEquals("root", user.getPassword());
	}
	
}
