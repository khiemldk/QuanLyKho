package QuanLyKho.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.RoleDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.roles;
import QuanLyKho.Entity.users;

@Service
public class RoleService {
	@Autowired
	RoleDAO<roles> roleDAO;
	public List<roles> getAllRole(){
		return roleDAO.findAll();
	}
	public void insertRole(roles roles) {
		roles.setActive_flag(true);
		roles.setCreate_date(new Date());
		roles.setUpdate_date(new Date());
		roleDAO.save(roles);
	}
	public void update(roles roles) {
		roles.setActive_flag(true);
		roles.setUpdate_date(new Date());
		roleDAO.update(roles);
	}
	public List<roles> getAllRole(Page page){
		return roleDAO.findAllAndPage(page);
	}
	public void delete(roles roles) {
		roles.setUpdate_date(new Date());
		roles.setActive_flag(false);
		roleDAO.delete(roles);
	}
	public roles findById(int id) {
		return roleDAO.findById(roles.class, id);
	}
	public long getNumberRole() {
		return roleDAO.NumberOfRow();
	}
}
