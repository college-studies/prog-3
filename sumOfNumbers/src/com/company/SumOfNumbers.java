package com.company;

import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
//	    System.out.println(24+26);

        Scanner input = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int f_number = input.nextInt();
        System.out.print("Input the second number: ");
        int s_number = input.nextInt();

        int sum = f_number + s_number;

        System.out.println();
        System.out.println("Sum = " + sum);
    }
}
