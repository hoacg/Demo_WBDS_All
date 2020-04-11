package com.codegym.validators;

import com.codegym.models.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FacebookUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student facebookUser = (Student) target;

        ValidationUtils.rejectIfEmpty(errors, "facebook", "facebook.empty");

        if (!facebookUser.getFacebook().startsWith("https://facebook.com/")) {
            ValidationUtils.rejectIfEmpty(errors, "facebook", "facebook.invalidformat");
        }
    }
}
