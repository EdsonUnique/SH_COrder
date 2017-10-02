package edson.web.service;


import java.util.List;

import edson.web.dao.Customer_Dao;
import edson.web.dao.Order_Dao;
import edson.web.domain.Customer;
import edson.web.domain.Order;

public class BusinessService {
	
	private static Customer_Dao c_dao=new Customer_Dao();
	private static Order_Dao o_dao=new Order_Dao();

	public List<Customer> findAll() {
		
		return c_dao.findAll();
	}

	public void add(Customer customer) {
		c_dao.add(customer);
		
	}

	public List<Order> findAllOrders(Integer id) {
		return o_dao.findAll(id);
	}

	public void addOrder(Integer customer_id,Order order) {
		o_dao.addOrder(customer_id,order);
		
	}

	public Customer findCustomer(Integer c_id) {
		return c_dao.findCustomer(c_id);
	}

	public void updateCustomer(Customer customer) {
		c_dao.updateCustomer(customer);
		
	}

	public void deleteCustomer(Integer c_id) {
		c_dao.delete(c_id);
		
	}

	public Order findOrder(Integer order_id) {
		
		return o_dao.findOrder(order_id);
	}

	public void updateOrder(Order order, Integer customer_id) {
		o_dao.updateOrder(order,customer_id);
	}

	public void deleteOrder(Order order, Integer customer_id) {
		o_dao.deleteOrder(order,customer_id);
		
	}

}
