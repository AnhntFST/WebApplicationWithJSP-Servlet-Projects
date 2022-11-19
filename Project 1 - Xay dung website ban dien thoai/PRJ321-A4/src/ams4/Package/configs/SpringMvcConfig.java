package ams4.Package.configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ams4.Package.dao.AccountDAO;
import ams4.Package.dao.AccountDaoImpl;
import ams4.Package.dao.ProductsDAO;
import ams4.Package.dao.ProductsDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ams4.Package")
public class SpringMvcConfig implements WebMvcConfigurer {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shoppingdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Ntanh@123");
		return dataSource;
	}
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new  InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ProductsDAO getProductsDAO () {
		return new ProductsDAOImpl(getDataSource());

	}
	
	@Bean
	public AccountDAO getAccountDAO() {
		return new AccountDaoImpl(getDataSource());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/URLToResourcesFolder/**").addResourceLocations("/resources/");
	}
	
}
