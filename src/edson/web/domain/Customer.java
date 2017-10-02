package edson.web.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Integer id;
	private String cname;
	private String addr;
	private String cellphone;
	private Set <Order>orders=new HashSet<Order>();
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
