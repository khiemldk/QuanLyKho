package QuanLyKho.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.category;
import QuanLyKho.Service.ProductService;
import QuanLyKho.Validate.CategoryValidator;

@Controller
public class CategoryController {
	public final static Logger log4j = Logger.getLogger(CategoryController.class);
	@Autowired
	ProductService productService;
	@Autowired
	CategoryValidator categoryValidator;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		if (binder.getTarget() == null) return;
		if (binder.getTarget().getClass() == category.class) {
			binder.setValidator(categoryValidator);
		}
	}
	@GetMapping(value= {"/category/list","/category/list/"})
	public String redirect() {
		return "redirect:/category/list/1";
	}
//	@GetMapping("/category/list")
//	public String showList(Model model) {
////		Page page = new Page(3);
////		page.setCurrentPage();
//		List<category> listCate = productService.getAll();
//		model.addAttribute("listCate", listCate);
////		model.addAttribute("pageInfo", page);
//		return "category-list";
//	}
	@GetMapping("/category/list/{currentPage}")
	public String showList(Model model,@PathVariable("currentPage") int currentPage) {
		
		Page page = new Page(3);
		page.setCurrentPage(currentPage);
		List<category> listCate = productService.getAllPae(page);
		log4j.info("Page : " +page.getTotalPages());
		model.addAttribute("listCate", listCate);
		model.addAttribute("pageInfo", page);
		return "category-list";
	}
	@GetMapping("/category/add")
	public String saveCate(Model model) {
		model.addAttribute("titlePage", "Add Category");
		model.addAttribute("viewOnly", false);
		model.addAttribute("categoryForm",new category());
		return "category-action";
	}
	@GetMapping("/category/edit/{id}")
	public String editCate(Model model,@PathVariable int id) {
		category category = productService.findByIdCategory(id);
		if (category!=null) {
			model.addAttribute("categoryForm", category);
			model.addAttribute("titlePage", "Edit Category");
			model.addAttribute("viewOnly", false);
			return "category-action";
		}
		return "redirect:/category/list";
	}
	@GetMapping("/category/view/{id}")
	public String viewCate(Model model,@PathVariable int id) {
		category category = productService.findByIdCategory(id);
		if (category!=null) {
			model.addAttribute("categoryForm", category);
			model.addAttribute("titlePage", "Edit Category");
			model.addAttribute("viewOnly", true);
			return "category-action";
		}
		return "redirect:/category/list";
	}
	
	@GetMapping("/category/delete/{id}")
	public String delete(Model model , @PathVariable("id") int id) {
		category category = productService.findByIdCategory(id);
		if(category!=null) {
			productService.deleteCategory(category);
		}
		return "redirect:/category/list";
	}
	
	@PostMapping("/category/save")
	public String saveCate(Model model,@ModelAttribute("categoryForm") @Validated category category, BindingResult result ) {
		if (result.hasErrors()) {
			return "category-action";
		}
		if(category.getId()!=0) {
			productService.updateCategory(category);
			model.addAttribute("message", "Update success!!!");
		}else {
			productService.insertCategory(category);
			model.addAttribute("message", "Insert success");
		}
		int currentPage=0;
		return "redirect:/category/list";
	}
	
}
