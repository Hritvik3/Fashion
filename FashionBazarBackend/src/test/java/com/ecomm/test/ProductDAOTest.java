package com.ecomm.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertTrue;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;
public class ProductDAOTest 
{
	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("ProductDAO");
	}
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("T-Shirt-lee cooper");
		product.setProductDesc("pull round neck with excellent color");
		product.setPrice(500);
		product.setStock(50);
		product.setCategoryId(1);
		product.setSupplierId(2);
		assertTrue("",productDAO.addProduct(product));
        
	}

}
