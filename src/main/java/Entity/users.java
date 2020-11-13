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
public class users extends Common{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
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
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		//this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
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

	
}
