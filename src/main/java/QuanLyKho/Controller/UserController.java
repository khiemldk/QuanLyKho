package QuanLyKho.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QuanLyKho.DAO.UserDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.product;
import QuanLyKho.Entity.roles;
import QuanLyKho.Entity.users;
import QuanLyKho.Service.RoleService;
import QuanLyKho.Service.UserService;
import QuanLyKho.Untils.Constant;
import QuanLyKho.Untils.Encrypt;

@Controller
public class UserController {
	public final static Logger log4j = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	public boolean checkInUp=false;
	@GetMapping({"/user/list","/user/list/"})
	public String redirect() {
		return "redirect:/user/list/1";
	}
	
	@GetMapping("/user/list/{page}")
	public String ListUser(Model model, @PathVariable("page") int page) {
		if (page==  0)
			page = 1;
		Page pg = new Page(3);
		pg.setCurrentPage(page);
		
		List<users> list = userService.getUser(pg);
		if (page>=pg.getTotalPages())
			page=pg.getTotalPages()-1;
		model.addAttribute("crpage", page);
		model.addAttribute("listUser", list);
		model.addAttribute("pageInfo", pg);
		return "user-list";
	}
	@GetMapping("/user/list/delete/{id}")
	public String delete(Model model,@PathVariable("id") int id) {
		users user = userService.findById(id);
		userService.delete(user);
		return "user-list";
	}
	@GetMapping("/user/list/edit/{id}")
	public String update(Model model, @PathVariable("id") int id) {
		users user = userService.findById(id);
		model.addAttribute("userForm", user);
		model.addAttribute("idRole", getIdRole());
		checkInUp=true;
		model.addAttribute("checkInUp", checkInUp);
		userService.update(user);
		return "user-action";
	}
	@GetMapping("/user/list/add")
	public String add(Model model) {
		users user = new users();
		model.addAttribute("userForm", user);
		model.addAttribute("idRole", getIdRole());
		checkInUp=false;
		model.addAttribute("checkInUp", checkInUp);
//		userService.update(user);
		return "user-action";
	}
	@PostMapping("/user/list/save")
	public String Post(Model model, @ModelAttribute("userForm") users user) {
		if (user.getId()==0) {
			userService.insert(user);
		}	
		else
		userService.update(user);
		return "redirect:/user/list";
	}
	@GetMapping("/user/list/changePass/{id}")
	public String changePass(Model model, @PathVariable("id") int id) {
		users user = userService.findById(id);

		model.addAttribute("changePasswordForm", user);
		return "changePassword";
	}
	@PostMapping("/user/list/savePass")
	public String Post1(Model model,@ModelAttribute("changePasswordForm") users user,@RequestParam("oldPass") String old,@RequestParam("newPassword") String newP,
			@RequestParam("newPasswordAgain") String againNewP) {
		
		if (Encrypt.encrypt(user.getPassword()).equals(old.toString())) {
			if (newP.equals(againNewP)) {
				user.setPassword(Encrypt.encrypt(newP));
				userService.update(user);
				model.addAttribute("Notification", "Change Password Successfully");
			} else {
				model.addAttribute("Notification", "New Password is Wrong");
			}
		} else {
			model.addAttribute("Notification", "Wrong password");
		}
		return "changePassword";
	}
	public Map<String, String> getIdRole(){
		List<roles> roles = roleService.getAllRole();
		Map<String, String> map = new HashMap<>();
		for(roles rl : roles) {
			map.put(String.valueOf(rl.getId()), rl.getRole_name());
		}
		return map;
	}
}
