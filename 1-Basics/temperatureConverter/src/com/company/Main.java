package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to convert temperature from Fahrenheit to Celsius degree.

        Scanner input  = new Scanner (System.in);

        System.out.println("Input a Degree in Fahrenheit: ");

        double fahrenheit = input.nextDouble();

        double celsius = ((5 * (fahrenheit) - 32.0) / 9.0 );

        //System.out.println(fahrenheit + " degree Fahrenheit is equal to " + celsius + "in Celsius");
        System.out.printf("%.2f degree Fahrenheit is equal to %.2f in Celsius",fahrenheit, celsius);
    }
}
