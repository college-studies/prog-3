package com.company;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to calculate the average value of array elements.

        int[] numbers = new int[] {20,30,25,35,-16,60,-100};

        //calcule sum of all array elements
        int sum = 0;

        for (int number : numbers) sum += number;
            double average = sum / numbers.length;
            System.out.printf("Average value of the array element is : %.2f", average);

    }
}
