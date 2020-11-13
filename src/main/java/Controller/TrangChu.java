package Controller;





import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.roles;
import Entity.user_role;
import Entity.users;



@Controller
@RequestMapping("/")
public class TrangChu {


	@Autowired
	SessionFactory sessionFactory;
	
	
	@GetMapping
	@Transactional
	public String trangchu() {
		Session ss = sessionFactory.getCurrentSession();
//		users users = (users)ss.createQuery("from users where id= "+1).uniqueResult();
//		ss.delete(users);
//		users user = new users();
//		user.setName("nhan le thi");
//		user.setEmail("nhanlt28@gmail.com");
//		user.setActive_flag(true);
//		user.setPassword("3");
//		user.setUsername("binh");
//		user.setCreate_date(new Date());
//		
//		Set<roles> set = new HashSet();
//
//		roles role = new roles();
//		role.setRole_name("Anywhere");
//		role.setDescription("Loveed");
//		role.setActive_flag(true);
//		role.setCreate_date(new Date());
//		//ss.save(role);
//		
//		roles role1 = new roles();
//		role1.setRole_name("Nobody");
//		role1.setDescription("Nothing");
//		role1.setActive_flag(true);
//		role1.setCreate_date(new Date());
//		//ss.save(role1);
//		set.add(role1);
//		set.add(role);
//		user.setRoles(set);
//		ss.save(user);
		user_role rl = (user_role)ss.createQuery("from user_role where id= "+1).uniqueResult();
		ss.delete(rl);
		return "trangchu";
	}

}
