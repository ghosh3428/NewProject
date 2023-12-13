package com.backend.DAO;

import java.util.List;

import com.backend.model.Cart;
import com.backend.model.CartLines;
import com.backend.model.OrderDetails;

public interface CartLinesDAO 
{
	public List<CartLines> list(int cartId);
	public CartLines get(int id);	
	public boolean add(CartLines cartLine);
	public boolean update(CartLines cartLine);
	public boolean remove(CartLines cartLine);
	boolean updateCart(Cart cart);
	public List<CartLines> listAvailable(int cartId);
	public CartLines getByCartAndProduct(int cartId, int productId);
	
	boolean addOrderDetail(OrderDetails orderDetail);

}
