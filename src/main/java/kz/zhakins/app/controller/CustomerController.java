package kz.zhakins.app.controller;

import kz.zhakins.app.dao.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import kz.zhakins.app.model.Customer;
import kz.zhakins.app.dao.CustomerDaoImpl;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerDaoImpl customerDao;


	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list(){
		//ModelAndView model = new ModelAndView("/list");
		ModelAndView model = new ModelAndView("/customer/list");
		//ModelAndView model = new ModelAndView();
		List<Customer> list = customerDao.listAllCustomers("");
		/*List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("3");
		list.add("3");
		list.add("3");*/
		model.addObject("list", list);
		return model;
	}
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("/customer/form");
		//model.setView("customer/form");
		//Customer customer = new Customer("Samat","Zhakin","male","Korday 2 123");
		Customer customer = new Customer();
        //customerDao.saveOrUpdate(customer);
		model.addObject("customerForm", customer);
		//return model;
		return model;
	}
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("customer/form");
		Customer customer = customerDao.findCustomerById(id);
		
		model.addObject("customerForm", customer);
		return model;
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("customer/form");
		customerDao.deleteCustomer(id);
		
		
		return new ModelAndView("redirect:/customer/list");
	}
	

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customer/form") Customer customer){
		ModelAndView model = new ModelAndView("customer/form");

		customerDao.saveOrUpdate(customer);
		
		return new ModelAndView("redirect:/customer/list");
	}

	
}
