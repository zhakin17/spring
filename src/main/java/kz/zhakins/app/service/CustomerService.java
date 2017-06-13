package kz.zhakins.app.service;

import kz.zhakins.app.model.Customer;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Customer> listAllCustomers(String name) {


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
