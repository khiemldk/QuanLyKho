package QuanLyKho.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import QuanLyKho.Entity.auth;
import QuanLyKho.Entity.menu;
import QuanLyKho.Entity.roles;
import QuanLyKho.Entity.user_role;
import QuanLyKho.Entity.users;
import QuanLyKho.Service.UserService;
import QuanLyKho.Untils.Constant;
import QuanLyKho.Validate.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private LoginValidator loginValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		if (binder.getTarget() == null) return;
		if (binder.getTarget().getClass() == users.class) {
			binder.setValidator(loginValidator);
		}
	}
	
	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("loginForm",new users());
		return "login/login";
	}
	@PostMapping("/processLogin")
	public String processLogin(Model model, @ModelAttribute("loginForm")@Validated users users,BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			return "login/login";
		}
		users user = userService.findByProperty("username", users.getUsername()).get(0);
		user_role userRole = (user_role) user.getUser_roles().iterator().next();
		roles role = userRole.getRoles();
		List<menu> listMenu = new ArrayList<>();
		List<menu> childMenuList = new ArrayList<>();
		
		for (Object object : role.getAuths()) {
			auth auth = (auth) object;
			menu menu = auth.getMenu();
			if (menu.getParent_id()==0 && menu.getActive_flag() && auth.getActive_flag() && auth.getPermision()==1 && menu.getOrder_index()!=-1) {
				menu.setIdMenu(menu.getUrl().replace("/","")+"Id");
				listMenu.add(menu);
			} else if (menu.getParent_id()!=0 && menu.getActive_flag() && auth.getActive_flag() && auth.getPermision()==1 && menu.getOrder_index()!=-1) {
				menu.setIdMenu(menu.getUrl().replace("/","")+"Id");
				childMenuList.add(menu);
			}
		}
		for (menu menu : listMenu) {
			List<menu> childList = new ArrayList<>();
			for (menu childMenu : childMenuList) {
				if(childMenu.getParent_id() == menu.getId()) {
					childList.add(childMenu);
				}
			}
			menu.setChild(childList);
		
		}
		
		
		sortMenu(listMenu);
		for(menu menu : listMenu) {
			sortMenu(menu.getChild());
		}
		session.setAttribute(Constant.User_Infor,user );
		session.setAttribute(Constant.Menu, listMenu);
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constant.User_Infor);
		session.removeAttribute(Constant.Menu);
		return "redirect:/login";
	}
	
	@GetMapping("/error-denied")
	public String error() {
		return "error-page/page_403";
	}
	
	private void sortMenu(List<menu> menus) {
		Collections.sort(menus, new Comparator<menu>() {

			@Override
			public int compare(menu arg0, menu arg1) {
				return arg0.getOrder_index() - arg1.getOrder_index();
			}
			
		});;
	}
}
