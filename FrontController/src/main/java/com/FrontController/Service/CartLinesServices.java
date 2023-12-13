package com.FrontController.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FrontController.model.UserModel;
import com.backend.DAO.CartLinesDAO;
import com.backend.DAO.ProductDAO;
import com.backend.model.Cart;
import com.backend.model.CartLines;
import com.backend.model.Product;

@Service("cartlinesService")
public class CartLinesServices {

	@Autowired
	private HttpSession session;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartLinesDAO cartlinesDAO;

	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public String addCartLineProduct(int p_Id) {
		Cart cart = this.getCart();
		CartLines ct = cartlinesDAO.getByCartAndProduct(cart.getId(), p_Id);

		if (ct == null) {
			ct = new CartLines();
			Product p = productDAO.getProduct(p_Id);

			ct.setAvailable(true);
			ct.setBuyingPrice(p.getUnitPrice());
			ct.setCartId(cart.getId());
			ct.setProduct(p);
			ct.setProductCount(1);
			ct.setTotal(ct.getBuyingPrice() * ct.getProductCount());

			cartlinesDAO.add(ct);

			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + ct.getTotal());

			cartlinesDAO.updateCart(cart);
		} else {
			ct.setProductCount(ct.getProductCount() + 1);
			ct.setTotal(ct.getBuyingPrice() + ct.getTotal());
			cart.setGrandTotal(cart.getGrandTotal() + ct.getBuyingPrice());

			cartlinesDAO.update(ct);
			cartlinesDAO.updateCart(cart);

		}

		return "result=added";

	}

	public List<CartLines> getCartLines() {
		Cart cart = this.getCart();
		return cartlinesDAO.list(cart.getId());
	}

	public String removeCartLine(int c_id) {
		Cart cart = this.getCart();
		CartLines ct = cartlinesDAO.get(c_id);
		cart.setGrandTotal(cart.getGrandTotal() - ct.getTotal());
		cart.setCartLines(cart.getCartLines() - 1);

		cartlinesDAO.remove(ct);
		cartlinesDAO.updateCart(cart);

		return "result=deleted";

	}

	public String updateCartLine(int c_id, int count) {
		Cart cart = this.getCart();
		CartLines ct = cartlinesDAO.get(c_id);

		if (count > ct.getProduct().getQuantity()) {
			return "result=maxcountreach";
		}
		if (count < 1) {
			return "result=mincountreach";
		}

		double og = ct.getTotal();

		ct.setProductCount(count);
		ct.setBuyingPrice(ct.getProduct().getUnitPrice());

		ct.setTotal(count * ct.getBuyingPrice());

		cart.setGrandTotal(cart.getGrandTotal() - og + ct.getTotal());

		cartlinesDAO.update(ct);
		cartlinesDAO.updateCart(cart);

		return "result=updated";

	}

	public String validate() {
		Cart cart = this.getCart();

		List<CartLines> cartLines = cartlinesDAO.list(cart.getId());

		double grandTotal = 0.0;
		int lineCount = 0;

		String response = "result=success";

		boolean changed = false;
		Product product = null;

		for (CartLines cartLine : cartLines) {
			product = cartLine.getProduct();
			changed = false;

			
			if ((!product.isActive() || product.getQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}

			if ((product.isActive() && product.getQuantity() >= cartLine.getProductCount())
					&& !(cartLine.isAvailable())) {
				cartLine.setAvailable(true);
				changed = true;
			}

			if (cartLine.getBuyingPrice() != product.getUnitPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getUnitPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;
			}
			
			if(cartLine.getProductCount() > product.getQuantity()) {
				cartLine.setProductCount(product.getQuantity());										
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;
				
			}

			if (changed) {
				// update the cartLine
				cartlinesDAO.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}

			if (cartlinesDAO.get(cartLine.getId()).isAvailable() == true) {
				grandTotal += cartLine.getTotal();
				lineCount++;
			}

		}

		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		cartlinesDAO.updateCart(cart);

		return response;
	}

}
