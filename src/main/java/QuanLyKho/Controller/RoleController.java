package QuanLyKho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import QuanLyKho.DAO.RoleDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.category;
import QuanLyKho.Entity.history;
import QuanLyKho.Entity.roles;
import QuanLyKho.Entity.users;
import QuanLyKho.Service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@GetMapping({"/role/list","/role/list/"})
	public String Redirect() {
		return "redirect:/role/list/1";
	}
	@GetMapping("/role/list/{index}")
	public String getRole(Model model,@PathVariable("index") int index) {
		if (index == 0)
			index =1;
		Page page2 = new Page(3);
		page2.setCurrentPage(index);
		
		List<roles> roles = roleService.getAllRole(page2);
		if (index>=page2.getTotalPages())
			index=page2.getTotalPages()-1;
		model.addAttribute("crpage", index);
		
		model.addAttribute("listRole",roles);
		return "role-list";
	}
	@GetMapping("/role/list/add")
	public String Add(Model model) {
		model.addAttribute("roleForm",new roles());
		return "role-action";
	}
	@GetMapping("/role/list/edit/{id}")
	public String edit(Model model,@PathVariable("id") int id) {
		roles role = roleService.findById(id);
		model.addAttribute("roleForm", role);
		return "role-action";
	}
	@GetMapping("/role/list/delete/{id}")
	public String delete(Model model,@PathVariable("id") int id) {
		roles role = roleService.findById(id);
		roleService.delete(role);
		return "user-list";
	}
	@PostMapping("/role/list/save")
	public String Post(Model model, @ModelAttribute("roleForm") roles role) {
		if (role.getId()==0) {
			roleService.insertRole(role);
		}	
		else
			roleService.update(role);
		return "redirect:/role/list";
	}
}
