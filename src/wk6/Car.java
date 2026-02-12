package wk6;

public class Car {
    String make, model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return "The " + make + " " + model + " was released in " + year;
    }

}
