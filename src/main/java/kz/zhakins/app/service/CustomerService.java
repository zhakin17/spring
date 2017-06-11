package kz.zhakins.app.service;

import kz.zhakins.app.model.Customer;

import java.util.List;

public interface CustomerService {

	public List<Customer> listAllCustomers();

	public void saveOrUpdate(Customer customer);

	public Customer findCustomerById(int id);

	public void deleteCustomer(int id);
}
