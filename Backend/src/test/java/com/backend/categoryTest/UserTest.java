package com.backend.categoryTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.DAO.CategoryDAO;
import com.backend.DAO.UserDAO;
import com.backend.model.Address;
import com.backend.model.Cart;
import com.backend.model.User;

public class UserTest {
	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.backend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	/*
	
	@Test
	public void userAddTest() {

		user = new User();
		user.setContactNumber("9679085576");
		user.setEmail("skl@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Sam");
		user.setLastName("Mistri");
		user.setPassword("supplier@12345");
		user.setRole("SUPPLIER");
		user.setEnabled(true);
		
		assertEquals("Error adding user", true, userDAO.addUser(user));

		Address address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		address.setUserId(userDAO.getByEmail("skl@gmail.com").getId());

		assertEquals("Error adding user", true, userDAO.addAddress(address));

		
		int cap = 0, low = 0, digit = 0, spe = 0;
		boolean valid = true;

		if (user.getPassword().length() >= 8 && user.getPassword().length() <= 15) {

			for (int i = 0; i < user.getPassword().length(); i++) {

				if (Character.isUpperCase(user.getPassword().charAt(i))) {
					cap++;
				} else if (Character.isLowerCase(user.getPassword().charAt(i))) {
					low++;
				} else if (Character.isDigit(user.getPassword().charAt(i))) {
					digit++;
				} else if (user.getPassword().charAt(i) == '!' || user.getPassword().charAt(i) == '@'
						|| user.getPassword().charAt(i) == '#' || user.getPassword().charAt(i) == '&'
						|| user.getPassword().charAt(i) == '$') {
					spe++;
				} else {
					valid = false;
				}

			}

			if (cap < 1 || low < 1 || digit < 1 || spe < 1) {
				valid = false;
			}

			System.out.println(cap + " : " + low + " : " + digit + " : " + spe);
			System.out.println(valid);

			if (valid == true) {

				if (user.getRole().equals("USER")) {
					Cart c = new Cart();
					user.setCart(c);
					c.setUser(user);
				}

				if (userDAO.getByEmail(user.getEmail()) == null) {
					assertEquals("Error adding user", true, userDAO.addUser(user));

					Address address = new Address();
					address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
					address.setAddressLineTwo("Near Kaabil Store");
					address.setCity("Mumbai");
					address.setState("Maharashtra");
					address.setCountry("India");
					address.setPostalCode("400001");
					address.setShipping(true);
					address.setUserId(userDAO.getByEmail("sd@gmail.com").getId());

					assertEquals("Error adding user", true, userDAO.addAddress(address));

				}
			}
		}
		

	}
*/
	
	
	@Test
	public void userAddTest() {

		user = new User();
		user.setContactNumber("1234567890");
		user.setEmail("niitjadavpur@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Niit");
		user.setLastName("Jadavpur");
		user.setPassword("Admin@12345");
		user.setRole("ADMIN");
		assertEquals("Error adding user", true, userDAO.addUser(user));
	}
	
		
}
