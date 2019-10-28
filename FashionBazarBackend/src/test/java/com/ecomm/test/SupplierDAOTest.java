package com.ecomm.test;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertTrue;

import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

public class SupplierDAOTest {
	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("SupplierDAO");
	}
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Reliance");
		supplier.setSupplierId(34);
		supplier.setSupplierAddr("k-no 3,khandala Maharastra");
		assertTrue("true",supplierDAO.addSupplier(supplier));
}

}
