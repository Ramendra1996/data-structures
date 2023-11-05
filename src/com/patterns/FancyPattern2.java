package com.patterns;

import java.util.Scanner;

public class FancyPattern2 {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();

         for (int i=0;i<n;i++){
             for (int j=0;j<i+1;j++){
                 System.out.print(i+1);
                 if (j!=i){
                     System.out.print("*");
                 }
             }
             System.out.println();
         }

         for (int i=0;i<n;i++){
             for (int j=0;j<n-i;j++){
                 System.out.print(n-i);
                 if (j!=n-1-i){
                     System.out.print("*");
                 }
             }
             System.out.println();
         }
    }
}
