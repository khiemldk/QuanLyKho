package QuanLyKho.Entity;

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
public class category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String code;
	private String description;
	
	@OneToMany
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

		// TODO Auto-generated constructor stub
		this.name = name;
		this.code = code;
		this.description= description;
		this.active_flag = active_flag;
		this.create_date = create_date;
		this.update_date = update_date;
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
	public Boolean active_flag;
	public Date create_date;
	public Date update_date;
	
	
	public Boolean getActive_flag() {
		return active_flag;
	}
	public void setActive_flag(Boolean active_flag) {
		this.active_flag = active_flag;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	
	
}
