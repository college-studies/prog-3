package com.company;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to get and display information (year, month, day, hour, minute) of a default calendar.

        //Create a default calendar
        Calendar cal = Calendar.getInstance();

        // Get and display information of current date from the calendar;

        System.out.println();
        System.out.println("Year: " + cal.get(Calendar.YEAR));
        System.out.println("Month: " + cal.get(Calendar.MONTH));
        System.out.println("Date: " + cal.get(Calendar.DATE));
        System.out.println("Hour: " + cal.get(Calendar.HOUR));
        System.out.println("Minute: " + cal.get(Calendar.MINUTE));
        System.out.println();
    }
}
