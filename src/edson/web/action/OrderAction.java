package edson.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.web.domain.Order;
import edson.web.exceptions.DbException;
import edson.web.service.BusinessService;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{

	private Order order=new Order();
	private List<Order> orders=new ArrayList<Order>();
	private String customer_id;//接受客户编号

	@Override
	public Order getModel() {
		return order;
	}
	
	public String list() throws DbException{
		try{
			BusinessService service=new BusinessService();
			orders=service.findAllOrders(Integer.valueOf(customer_id));
			
			if(orders.size()<=0){
				this.addActionMessage("该客户未订购任何商品！");
			}
			
			return "success_list";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e);
		}
	
	}
	
	public String add() throws DbException{
		try{
			BusinessService service=new BusinessService();
			service.addOrder(Integer.valueOf(customer_id),order);
			orders=service.findAllOrders(Integer.valueOf(customer_id));
			
			return "success_add";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		
	}
	
	public String updateUI() throws DbException{
		try{
			BusinessService service=new BusinessService();
			order=service.findOrder(Integer.valueOf(order.getId()));
			
			return "success_updateUI";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		
	}
	
	
	public String update() throws DbException{
		try{
			BusinessService service=new BusinessService();
			service.updateOrder(order,Integer.valueOf(customer_id));
			orders=service.findAllOrders(Integer.valueOf(customer_id));
			
			return "success_update";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		
	}
	
	public String delete() throws DbException{
		try{
			BusinessService service=new BusinessService();
			service.deleteOrder(order,Integer.valueOf(customer_id));
			orders=service.findAllOrders(Integer.valueOf(customer_id));
			
			return "success_update";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

}
