package com.patterns;

import java.util.Scanner;

public class HollowInvertedHalfPyramid {
    public static void main(String[] args) {

        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();

        for (int i =0;i<n;i++){
            for (int j =0;j<n;j++){
                if(i==0||j==0||j==n-1-i){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
