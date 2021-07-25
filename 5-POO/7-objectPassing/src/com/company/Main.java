package com.company;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage();

        Car car1 = new Car("BMW");
        Car car2 = new Car("Tesla");


        garage.Park(car1);
        garage.Park(car2);
    }
}
