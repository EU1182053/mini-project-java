package com.model;

import com.pojo.Menu;

public interface MenuDao {

	public boolean addFood(Menu menu);
	public boolean updateFood(Menu menu);
	public boolean deleteFood(int id);
	
}
