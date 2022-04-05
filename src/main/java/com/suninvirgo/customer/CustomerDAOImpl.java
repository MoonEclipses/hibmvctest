package com.suninvirgo.customer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{

    SessionFactory sessionFactory;
    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public void updateCustomer(int id) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}