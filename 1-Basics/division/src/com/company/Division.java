package com.company;

import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
//	    System.out.print(50/3);

        Scanner input = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int a = input.nextInt();
        System.out.print("Input the second number: ");
        int b = input.nextInt();

        int c = (a/b);

        System.out.println();
        System.out.print("Division of a and b is: " + c);

    }
}
