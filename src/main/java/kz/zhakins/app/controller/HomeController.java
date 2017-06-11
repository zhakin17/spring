package kz.zhakins.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11.06.2017.
 */
@Controller
public class HomeController {

    /*@RequestMapping(value = "/list")
    public  String home(){
        return  "home";
    }*/
    @RequestMapping(value="/qwer", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("customer/list");
        //List<Customer> list = customerServiceImpl.listAllCustomers();
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        model.addObject("list", list);
        return model;
    }
}
