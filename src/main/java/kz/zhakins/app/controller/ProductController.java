package kz.zhakins.app.controller;
import kz.zhakins.app.model.CategoryCredit;
import kz.zhakins.app.model.CategoryProduct;
import  kz.zhakins.app.model.Product;

import kz.zhakins.app.service.CategoryCreditService;
import kz.zhakins.app.service.CategoryProductService;
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
 * Created by User on 15.06.2017.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryProductService categoryProductService;
    @Autowired
    private CategoryCreditService categoryCreditService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(){

        ModelAndView model = new ModelAndView("/product/list");



        List<Product> list = productService.listAllProducts("");
        model.addObject("list", list);

        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("/product/form");
        //model.setView("customer/form");
        //Customer customer = new Customer("Samat","Zhakin","male","Korday 2 123");
        Product product = new Product();
        //customerDao.saveOrUpdate(customer);
        List<CategoryCredit> categoryCredits = categoryCreditService.listAllCategoryCredits("");
        model.addObject("categoryCredits", categoryCredits);

        List<CategoryProduct> categoryProducts = categoryProductService.listAllCustomers("");
        model.addObject("categoryProducts", categoryProducts);

        model.addObject("productForm", product);
        //return model;
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("product/form");
        Product product = productService.findCustomerById(id);

        List<CategoryCredit> categoryCredits = categoryCreditService.listAllCategoryCredits("");
        model.addObject("categoryCredits", categoryCredits);

        List<CategoryProduct> categoryProducts = categoryProductService.listAllCustomers("");
        model.addObject("categoryProducts", categoryProducts);
        model.addObject("productForm", product);
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("product/form");
        productService.deleteCustomer(id);


        return new ModelAndView("redirect:/product/list");
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("product/form") Product product) {
        ModelAndView model = new ModelAndView("product/form");

        productService.saveOrUpdate(product);

        return new ModelAndView("redirect:/product/list");

    }
}
