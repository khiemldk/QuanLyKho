package QuanLyKho.Entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int parent_id;
	private String url;
	private String name;
	private int order_index;
	@Transient
	private String idMenu; // 2 thằng này t thêm vào
	@Transient
	private List<menu> child; // đây nữa . nhưng chỉ thằng này bị lỗi
	
	public List<menu> getChild() {
		return child;
	}
	public void setChild(List<menu> child) {
		this.child = child;
	}
	public String getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="menu_id")
	Set<auth> auths;
	
	public Set<auth> getAuths() {
		return auths;
	}
	public void setAuths(Set<auth> auths) {
		this.auths = auths;
	}
	public Set<roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<roles> roles) {
		this.roles = roles;
	}
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

		// TODO Auto-generated constructor stub
		this.parent_id = parent_id;
		this.url = url;
		this.name = name;
		this.order_index= order_index;
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