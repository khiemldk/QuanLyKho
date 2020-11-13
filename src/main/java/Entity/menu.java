package Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class menu extends Common{
	@Id
	private int id;
	private int parent_id;
	private String url;
	private String name;
	private int order_index;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="auth",
		joinColumns = {@JoinColumn(name="menu_id",referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")}
			)
	Set<roles> roles;
	
	public menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public menu(int parent_id,String url,String name,int order_index,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.parent_id = parent_id;
		this.url = url;
		this.name = name;
		this.order_index= order_index;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder_index() {
		return order_index;
	}
	public void setOrder_index(int order_index) {
		this.order_index = order_index;
	}
	
	
	
}
