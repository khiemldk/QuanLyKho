package Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class history extends Common{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String action_name;
	private int type;
	private int qty;
	private double price;
	
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	product product;
	
	public history() {
		super();
		// TODO Auto-generated constructor stub
	}
	public history(String action_name,int type,int qty,double price,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.action_name = action_name;
		this.qty = qty;
		this.price = price;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
