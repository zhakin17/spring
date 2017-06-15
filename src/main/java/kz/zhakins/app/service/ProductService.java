package kz.zhakins.app.service;
import kz.zhakins.app.model.Product;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 15.06.2017.
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Product> listAllProducts(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product Where name like :NM");
        query.setString("NM", "%" + name + "%");
        return  query.list();
    }

    public void saveOrUpdate(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    public Product findCustomerById(int id) {
        Product product = sessionFactory.getCurrentSession().get(Product.class, id);
        return product;
    }

    public void deleteCustomer(int id) {
        Product product = sessionFactory.getCurrentSession().get(Product.class, id);
        sessionFactory.getCurrentSession().delete(product);
    }
}
