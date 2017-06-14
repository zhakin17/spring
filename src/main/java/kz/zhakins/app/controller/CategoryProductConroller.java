package kz.zhakins.app.controller;
import kz.zhakins.app.model.CategoryProduct;
import kz.zhakins.app.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;



/**
 * Created by User on 14.06.2017.
 */
@Controller
@RequestMapping(value = "/categoryProduct")
public class CategoryProductConroller {

    @Autowired
    private CategoryProductService categoryProductService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(){

        ModelAndView model = new ModelAndView("/categoryProduct/list");

        List<CategoryProduct> list = categoryProductService.listAllCustomers("");

        model.addObject("list", list);
        return model;
    }
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView model = new ModelAndView("/categoryProduct/form");
        //model.setView("customer/form");
        //Customer customer = new Customer("Samat","Zhakin","male","Korday 2 123");
        CategoryProduct categoryProduct = new CategoryProduct();
        //customerDao.saveOrUpdate(customer);
        model.addObject("categoryProductForm", categoryProduct);
        //return model;
        return model;
    }
    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("categoryProduct/form");
        CategoryProduct categoryProduct = categoryProductService.findCustomerById(id);

        model.addObject("categoryProductForm", categoryProduct);
        return model;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("categoryProduct/form");
        categoryProductService.deleteCustomer(id);


        return new ModelAndView("redirect:/categoryProduct/list");
    }


    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("categoryProduct/form") CategoryProduct categoryProduct){
        ModelAndView model = new ModelAndView("categoryProduct/form");

        categoryProductService.saveOrUpdate(categoryProduct);

        return new ModelAndView("redirect:/categoryProduct/list");
    }
}
