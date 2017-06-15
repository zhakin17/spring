package kz.zhakins.app.controller;
import kz.zhakins.app.model.CategoryCredit;
import kz.zhakins.app.service.CategoryCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by samatzhakin on 15.06.17.
 */
@Controller
@RequestMapping(value = "/categoryCredit")
public class CategoryCreditController {

    @Autowired
    private CategoryCreditService categoryCreditService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(){

        ModelAndView model = new ModelAndView("/categoryProduct/list");

        List<CategoryCredit> list = categoryCreditService.listAllCustomers("");

        model.addObject("list", list);
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("/categoryCredit/form");
        //model.setView("customer/form");
        //Customer customer = new Customer("Samat","Zhakin","male","Korday 2 123");
        CategoryCredit categoryProduct = new CategoryCredit();
        //customerDao.saveOrUpdate(customer);
        model.addObject("categoryCreditForm", categoryProduct);
        //return model;
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("categoryCredit/form");
        CategoryCredit categoryProduct = categoryCreditService.findCustomerById(id);

        model.addObject("categoryCreditForm", categoryProduct);
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("categoryCredit/form");
        categoryCreditService.deleteCustomer(id);


        return new ModelAndView("redirect:/categoryCredit/list");
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("categoryCredit/form") CategoryCredit categoryProduct) {
        ModelAndView model = new ModelAndView("categoryCredit/form");

        categoryCreditService.saveOrUpdate(categoryProduct);

        return new ModelAndView("redirect:/categoryCredit/list");

    }
}
