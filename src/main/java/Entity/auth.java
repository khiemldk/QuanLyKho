package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class auth extends Common{
	@Id
	private int id;
	private int role_id;
	private int menu_id;
	private int permision;
	public auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public auth(int role_id,int menu_id,int permision,Boolean active_flag, Date create_date, Date update_date) {
		super(active_flag, create_date, update_date);
		// TODO Auto-generated constructor stub
		this.role_id = role_id;
		this.menu_id = menu_id;
		this.permision = permision;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getPermision() {
		return permision;
	}
	public void setPermision(int permision) {
		this.permision = permision;
	}
	

}
