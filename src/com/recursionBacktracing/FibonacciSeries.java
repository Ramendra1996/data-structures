package com.recursionBacktracing;

import java.util.Scanner;

public class FibonacciSeries {
    public static int getFib(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return  getFib(n-1)+getFib(n-2);
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int fib = getFib(n);

        System.out.println(fib);
    }
}

//TC->0(2^n)