package com.backend.categoryTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.DAO.CategoryDAO;
import com.backend.model.Category;



public class CategoryTest 
{

private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.backend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void categoryAddTest()
	{
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Sample category for Laptop devices.");
		category.setActive(true);
		
		assertEquals("Error adding category" , true , categoryDAO.insert(category));
	}
}
