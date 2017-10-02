package edson.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.web.domain.Customer;
import edson.web.exceptions.DbException;
import edson.web.service.BusinessService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private Customer customer=new Customer();
	private List<Customer> customers=new ArrayList<Customer>();
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	public String list() throws DbException{
		
		try{
			BusinessService service=new BusinessService();
			customers=service.findAll();
			
			if(customers.size()<1){
				this.addActionMessage("尚未有任何客户！");
			}
			return "success_list";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException("服务器内部错误，请稍后尝试！");
		}
		
	}
	
	public String add() throws DbException{
		
		try{
			BusinessService service=new BusinessService();
			service.add(customer);
			customers=service.findAll();
			
			if(customers.size()<1){
				this.addActionMessage("尚未有任何客户！");
			}
			return "success_add";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException("服务器内部错误，请稍后尝试！");
		}
		
	}
	
	public String updateUI() throws DbException{
		
		try{
			BusinessService service=new BusinessService();
			String c_id=ServletActionContext.getRequest().getParameter("c_id");
			customer=service.findCustomer(Integer.valueOf(c_id));
			
			return "success_updateUI";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException("服务器内部错误，请稍后尝试！");
		}
	}
		
	public String update() throws DbException{
		
		try{
			BusinessService service=new BusinessService();
			service.updateCustomer(customer);
			
			customers=service.findAll();
			
			return "success_update";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException("服务器内部错误，请稍后尝试！");
		}
		
	}
	
	public String delete() throws DbException{
		
		try{
			BusinessService service=new BusinessService();
			String c_id=ServletActionContext.getRequest().getParameter("c_id");
			service.deleteCustomer(Integer.valueOf(c_id));
			
			customers=service.findAll();
			
			return "success_delete";
		}catch (Exception e) {
			e.printStackTrace();
			throw new DbException("服务器内部错误，请稍后尝试！");
		}
		
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	

	
	

}
