package QuanLyKho.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import QuanLyKho.DAO.UserDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.users;
import QuanLyKho.Service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping({"/user/list","/user/list/"})
	public String redirect() {
		return "redirect:/user/list/1";
	}
	
	@GetMapping("/user/list/{page}")
	public String ListUser(Model model, @PathVariable("page") int page) {
		Page pg = new Page(3);
		pg.setCurrentPage(page);
		List<users> list = userService.getUser(pg);
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
		userService.update(user);
		return "user-action";
	}
	@GetMapping("/user/list/add")
	public String add(Model model) {
		users user = new users();
		model.addAttribute("userForm", user);
		userService.update(user);
		return "user-action";
	}
	@PostMapping("/user/list/save")
	public String Post(Model model, @ModelAttribute("userForm") users user) {
		if (user.getId()==0) {
			user.setCreate_date(new Date());
		}	
		userService.update(user);
		return "redirect:/user/list";
	}
}
