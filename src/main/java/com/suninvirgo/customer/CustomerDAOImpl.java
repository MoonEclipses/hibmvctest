package com.suninvirgo.customer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Locale;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    SessionFactory sessionFactory;
    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer order by lastName");

        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }


    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id =:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        if (searchName != null && searchName.trim().length()>0){
            query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name order by lastName");
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        }
        else {
            query = session.createQuery("from Customer order by lastName");
        }
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
