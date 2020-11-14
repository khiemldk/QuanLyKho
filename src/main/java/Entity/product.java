package Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class product extends Common {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//private int cate_id;
	private String name;
	private String code;
	private String description;
	private String img_url;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cate_id")
	category category;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	Set<product_in_stock> product_in_stock;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	Set<history> history;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	Set<invoice> invoice;
	public Set<history> getHistory() {
		return history;
	}
	public void setHistory(Set<history> history) {
		this.history = history;
	}
	public Set<invoice> getInvoice() {
		return invoice;
	}
	public void setInvoice(Set<invoice> invoice) {
		this.invoice = invoice;
	}
	public Set<product_in_stock> getProduct_in_stock() {
		return product_in_stock;
	}
	public void setProduct_in_stock(Set<product_in_stock> product_in_stock) {
		this.product_in_stock = product_in_stock;
	}
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(String name,String code,String description,String img_url,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub

		this.name = name;
		this.code = code;
		this.description = description;
		this.img_url = img_url;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getCate_id() {
//		return cate_id;
//	}
//	public void setCate_id(int cate_id) {
//		this.cate_id = cate_id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
