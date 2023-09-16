package com.FrontController.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.FrontController.model.RegisterModel;
import com.backend.DAO.UserDAO;
import com.backend.model.Address;
import com.backend.model.Cart;
import com.backend.model.User;

@Component("registerHandler")
public class RegisterHandler {
	@Autowired
	UserDAO userDAO;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}

	public String saveAll(RegisterModel registerModel) {
		String transitionValue = "success";

		User user = registerModel.getUser();

		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();

			cart.setUser(user);
			user.setCart(cart);
		}

		userDAO.addUser(user);

		Address billing = registerModel.getBilling();

		billing.setUserId(user.getId());
		billing.setBilling(true);
		userDAO.addAddress(billing);

		return transitionValue;
	}

	
	 public String validateUser(User user, MessageContext error) {
		  String transitionValue = "success";
		   if(!user.getPassword().equals(user.getConfirmPassword())) {
		    error.addMessage(new MessageBuilder().error().source(
		      "confirmPassword").defaultText("Password does not match confirm password!").build());
		    transitionValue = "failure";    
		   }  
		   if(userDAO.getByEmail(user.getEmail())!=null) {
		    error.addMessage(new MessageBuilder().error().source(
		      "email").defaultText("Email address is already taken!").build());
		    transitionValue = "failure";
		   }
		  return transitionValue;
		 }
		 
}
