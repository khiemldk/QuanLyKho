package QuanLyKho.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class auth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int permision;
	public Boolean active_flag;
	public Date create_date;
	public Date update_date;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	roles roles;
	
	@ManyToOne
	@JoinColumn(name="menu_id")
	menu menu;
	
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
	public auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public auth(int permision,Boolean active_flag, Date create_date, Date update_date) {

		// TODO Auto-generated constructor stub

		this.permision = permision;
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

	
	public roles getRoles() {
		return roles;
	}
	public void setRoles(roles roles) {
		this.roles = roles;
	}
	public menu getMenu() {
		return menu;
	}
	public void setMenu(menu menu) {
		this.menu = menu;
	}
	public int getPermision() {
		return permision;
	}
	public void setPermision(int permision) {
		this.permision = permision;
	}
	

}
