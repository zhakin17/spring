package kz.zhakins.app.dao;

import kz.zhakins.app.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CustomerDao {

	public List<Customer> listAllCustomers(Customer name);

	public void saveOrUpdate(Customer customer);

	public Customer findCustomerById(int id);

	public void deleteCustomer(int id);
}
