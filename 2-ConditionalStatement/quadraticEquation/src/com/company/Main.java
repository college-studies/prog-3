package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to solve quadratic equations (use if, else if and else).

        Scanner input = new Scanner (System.in);

        System.out.print("Input a: ");
        double a = input.nextDouble();

        System.out.print("Input b: ");
        double b = input.nextDouble();

        System.out.print("Input c: ");
        double c = input.nextDouble();

        double result = b * b - 4.0 * a * c;

        if (result > 0.0) {
            double r1 = (-b + Math.pow(result, 0.5)) / (2.0 *a);
            double r2 = (-b - Math.pow(result, 0.5)) / (2.0 *a);

            System.out.printf("The roots are %f and %f", r1, r2);
        } else if (result == 0.0) {
            double r1 = -b / (2.0 * a);
            System.out.printf("The root is %f", r1);
        }else {
            System.out.println("The equation has no real roots.");
        }
    }
}
