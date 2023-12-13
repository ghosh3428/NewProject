package com.backend.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.DAO.UserDAO;
import com.backend.model.Address;
import com.backend.model.User;


@Repository("userDAO")
@Transactional
public class UserDAOIMPL implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) 
	{
		try 
		{			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}

	@Override
	public User getByEmail(String email) 
	{
		String selectQuery = "FROM User WHERE email = :email";
		try 
		{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		
		catch(Exception ex) 
		{
			return null;
		}
	}

	@Override
	public List<User> getSupplierList() {
		try
		{
			String selectuser = "FROM User WHERE role = :role and enabled = :enabled";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("role", "SUPPLIER");
			query.setParameter("enabled", true);
							
			return query.getResultList();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try 
		{			
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}
	
	public List<Address> getShippingAddress(int id) 
	{
		try
		{
			String selectuser = "FROM Address WHERE userId = :userID and shipping = :shipping";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("userID", id);
			query.setParameter("shipping", true);
							
			return query.getResultList();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public Address getBillingAddress(int id) 
	{
		try
		{
			String selectuser = "FROM Address WHERE userId = :userID and billing = :billing";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("userID", id);
			query.setParameter("billing", true);
							
			return (Address) query.getSingleResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public Address getAddress(int addressid) 
	{
		try
		{
			String selectuser = "FROM Address WHERE id = :addressID";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("addressID", addressid);
							
			return (Address) query.getSingleResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
