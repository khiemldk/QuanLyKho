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
public class product_in_stock extends Common {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qty;
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	product product;
	
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public product_in_stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product_in_stock(int qty,double price,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.qty = qty;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
