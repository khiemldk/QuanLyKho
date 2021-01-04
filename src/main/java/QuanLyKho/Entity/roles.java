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
public class roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role_name;
	private String description;
	
	@OneToMany(mappedBy = "roles")
	Set<user_role> user_roles;
	
	@OneToMany(mappedBy = "roles")
	Set<auth> auths;
	
	
	public Set<auth> getAuths() {
		return auths;
	}
	public void setAuths(Set<auth> auths) {
		this.auths = auths;
	}
	public Set<user_role> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<user_role> user_roles) {
		this.user_roles = user_roles;
	}
	
	public roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public roles(String role_name,String description,Boolean active_flag, Date create_date, Date update_date) {

		// TODO Auto-generated constructor stub
		this.role_name = role_name;
		this.description = description;
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
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
