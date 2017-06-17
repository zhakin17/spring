package kz.zhakins.app.service;

import kz.zhakins.app.model.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samatzhakin on 17.06.17.
 */
@Service
@Transactional
public class OrderService {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<Orders> listAllOrders(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Orders Where name like :NM");
        query.setString("NM", "%" + name + "%");
        return  null; //query.list();
    }

    public void saveOrUpdate(Orders order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    public Orders findOrderrById(int id) {
        Orders order = sessionFactory.getCurrentSession().get(Orders.class, id);
        return order;
    }

    public void deleteCustomer(int id) {
        Orders order = sessionFactory.getCurrentSession().get(Orders.class, id);
        sessionFactory.getCurrentSession().delete(order);
    }
}
