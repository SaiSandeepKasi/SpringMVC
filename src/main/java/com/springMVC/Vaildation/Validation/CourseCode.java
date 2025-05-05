package com.springMVC.Vaildation.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
//defined default value
    public String value() default "SUV";
//defined default message
    public String message() default "Must start with SUV";
// define default groups
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
