package com.abdrabo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {


    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    /** code : HTML form data entered by the user
     *  constraintValidatorContext : we can use it to give additional error messages
     *  This method is the business logic for your annotation
     * */
    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;

        if(code!=null){
            result = code.startsWith(coursePrefix);
        }

        return result;
    }
}
