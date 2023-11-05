package com.patterns;

import java.util.Scanner;

public class NumericHollowPyramid {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        for (int i=0;i<n;i++){
            //space
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            //numbers with space between
            int start=1;
             for (int j=0;j<2*i+1;j++){
                 //first and last
                 if(i==0 ||i==n-1){
                  if(j%2==0){
                      System.out.print(start);
                      start++;
                  }else {
                      System.out.print(" ");
                  }

                 }else {
                   //first col
                     if(j==0){
                         System.out.print(1);
                     } else if (j==2*i+1-1) {
                         System.out.print(i+1);
                     }else {
                         System.out.print(" ");
                     }
                 }
             }
            System.out.println();
        }
    }
}
