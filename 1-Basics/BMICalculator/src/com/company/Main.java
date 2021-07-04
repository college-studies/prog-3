package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to compute body mass index (BMI).

        Scanner input = new Scanner (System.in);

        System.out.print("Input weight in pounds: ");

        double weight = input.nextDouble();

        System.out.print("Input height in inches: ");

        double inches = input.nextDouble();

        double BMI = weight * 0.45359237 / (inches * 0.0254 * inches * 0.0254);

        System.out.printf("Body Mass Index is: %f", BMI);
    }
}
