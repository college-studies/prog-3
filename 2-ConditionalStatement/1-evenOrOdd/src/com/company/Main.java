package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to get a number from the user and print whether it is positive or negative.

        Scanner in = new Scanner (System.in);
        System.out.print("Input number: ");

        int input = in.nextInt();

        if (input > 0) {
            System.out.println("Number is positive");
        } else if (input < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is zero");
        }
    }
}
