package kz.zhakins.app.dao;

import kz.zhakins.app.model.Customer;

import org.hibernate.Query;

import javax.persistence.Query.*;


import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("customerDao")
@Transactional
public class CustomerDaoImpl  {

	@Autowired
	private SessionFactory sessionFactory;
	/*@Autowired
	private Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}*/
	@SuppressWarnings("unchecked")
	public List<Customer> listAllCustomers(String name) {

		/*Query query = sessionFactory.getCurrentSession().createQuery("SELECT ALL FROM CUSTOMER").list();

		return 	query.list();*/

/*
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> listCustomers = query.list();
		return listCustomers;*/


		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Customer Where firstname like :NM");
		query.setString("NM", "%" + name + "%");

		// Retrieve all
		return  query.list();
	}



	public void saveOrUpdate(Customer customer) {
		//getSession().saveOrUpdate(customer);
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}


	public Customer findCustomerById(int id) {
		Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
		
		return customer;
	}

	public void deleteCustomer(int id) {
		Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
		sessionFactory.getCurrentSession().delete(customer);
	}

}
