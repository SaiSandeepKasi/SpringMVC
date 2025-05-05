package com.springMVC.Vaildation;

import com.springMVC.Vaildation.Validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message="is Required")
    @Size(min = 1, message = "Is required")
    private String lastName;
    @Min(value=0,message = "Must be GreaterThan Zero or equal to Zero")
    @Max(value = 10,message = "Must be lessthan or equal to 10")
    private Integer freePasses;
    @Pattern(regexp = "^[a-z,A-Z0-9]{6}",message ="Only 6 digits " )
    private String postalCode;
    @CourseCode
    private String CourseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }
}
