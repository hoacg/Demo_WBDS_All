package com.codegym.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FacebookUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String facebookUser = (String) target;

        ValidationUtils.rejectIfEmpty(errors, "facebook", "facebook.empty");

        if (!facebookUser.startsWith("https://facebook.com/")) {
            ValidationUtils.rejectIfEmpty(errors, "facebook", "facebook.invalidformat");
        }
    }
}
