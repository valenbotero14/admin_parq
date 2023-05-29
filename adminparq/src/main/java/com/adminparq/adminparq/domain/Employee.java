/**
 * Domain - refers to the scope or business that is being modeled in software, and the use of a common language
 * throughout the development team helps create more accurate and useful software models.
 */

package com.adminparq.adminparq.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * Getter - which returns the value of a class field
 * Setter - sets the value of a class field
 */
@Getter
@Setter

/*
automatically generates a constructor with all the fields of the class as arguments.
 */
@AllArgsConstructor

/*
 * automatically generates a no-argument constructor on a class.
 */
@NoArgsConstructor

public class Employee {

    private Long id;

    private String name;

    private String user;

    private String password;

}
