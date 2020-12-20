package QuanLyKho.Controller;

import java.util.List;

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

import QuanLyKho.Entity.category;
import QuanLyKho.Service.ProductService;
import QuanLyKho.Validate.CategoryValidator;

@Controller
public class CategoryController {
	
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
	
	@GetMapping("/category/list")
	public String showList(Model model) {
		List<category> listCate = productService.getAll();
		model.addAttribute("listCate", listCate);
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
	public String saveCate(Model model,@ModelAttribute("categoryForm") @Validated category category, BindingResult result) {
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
		return showList(model);
	}
	
}
