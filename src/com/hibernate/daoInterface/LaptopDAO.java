package com.hibernate.daoInterface;

import java.util.List;

import com.hibernate.model.Laptop;

public interface LaptopDAO {

	public void insertLaptop(Laptop laptop);
	public boolean updateLaptopName(long lapId, String name);
	public Laptop getLaptopInfo(long lapId);
	public List<Laptop> getAllLaptops();
	public boolean removeLaptop(long lapId);
}
