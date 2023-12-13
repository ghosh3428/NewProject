package com.FrontController.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FrontController.model.CheckoutModel;
import com.backend.DAO.CartLinesDAO;
import com.backend.DAO.ProductDAO;
import com.backend.DAO.UserDAO;
import com.backend.model.Address;
import com.backend.model.CartLines;
import com.backend.model.User;

@Component("checkoutHandler")
public class CheckoutHandler 
{
	@Autowired
	UserDAO userDAO;

	@Autowired
	CartLinesDAO cartlinesDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	public CheckoutModel init(String name) throws Exception {

		User user = userDAO.getByEmail(name);

		CheckoutModel checkoutModel = null;

		if (user != null) {
			checkoutModel = new CheckoutModel();
			checkoutModel.setUser(user);
			checkoutModel.setCart(user.getCart());

			double checkoutTotal = 0.0;
			List<CartLines> cartLines = cartlinesDAO.list(user.getCart().getId());

			if (cartLines.size() == 0) {
				throw new Exception("There are no products available for checkout now!");
			}

			for (CartLines cartLine : cartLines) {
				checkoutTotal += cartLine.getTotal();
			}

			checkoutModel.setCartLines(cartLines);
			checkoutModel.setCheckoutTotal(checkoutTotal);
		}

		return checkoutModel;
	}
	
	public List<Address> getShippingAddresses(CheckoutModel model) {

		List<Address> addresses = userDAO.getShippingAddress(model.getUser().getId());

		if (addresses.size() == 0) {
			addresses = new ArrayList<>();
		}

		addresses.add(addresses.size(), userDAO.getBillingAddress(model.getUser().getId()));

		return addresses;
	}
	

}
