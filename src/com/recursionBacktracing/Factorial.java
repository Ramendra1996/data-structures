package com.recursionBacktracing;

import java.util.Scanner;

public class Factorial {
    public static int getFactorial(int n){

        if(n==0){
            return 1;
        }
        int ans =n*getFactorial(n-1);

        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner  scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int factorial = getFactorial(n);
        System.out.println("factorial="+factorial);
    }
}
