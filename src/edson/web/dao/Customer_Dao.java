package edson.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edson.web.domain.Customer;
import edson.web.utils.HibernateUtil;

public class Customer_Dao {

	public List<Customer> findAll() {
		
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		List<Customer> customers=session.createQuery("from Customer").list();
		
		ts.commit();
		session.close();
		
		return customers;
	}

	public void add(Customer customer) {
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		session.save(customer);
		
		ts.commit();
		session.close();
		
	}

	public Customer findCustomer(Integer c_id) {
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		Customer customer=(Customer) session.get(Customer.class, c_id);
		
		ts.commit();
		session.close();
		return customer;
	}

	public void updateCustomer(Customer customer) {
		Session session=HibernateUtil.getCurrentSession();
		Transaction ts=session.beginTransaction();
		
		session.update(customer);
		ts.commit();
//		session.close();会自动关闭Session
	}

	public void delete(Integer c_id) {
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		session.delete(session.load(Customer.class, c_id));
		ts.commit();
		session.close();
	}

	

}
