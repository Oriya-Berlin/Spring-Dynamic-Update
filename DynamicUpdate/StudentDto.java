package com.implementation.OriyaMadar.DynamicUpdate;

import java.util.Date;

/**
 * @author Oriya Madar berlin
 */
public class StudentDto implements Serializable {

    /**
     * At this class, we can specify which properties (columns)
     * exactly we allow the user to modify.
     */

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;


    // Constructors
    // ....
    // Getters and Setters


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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
