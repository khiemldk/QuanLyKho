package QuanLyKho.Validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import QuanLyKho.Entity.users;
import QuanLyKho.Service.UserService;
import QuanLyKho.Untils.Encrypt;

@Component
public class LoginValidator implements Validator{

	@Autowired
	private UserService userService;
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return users.class == clazz;
	}

	public void validate(Object target, Errors errors) {
		users users = (users) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "msg.required");
//		System.out.println("ALO1----------------------------------------------------");
		if (!StringUtils.isEmpty(users.getUsername()) && !StringUtils.isEmpty(users.getPassword())) {
//			System.out.println("ALO3----------------------------------------------------");
			List<users> listUser = userService.findByProperty("username", users.getUsername());
			System.out.println(users.getUsername());
			System.out.println("ALO2----------------------------------------------------");
			if (users != null && !listUser.isEmpty()) {
				System.out.println("ALO4----------------------------------------------------");
				if (! listUser.get(0).getPassword().equals(Encrypt.encrypt(users.getPassword())) ) {
					errors.rejectValue("password", "msg.wrong.password");
				}
			} else {
				errors.rejectValue("username", "msg.wrong.username");
			}
		}
	}
	
}
