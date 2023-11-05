package com.basic;

import java.util.Scanner;

public class PrintAllPrime1ToN {
    public static boolean getCheck(int n){
        for (int i=2;i<n;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();
         for (int i=2;i<=n;i++){
             boolean isPrime=getCheck(i);
             if (isPrime){
                 System.out.println(i);
             }
         }
    }
}
