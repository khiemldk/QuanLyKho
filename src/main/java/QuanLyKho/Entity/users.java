package QuanLyKho.Entity;

import java.util.Date;
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

@Entity
public class users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	Set<user_role> user_roles;
	
	
	
	public Set<user_role> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<user_role> user_roles) {
		this.user_roles = user_roles;
	}
	@ManyToMany
	@JoinTable(
	name = "user_role",
	joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")}	
			)
	Set<roles> roles;
	
	public Set<roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<roles> roles) {
		this.roles = roles;
	}
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public users(String username,String password,String email,String name,Boolean active_flag, Date create_date, Date update_date) {
		// TODO Auto-generated constructor stub
		//this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
