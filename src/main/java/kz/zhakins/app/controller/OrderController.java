package kz.zhakins.app.controller;

import kz.zhakins.app.model.*;
import kz.zhakins.app.service.CustomerService;
import kz.zhakins.app.service.OrderService;
import kz.zhakins.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by samatzhakin on 17.06.17.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(){

        ModelAndView model = new ModelAndView("/order/list");



        List<Orders> list = orderService.listAllOrders("");
        model.addObject("list", list);

        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("/order/form");
        //model.setView("customer/form");
        //Customer customer = new Customer("Samat","Zhakin","male","Korday 2 123");
        Orders order = new Orders();
        //customerDao.saveOrUpdate(customer);
        List<Product> products = productService.listAllProducts("");
        model.addObject("products", products);

        List<Customer> customers = customerService.listAllCustomers("");
        model.addObject("customers", customers);

        model.addObject("orderForm", order);
        //return model;
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("order/form");
        Orders order = orderService.findOrderrById(id);

        List<Product> products = productService.listAllProducts("");
        model.addObject("products", products);

        List<Customer> customers = customerService.listAllCustomers("");
        model.addObject("customers", customers);

        model.addObject("orderForm", order);
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("order/form");
        orderService.deleteCustomer(id);


        return new ModelAndView("redirect:/order/list");
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("order/form") Orders order) {
        ModelAndView model = new ModelAndView("order/form");

        orderService.saveOrUpdate(order);

        return new ModelAndView("redirect:/order/list");

    }
}
