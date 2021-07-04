package com.company;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to create a Date object using the Calendar class.

        int year = 2016;
        int month = 0; // january
        int date = 1;

        Calendar cal = Calendar.getInstance();
        //Sets the given calendar field value and the time value
        // (millisecond offset from the Epoch) of this calendar undefined

        cal.clear();
        System.out.println();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, date);

        System.out.println(cal.getTime());
        System.out.println();

    }
}
