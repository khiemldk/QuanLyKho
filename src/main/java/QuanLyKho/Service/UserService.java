package QuanLyKho.Service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.RoleDAO;
import QuanLyKho.DAO.UserDAO;
import QuanLyKho.DAO.UserRoleDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.roles;
import QuanLyKho.Entity.user_role;
import QuanLyKho.Entity.users;
import QuanLyKho.Untils.Encrypt;

@Service
public class UserService {
	final static Logger log4j = Logger.getLogger(UserService.class);
	@Autowired
	private UserDAO<users> userDAO;
	@Autowired
	private RoleDAO<roles> roleDAO;
	@Autowired
	private UserRoleDAO<user_role> userRoleDAO;

	public List<users> findByProperty(String property, Object value) {
		log4j.info("UserService Start Right Now");
		return userDAO.findByProperty(property, value, null);
	}

	public List<users> getUser(Page page) {
		return userDAO.findAllAndPage(page);
	}

	public void update(users user) {
		user.setPassword(Encrypt.encrypt(user.getPassword()));
		user.setActive_flag(true);
		user.setUpdate_date(new Date());
		userDAO.update(user);

	}

	public void insert(users user) {
		user.setActive_flag(true);
		user.setUpdate_date(new Date());
		user.setPassword(Encrypt.encrypt(user.getPassword()));
		userDAO.save(user);
		user_role user_role = new user_role();
		user_role.setUsers(user);
		roles roles = roleDAO.findById(roles.class, user.getRoleId());
		user_role.setRoles(roles);
		user_role.setActive_flag(true);
		user.setCreate_date(new Date());
		userRoleDAO.save(user_role);

	}

	public void delete(users user) {
		user.setUpdate_date(new Date());
		user.setActive_flag(false);
		userDAO.delete(user);
	}

	public users findById(int id) {
		return userDAO.findById(users.class, id);
	}
	
	// role
	
}
