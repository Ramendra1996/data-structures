package com.recursionBacktracing;

import java.util.Scanner;

public class PrintAllDigit {
    public static void getPrint(int n){
        if(n==0){
            return;
        }
        getPrint(n/10);
        int digit =n%10;
        System.out.print(digit+" ");

    }
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==0){
            System.out.println("0");
        }
         getPrint(n);
    }
}
