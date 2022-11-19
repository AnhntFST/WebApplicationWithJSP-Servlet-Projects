package ams4.Package.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ams4.Package.model.Products;

public class ProductsDAOImpl implements ProductsDAO { 

	private JdbcTemplate jdbcTemplate;
	
	public ProductsDAOImpl (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Products get(Integer id) {
		String sql = "select * from products where product_id ="+ id;
		
		ResultSetExtractor<Products> extractor = new ResultSetExtractor<Products>() {
			
			@Override
			public Products extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("product_name");
					String des = rs.getString("product_des");
					Double price = rs.getDouble("product_price");
					String img_source = rs.getString("product_img_source");
					String type = rs.getString("product_type");
					String brand = rs.getString("product_brand");
					
					return new Products(id, name, des, type, price, brand, img_source);
					
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
		
		
	}

	@Override
	public List<Products> list() {
		String sql = "select * from products";
		
		RowMapper<Products> rowMapper = new RowMapper<Products>() {
			
			@Override
			public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String des = rs.getString("product_des");
				Double price = rs.getDouble("product_price");
				String img_source = rs.getString("product_img_source");
				String type = rs.getString("product_type");
				String brand = rs.getString("product_brand");
				
				return new Products(id, name, des, type, price, brand, img_source);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
