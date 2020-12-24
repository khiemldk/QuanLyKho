package QuanLyKho.Service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.UserDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.users;


@Service
public class UserService {
	final static Logger log4j = Logger.getLogger(UserService.class);
	@Autowired
	private UserDAO<users> userDAO;
	
	
	public List<users> findByProperty(String property, Object value){
		log4j.info("UserService Start Right Now");
		return userDAO.findByProperty(property, value);
	}
	public List<users> getUser(Page page){
		return userDAO.findAllAndPage(page);
	}
	public void update(users user) {
		user.setActive_flag(true);
		user.setUpdate_date(new Date());
		userDAO.update(user);
	}
	public void delete(users user) {
		user.setUpdate_date(new Date());
		user.setActive_flag(false);
		userDAO.delete(user);
	}
	public users findById(int id) {
		return userDAO.findById(users.class, id);
	}
	
}
