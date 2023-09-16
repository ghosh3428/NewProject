package com.backend.DAO;

import java.util.List;

import com.backend.model.Category;



public interface CategoryDAO 
{
	public boolean insert(Category category);
	
	public List<Category> activeCategoryList();
	
	public Category get(int id);

}
