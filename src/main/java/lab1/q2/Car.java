package lab1.q2; // Place the Car class in the appropriate package

/**
 Author : Andrei Dayrit
 Date : 09/30/2023
 Description : this class represents a Car object with attributes make, model, year, owner, and VIN
                and methods to get and set those attributes.
 **/

import lab1.q1.Person;

import java.util.Objects;

public class Car {

    private String make;
    private String model;
    private int year;
    private Person owner;
    private int VIN;
    private static int COUNT = 0;

    // Constructors for Car class
    public Car(String make, String model, int i, int year, Person owner) {
        this(make, model, year, null);
    }

    public Car(String make, String model, int year, Person owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.VIN = ++COUNT;
    }



    public Car(String make, String model, int year, int vin) {
    }

    // Getters and Setters for attributes
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }





    // toString Method for printing Car objects directly
    @Override
    public String toString() {
        return "Car {" +
                "Make: '" + make + '\'' +
                ", Model: '" + model + '\'' +
                ", Year: " + year +
                ", Owner: " + owner +
                ", VIN: " + VIN +
                '}';
    }



    // Equals and HashCode Methods for comparing Car objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year &&
                VIN == car.VIN &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model) &&
                Objects.equals(owner, car.owner);
    }




    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, owner, VIN);
    }

    // Static method to get COUNT variable
    public static int getCount() {
        return COUNT;
    }
}
