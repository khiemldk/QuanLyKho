package Entity;

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

@Entity
public class roles extends Common{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role_name;
	private String description;
	
	@ManyToMany
	@JoinTable(
	name="user_role",
	joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="user_id",referencedColumnName = "id")
			)
	Set<users> users; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="auth",
		joinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name="menu_id",referencedColumnName = "id")}
			)
	Set<menu> menu;
	
	public Set<users> getUsers() {
		return users;
	}
	public void setUsers(Set<users> users) {
		this.users = users;
	}
	public roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public roles(String role_name,String description,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.role_name = role_name;
		this.description = description;
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
	
		
}
