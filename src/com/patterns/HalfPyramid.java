package com.patterns;

import java.util.Scanner;

public class HalfPyramid {
    public static void main(String[] args) {

        System.out.println("Enter the row");
        Scanner  scanner = new Scanner(System.in);
        int row = scanner.nextInt();



        for(int i=0;i<row;i++){

            for (int j=0;j<i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
