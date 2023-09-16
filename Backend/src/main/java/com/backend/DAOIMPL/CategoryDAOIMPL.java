package com.backend.DAOIMPL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.DAO.CategoryDAO;
import com.backend.model.Category;



@Repository("categoryDAO")
@Transactional
public class CategoryDAOIMPL implements CategoryDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insert(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> activeCategoryList() 
	{
		try
		{
		String query = "From Category where active=:active";
		return sessionFactory.getCurrentSession()
				.createQuery(query,Category.class)
					.setParameter("active", true)
					.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Category get(int id) 
	{
		try
		{
			return sessionFactory.getCurrentSession().get(Category.class,id);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
