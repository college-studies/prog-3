package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to convert minutes into a number of years and days.

        double minutesInYear = 60 * 24 * 365;

        Scanner input = new Scanner (System.in);

        System.out.print("Input the number of minutes: ");

        double min = input.nextDouble();

        long years = (long) (min / minutesInYear);

        int days = (int) (min / 60 / 24) % 365;

        System.out.printf("%.2f minutes is approximately %d years and %d days", min, years, days);

    }
}
