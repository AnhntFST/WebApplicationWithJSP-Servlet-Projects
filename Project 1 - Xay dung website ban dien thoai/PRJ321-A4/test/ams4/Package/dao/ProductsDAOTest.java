package ams4.Package.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ams4.Package.model.Products;

class ProductsDAOTest {

	private DriverManagerDataSource dataSource;
	private ProductsDAO dao;
	
	@BeforeEach
	void beforEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shoppingdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Ntanh@123");
		
		dao = new ProductsDAOImpl(dataSource);
	}
	@Test
	void testGet() {
		Integer id = 2;
		Products p = dao.get(id);
		assertNotNull(p);
	}

	@Test
	void testList() {
		List<Products> list = dao.list();
		
		for (Products p : list) {
			System.out.println(p);
		}
	}

}
