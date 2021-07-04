package com.company;
import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
//        System.out.println("Hello\nFillipe Augusto");

        // Using input from user
        Scanner input = new Scanner (System.in);
        System.out.print("Input your first name: ");
        String fname = input.next();
        System.out.print("Input your last name: ");
        String lname = input.next();
        System.out.println();
        System.out.println("Hello " + fname + " " + lname);
    }
}
