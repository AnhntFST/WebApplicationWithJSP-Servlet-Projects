package ams4.Package.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ams4.Package.dao.ProductsDAO;
import ams4.Package.model.Products;

@Controller
public class MainController {
	
	@Autowired
	private ProductsDAO productsDAO;
	
	@RequestMapping("/")
	public ModelAndView listProduct(ModelAndView model) {
		List<Products> listProducts = productsDAO.list();
		model.addObject("listProducts", listProducts);
		model.setViewName("home");
		return model;
	}
	
}
