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

}
