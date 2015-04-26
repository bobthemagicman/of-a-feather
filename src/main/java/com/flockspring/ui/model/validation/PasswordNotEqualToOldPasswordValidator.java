package com.flockspring.ui.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.flockspring.ui.model.validation.annotation.PasswordNotEqualToOldPassword;

public class PasswordNotEqualToOldPasswordValidator implements ConstraintValidator<PasswordNotEqualToOldPassword, Object>
{

    private String passwordFieldName;
    private String originalPasswordFieldName;

    @Override
    public void initialize(PasswordNotEqualToOldPassword constraintAnnotation) {
        passwordFieldName = constraintAnnotation.passwordFieldName();
        originalPasswordFieldName = constraintAnnotation.originalPasswordFieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        try {
                return passwordFieldsAreValid(value, context);
        }
        catch (Exception ex) {
            throw new RuntimeException("Exception occurred during validation", ex);
        }
    }

    private boolean passwordFieldsAreValid(Object value, ConstraintValidatorContext context) throws NoSuchFieldException, IllegalAccessException {
        boolean passwordWordFieldsAreValid = true;

        String password = (String) ValidatorUtil.getFieldValue(value, passwordFieldName);
        if (isNullOrEmpty(password)) {
            ValidatorUtil.addValidationError(passwordFieldName, context);
            passwordWordFieldsAreValid = false;
        }

        String oldPassword = (String) ValidatorUtil.getFieldValue(value, originalPasswordFieldName);
        if (isNullOrEmpty(oldPassword)) {
            ValidatorUtil.addValidationError(originalPasswordFieldName, context);
            passwordWordFieldsAreValid = false;
        }

        passwordWordFieldsAreValid = !originalPasswordFieldName.trim().equals(passwordFieldName.trim());
        
        return passwordWordFieldsAreValid;
    }

    private boolean isNullOrEmpty(String field) {
        return field == null || field.trim().isEmpty();
    }
}