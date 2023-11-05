package com.patterns;

import java.util.Scanner;

public class InvertedFullPyramid {
    public static void main(String[] args) {

        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                System.out.print(" ");
            }
            for (int j=0;j<n-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
