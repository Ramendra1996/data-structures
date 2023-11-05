package com.basic;

import java.util.Scanner;

public class AddTwoNumber {
    public static int getSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Enter the a value");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Enter the b value");
        int b = scanner.nextInt();
        int sum = getSum(a, b);
        System.out.println("sum=" + sum);
    }
}
