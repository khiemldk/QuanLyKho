package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user_role extends Common{
	@Id
	private int id;
	private int user_id;
	private int role_id;
	
	
	public user_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user_role(int user_id,int role_id,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.user_id = user_id;
		this.role_id = role_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
