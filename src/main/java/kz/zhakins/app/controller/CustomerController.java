package kz.zhakins.app.controller;

import kz.zhakins.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import kz.zhakins.app.model.Customer;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list(){
		//ModelAndView model = new ModelAndView("/list");
		ModelAndView model = new ModelAndView("/customer/list");
		//ModelAndView model = new ModelAndView();
		List<Customer> list = customerService.listAllCustomers("");
		/*List<String> list = new ArrayList<String>();
		list.add("1");
		*/
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
		Customer customer = customerService.findCustomerById(id);
		
		model.addObject("customerForm", customer);
		return model;
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("customer/form");
		customerService.deleteCustomer(id);
		
		
		return new ModelAndView("redirect:/customer/list");
	}
	

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customer/form") Customer customer){
		ModelAndView model = new ModelAndView("customer/form");

		customerService.saveOrUpdate(customer);
		
		return new ModelAndView("redirect:/customer/list");
	}

	
}
