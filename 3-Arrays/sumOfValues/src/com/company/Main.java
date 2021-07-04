package com.company;

public class Main {

    public static void main(String[] args) {
        //Write a Java program to sum values of an array.
        int[] my_array = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;

        for (int i: my_array) {
            sum += i;
        }
        System.out.printf("The sum is %d", sum);

    }
}
