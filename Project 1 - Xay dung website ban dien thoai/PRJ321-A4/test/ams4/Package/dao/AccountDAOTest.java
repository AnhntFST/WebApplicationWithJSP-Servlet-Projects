package ams4.Package.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ams4.Package.model.Administrator;

class AccountDAOTest {
	private DriverManagerDataSource dataSource;
	private AccountDAO dao;
	
	
	@Test
	void testGet() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shoppingdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Ntanh@123");
		
		dao = new AccountDaoImpl(dataSource);
		
		String email = "duongdt@fpt.com.vn";
		String pass = "123";
		
		Administrator ad = dao.get(email, pass);
		
		System.out.println(ad.toString());
	}

}
