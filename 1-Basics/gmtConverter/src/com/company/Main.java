package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Write a Java program that prints the current time in GMT.

        Scanner input = new Scanner (System.in);

        System.out.print("Input the time zone offset to GMT: ");

        long timeZoneChange = input.nextInt();

        long totalMilliseconds = System.currentTimeMillis();

        long totalSeconds = totalMilliseconds / 1000;

        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;

        long currentMinute = totalMinutes % 60;

        long totalHours = totalMinutes / 60;

        long currentHour = ((totalHours + timeZoneChange) % 24);

        System.out.printf("Current time is %d : %d : %d", currentHour, currentMinute, currentSecond);
    }
}
