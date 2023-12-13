package com.backend.DAO;

import java.util.List;

import com.backend.model.Address;
import com.backend.model.User;



public interface UserDAO 
{
	boolean addUser(User user);
	User getByEmail(String email) ;
	List<User> getSupplierList() ;
	
	boolean addAddress(Address address);
	
	public Address getBillingAddress(int user_id);
	public List<Address> getShippingAddress(int user_id);
	
	public Address getAddress(int address_id);

}
