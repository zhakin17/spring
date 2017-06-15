package kz.zhakins.app.service;

import kz.zhakins.app.model.CategoryCredit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by samatzhakin on 15.06.17.
 */
@Service
@Transactional
public class CategoryCreditService {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<CategoryCredit> listAllCustomers(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM CategoryCredit Where name like :NM");
        query.setString("NM", "%" + name + "%");
        return  query.list();
    }

    public void saveOrUpdate(CategoryCredit categoryCredit) {
        sessionFactory.getCurrentSession().saveOrUpdate(categoryCredit);
    }

    public CategoryCredit findCustomerById(int id) {
        CategoryCredit categoryCredit = sessionFactory.getCurrentSession().get(CategoryCredit.class, id);
        return categoryCredit;
    }

    public void deleteCustomer(int id) {
        CategoryCredit categoryCredit = sessionFactory.getCurrentSession().get(CategoryCredit.class, id);
        sessionFactory.getCurrentSession().delete(categoryCredit);
    }

}
