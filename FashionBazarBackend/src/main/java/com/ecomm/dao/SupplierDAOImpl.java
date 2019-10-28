package com.ecomm.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecomm.model.Supplier;
@Repository("SupplierDAO")
@Transactional 

public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier)
{

		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
		
		return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
		
		return false;
		}
	}

	public boolean updateSupplier(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
		
		return false;
		}
	}

	public Supplier getSupplier(int supplierId)
	{
		
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return  supplier;
	}

	public List<Supplier> getSupplierList()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier>supplierList=query.list();
		session.close();
		return supplierList;
		
	}
	

}
