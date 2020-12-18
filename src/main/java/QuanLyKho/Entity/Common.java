package QuanLyKho.Entity;

import java.util.Date;

public class Common {
	public Boolean active_flag;
	public Date create_date;
	public Date update_date;
	
	public Common() {
		
	}
	public Common(Boolean active_flag, Date create_date, Date update_date) {
		
		this.active_flag = active_flag;
		this.create_date = create_date;
		this.update_date = update_date;
	}
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
