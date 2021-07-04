package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Take three numbers from the user and print the greatest number.

        Scanner in = new Scanner(System.in);

        System.out.print("Input the 1st number: ");
        int num1 = in.nextInt();

        System.out.print("Input the 2st number: ");
        int num2 = in.nextInt();

        System.out.print("Input the 3st number: ");
        int num3 = in.nextInt();

        if (num1 > num2)
            if (num1 > num3)
                System.out.printf("The greatest is: %d", num1);

        if (num2 > num1)
            if (num2 > num3)
                System.out.printf("The greatest is: %d", num2);

        if (num3 > num1)
            if (num3 > num2)
                System.out.printf("The greatest is: %d", num3);
    }
}
