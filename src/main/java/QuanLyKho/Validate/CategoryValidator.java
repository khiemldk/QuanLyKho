package QuanLyKho.Validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import QuanLyKho.Entity.category;
import QuanLyKho.Service.ProductService;

@Component
public class CategoryValidator implements Validator{
	
	@Autowired
	ProductService productService;
		
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == category.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		category category = (category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "msg.required");
		if(category.getCode()!=null) {
			List<category> results=  productService.findCategory("code", category.getCode());
			if(results!=null && !results.isEmpty() ) {
			if(category.getId()!=0 ) {
				if( results.get(0).getId()!= category.getId()) {
					errors.rejectValue("code", "msg.category.code");
				}
			}else {
				errors.rejectValue("code", "msg.category.code");
			}
			
				
			}
		}
		
	}
	
}
