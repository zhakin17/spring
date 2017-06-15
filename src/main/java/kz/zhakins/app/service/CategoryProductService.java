package kz.zhakins.app.service;

import kz.zhakins.app.model.CategoryProduct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 14.06.2017.
 */
@Service
@Transactional
public class CategoryProductService {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<CategoryProduct> listAllCustomers(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM CategoryProduct Where name like :NM");
        query.setString("NM", "%" + name + "%");
        return  query.list();
    }

    public void saveOrUpdate(CategoryProduct categoryProduct) {
        sessionFactory.getCurrentSession().saveOrUpdate(categoryProduct);
    }

    public CategoryProduct findCustomerById(int id) {
        CategoryProduct categoryProduct = sessionFactory.getCurrentSession().get(CategoryProduct.class, id);
        return categoryProduct;
    }

    public void deleteCustomer(int id) {
        CategoryProduct categoryProduct = sessionFactory.getCurrentSession().get(CategoryProduct.class, id);
        sessionFactory.getCurrentSession().delete(categoryProduct);
    }
}
