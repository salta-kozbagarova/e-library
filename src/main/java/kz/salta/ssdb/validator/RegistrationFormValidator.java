package kz.salta.ssdb.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kz.salta.ssdb.form.RegistrationForm;
import kz.salta.ssdb.service.UserService;

@Component
public class RegistrationFormValidator implements Validator {
	
	@Resource(name = "userService")
    private UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return RegistrationForm.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		RegistrationForm regForm = (RegistrationForm) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "validation.required");
		if (regForm.getUser().getUsername().length() < 4 || regForm.getUser().getUsername().length() > 32) {
			errors.rejectValue("username", "validation.username.size");
        }
		
		if (userService.findByUsername(regForm.getUser().getUsername()) != null) {
			errors.rejectValue("username", "validation.username.duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "validation.required");
        if (regForm.getUser().getPassword().length() < 4 || regForm.getUser().getPassword().length() > 32) {
            errors.rejectValue("password", "validation.password.size");
        }

        if (!regForm.getUser().getConfirmPassword().equals(regForm.getUser().getPassword())) {
            errors.rejectValue("confirmPassword", "validation.password.different");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "library_card.firstname", "validation.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "library_card.lastname", "validation.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "library_card.course", "validation.required");
        
	}

}
