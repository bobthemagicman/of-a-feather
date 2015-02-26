/**
 *
 *  Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.ui.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ofafeather.ui.model.validation.annotation.PasswordNotEqualToOldPassword;

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