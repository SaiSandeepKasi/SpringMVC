package com.springMVC.Vaildation.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCourseCode) {
       coursePrefix= theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result= theCode.startsWith(coursePrefix);
        return false;
    }
}
