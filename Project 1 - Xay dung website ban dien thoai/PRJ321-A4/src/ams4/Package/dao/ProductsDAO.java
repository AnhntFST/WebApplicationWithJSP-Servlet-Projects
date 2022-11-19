package ams4.Package.dao;

import java.util.List;

import ams4.Package.model.Products;

public interface ProductsDAO {
	public Products get (Integer id);
	
	public List<Products> list();
}
