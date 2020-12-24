package QuanLyKho.Validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import QuanLyKho.Entity.product_in_stock;
import QuanLyKho.Service.ProductInStockService;
@Component
public class ProductInStockValidator implements Validator{

	
	@Autowired
	ProductInStockService productInStockService;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return product_in_stock.class== clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		product_in_stock product_in_stock = (product_in_stock) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product_id", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qty", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "msg.required");
		
	}

}
