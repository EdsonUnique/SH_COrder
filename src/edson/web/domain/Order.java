package edson.web.domain;

public class Order {
	
	private Integer id;
	private String odate;
	private String items;//Ӧ��һ��Set������������Ʒ���ݣ�����Ϊ�˼��
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Order(Integer id, String odate, String items) {
		super();
		this.id = id;
		this.odate = odate;
		this.items = items;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
