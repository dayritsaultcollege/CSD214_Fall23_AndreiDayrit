package lab1.q2;

/**
 Author : Andrei Dayrit
 Date : 09/30/2023
 Description : this program test both the Person and Car classes
                by creating 3 Person objects and 3 Car objects and prints them out.
 **/

import lab1.q1.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void testPersonEquals() {
        // Test cases for the Person class here and in the following
        Person p1 = new Person("First", "Last", Person.Gender.MALE, 1234);
        Person p2 = new Person("First", "Last", Person.Gender.MALE, 1234);
        Person p3 = new Person("First", "Last", Person.Gender.MALE, 12345);

        assertEquals(p1, p2); // p1 equals p2
        assertEquals(p1, p1); // p4 equals p1
        assertNotEquals(p1, p3); // p1 does not equal p3
    }

    @Test
    public void testCarEquals() {
        // Test cases for the Car class here and in the following
        Person owner = new Person("Owner", "Last", Person.Gender.MALE, 1234);

        Car c1 = new Car("Chevrolet", "Camaro", 2012, 1234, owner);
        Car c2 = new Car("Chevrolet", "Camaro", 2012, 1234, owner);
        Car c3 = new Car("Chevrolet", "Camaro", 2012, 12345, owner);

        assertEquals(c1, c2); // c1 equals c2
        assertEquals(c1, c1); // c4 equals c1
        assertNotEquals(c1, c3); // c1 does not equal c3
    }
}

