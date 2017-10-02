package edson.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edson.web.domain.Customer;
import edson.web.domain.Order;
import edson.web.utils.HibernateUtil;

public class Order_Dao {

	public List<Order> findAll(Integer id) {
		
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		
		Query qr=session.createQuery("from Order where customer_id=?");
		qr.setParameter(0, id);
		
		List<Order> orders=qr.list();
		ts.commit();
		session.close();
		return orders;
	}
	

	public void addOrder(Integer customer_id,Order order) {
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		Customer customer=(Customer) session.load(Customer.class, customer_id);
		customer.getOrders().add(order);
		order.setCustomer(customer);
		
		session.save(customer);
		
		ts.commit();
		session.close();
	}


	public Order findOrder(Integer order_id) {
		Session session=HibernateUtil.openSession();
		Transaction ts=session.beginTransaction();
		
		Order order=(Order) session.get(Order.class, order_id);
		
		ts.commit();
		session.close();
		return order;
	}


	public void updateOrder(Order order, Integer customer_id) {
		Session session=HibernateUtil.getCurrentSession();
		Transaction ts=session.beginTransaction();
		
		session.update(order);
		Customer customer=(Customer) session.get(Customer.class, customer_id);
		customer.getOrders().add(order);
		order.setCustomer(customer);
		
		ts.commit();
	}


	public void deleteOrder(Order order, Integer customer_id) {
		Session session=HibernateUtil.getCurrentSession();
		Transaction ts=session.beginTransaction();
		
		Customer customer=(Customer) session.get(Customer.class, customer_id);
		Order oorder=(Order) session.get(Order.class, order.getId());
		customer.getOrders().remove(oorder);
		
		session.update(customer);
		
		ts.commit();
	}

}
