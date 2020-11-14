package Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class category extends Common{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String code;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cate_id")
	Set<product> product;
	
	public Set<product> getProduct() {
		return product;
	}
	public void setProduct(Set<product> product) {
		this.product = product;
	}
	public category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public category(String name,String code,String description,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.code = code;
		this.description= description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	
	
}
