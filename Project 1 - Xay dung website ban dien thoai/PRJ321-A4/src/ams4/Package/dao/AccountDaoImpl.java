package ams4.Package.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mysql.jdbc.PreparedStatement;

import ams4.Package.model.Administrator;

public class AccountDaoImpl implements AccountDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public  AccountDaoImpl (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Administrator getAccount(String email, String pass) {
		String sql = "select * from account where user_mail =? and password =?";
		
		ResultSetExtractor<Administrator> extractor = new ResultSetExtractor<Administrator>() {
			
			@Override
			public Administrator extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String acc_email= rs.getString("user_mail");
					String acc_password= rs.getString("password");
					
					return new Administrator(acc_email, acc_password);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, new Object[] {email, pass}, extractor);
	}
	@Override
	public Administrator get(String email, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
