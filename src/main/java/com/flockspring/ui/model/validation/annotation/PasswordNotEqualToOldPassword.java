package com.flockspring.ui.model.validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.flockspring.ui.model.validation.PasswordNotEqualToOldPasswordValidator;

/**
 * PasswordNotEqualToOldPassword.java
 *
 * @author Justen L. Britain
 * @date Apr 5, 2014
 *
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordNotEqualToOldPasswordValidator.class)
@Documented
public @interface PasswordNotEqualToOldPassword
{

	String message() default "PasswordNotEqualToOldPassword";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String triggerFieldName() default "";

	String passwordFieldName() default "";

	String originalPasswordFieldName() default "";
}
