package kz.zhakins.app.service;

import kz.zhakins.app.dao.CustomerDao;
import kz.zhakins.app.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//public class CustomerServiceImpl implements CustomerService {
public class CustomerServiceImpl  {
	CustomerDao customerDao;
	
	
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	

	public List<Customer> listAllCustomers(Customer name) {
		
		return customerDao.listAllCustomers(name);
	}

	


	public void saveOrUpdate(Customer customer) {
		customerDao.saveOrUpdate(customer);

	}

	@Autowired
	public Customer findCustomerById(int id) {
		
		return customerDao.findCustomerById(id);
	}

	@Autowired
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);

	}

}
