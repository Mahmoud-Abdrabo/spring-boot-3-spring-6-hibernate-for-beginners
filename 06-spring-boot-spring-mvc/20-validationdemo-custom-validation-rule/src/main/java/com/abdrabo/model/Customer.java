package com.abdrabo.model;

import com.abdrabo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    // make the last name required
    @NotNull(message = "is required!")
    @Size(min=3, message = "is required!")
    private String lastName;

    // make free passes between 0 and 10
    @NotNull(message = "is required!")
    @Min(value = 0, message = "must be greater than or equal to zero!")
    @Max(value = 10, message = "must be less than or equal to 10!")
    private Integer freePasses;

    // Make postal code consists of only 5 chars/digits
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits!")
    private String postalCode;

    // Make course code must start with CSEN
    @CourseCode(value = "CSEN", message = "must start with CSEN")
    private String courseCode;

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
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
