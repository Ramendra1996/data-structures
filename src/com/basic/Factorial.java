package com.basic;

import java.util.Scanner;

public class Factorial {
    public static  int getFactorial(int n){
        int fact =1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = getFactorial(n);
        System.out.println("fact="+result);
    }
}
