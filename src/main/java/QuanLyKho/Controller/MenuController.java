package QuanLyKho.Controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math3.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.auth;
import QuanLyKho.Entity.menu;
import QuanLyKho.Entity.roles;
import QuanLyKho.Entity.users;
import QuanLyKho.Service.AuthService;
import QuanLyKho.Service.MenuService;
import QuanLyKho.Service.RoleService;

@Controller
public class MenuController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private AuthService authService;
	
	@GetMapping("/menu/list/add")
	public String add(Model model) {
		
		auth auth = new auth();
		model.addAttribute("menuForm", auth);
		List<menu> listMenu = menuService.getMenu(null);
		List<roles> listRole = roleService.getAllRole();
		Map<Integer, String> mapMenu = new HashMap<>();
		Map<Integer, String> mapRole = new HashMap<>();
		for (roles roles : listRole) {
			mapRole.put(roles.getId(), roles.getRole_name());
		}
		for (menu mn : listMenu) {
			mapMenu.put(mn.getId(), mn.getUrl());
		}
		model.addAttribute("idRole", mapRole);
		model.addAttribute("idMenu", mapMenu);
		return "menu-action";
	}
	@PostMapping("/menu/list/save")
	public String solve(Model model,@ModelAttribute("menuForm") auth auth) {
		Map<String, Object> map = new HashMap();
		map.put("role_id", auth.getRoles().getId());
		map.put("menu_id", auth.getMenu().getId());
		List<auth> list1 = authService.Search(map);
		if (list1!=null && !list1.isEmpty())
			auth.setId(authService.Search(map).iterator().next().getId());
		
		authService.update(auth);
		return "redirect:/menu/list";
	}
	
	@GetMapping({"/menu/list/","/menu/list"})
	public String redirect() {
		return "redirect:/menu/list/1";
	}
	@GetMapping("/menu/list/{index}")
	public String lala(Model model,@PathVariable("index") int index) {
		if (index ==  0)
			index = 1;
		Page pg = new Page(3);
		pg.setCurrentPage(index);
		long numberOfRole = roleService.getNumberRole();
		List<roles> roles = roleService.getAllRole();
		List<menu> menus = menuService.getMenu(pg);
		if (index>=pg.getTotalPages())
			index=pg.getTotalPages()-1;
		Collections.sort(roles, (o1, o2) -> o1.getId() - o2.getId());
		for (menu item : menus) {
			Map<Integer, Integer> mapAuth = new TreeMap<>();
			for (roles role : roles) {
				mapAuth.put(role.getId(), 0);// 1-0 ,2-0,3-0
			}
			for (Object obj : item.getAuths()) {
				auth auth = (auth) obj;
				mapAuth.put(auth.getRoles().getId(), auth.getPermision());
			}
			item.setMapAuth(mapAuth);
			
		}
		
		model.addAttribute("crpage", index);
		model.addAttribute("listMenu", menus);
		model.addAttribute("pageInfo", pg);
		model.addAttribute("countRole", numberOfRole);
		model.addAttribute("listRole", roles);
		return "menu";
	}
}
