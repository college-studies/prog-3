package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program that reads a number in inches, converts it to meters.

        Scanner input = new Scanner (System.in);

        System.out.print("Input a value for inch: ");
        double inch = input.nextDouble();
        double meters = inch * 0.0254;

        System.out.printf("%.2f inch is %.2f meters", inch, meters);
    }
}
