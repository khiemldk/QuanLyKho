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

import Entity.category;
import Entity.menu;
import Entity.product;
import Entity.product_in_stock;
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
//		
//		//ss.save(role1);
//		set.add(role1);
//		set.add(role);
//		user.setRoles(set);
//		ss.save(user);
//		System.out.println(role.getId() + " "+role1.getId());
//		user_role rl = (user_role)ss.createQuery("from user_role where id= "+1).uniqueResult();
//		ss.delete(rl);
		
//		
//		Set<product> set = new HashSet();
//		product pro = new product();
//		pro.setName("San Pham A");
//		pro.setCode("001");
//		pro.setDescription("Day la San pham xin xo");
//		pro.setImg_url("https://image.shutterstock.com/image-photo/dive-into-beauty-natuire-260nw-1458484394.jpg");
//		
//		product pro1 = new product();
//		pro1.setName("San Pham B");
//		pro1.setCode("002");
//		pro1.setDescription("Day la San pham xin xo");
//		pro1.setImg_url("https://image.shutterstock.com/image-photo/dive-into-beauty-natuire-260nw-1458484394.jpg");
//		
//		set.add(pro1);
//		set.add(pro);
//		category cate = new category();
//		cate.setName("A");
//		cate.setCode("AAAA");
//		cate.setDescription("Day La A");
//		cate.setCreate_date(new Date());
//		cate.setProduct(set);
//		ss.save(cate);
		//ss.save(pro1);
		//ss.save(pro);
		//System.out.println(cate.getId()+ "a"+pro1.getId()+ " "+ pro.getId());
		
//		product pro2 = new product();
//		pro2.setName("San Pham A");
//		pro2.setCode("001");
//		pro2.setDescription("Day la San pham xin xo");
//		pro2.setImg_url("https://image.shutterstock.com/image-photo/dive-into-beauty-natuire-260nw-1458484394.jpg");
//
//		category cate2 = new category();
//		cate2.setName("A");
//		cate2.setCode("AAAA");
//		cate2.setDescription("Day La A");
//		cate2.setCreate_date(new Date());
//		
//		pro2.setCategory(cate2);
//		ss.save(pro2);
		
//		roles rl = new roles();
//		rl.setRole_name("test with menu");
//		rl.setActive_flag(true);
//		rl.setDescription("something one");
//		rl.setCreate_date(new Date());
//		
//		Set<menu> setMenu = new HashSet();
//		menu mn1 = new menu();
//		mn1.setName("menu 1");
//		mn1.setOrder_index(1);
//		mn1.setParent_id(11);
//		mn1.setUrl("url.com");
//		mn1.setCreate_date(new Date());
//		
//		menu mn2 = new menu();
//		mn2.setName("menu 1");
//		mn2.setOrder_index(1);
//		mn2.setParent_id(11);
//		mn2.setUrl("url.com");
//		mn2.setCreate_date(new Date());
//		
//		setMenu.add(mn2);
//		setMenu.add(mn1);
//		rl.setMenu(setMenu);
//		ss.save(rl);
//		product_in_stock pis = new product_in_stock();
//		pis.setPrice(1000);
//		pis.setQty(1);
//		product_in_stock pis1 = new product_in_stock();
//		pis1.setPrice(2000);
//		pis1.setQty(2);
//		
//		product prd = new product();
//		prd.setName("XXX");
//		prd.setCode("xxx");
//		prd.setDescription("test product_in_stock");
//		pis.setProduct(prd);
//		pis1.setProduct(prd);
//		
//		ss.save(pis);
//		ss.save(pis1);
		return "home";
	}

}
