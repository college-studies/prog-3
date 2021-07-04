package com.company;

public class Main {

    public static void main(String[] args) {
	// Write a Java program to print the following grid.
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0
    //        0  0  0  0  0  0  0  0  0  0

        int [][]a = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                System.out.printf("%2d", a[i][j]);
            }
            System.out.println();
        }
    }
}
