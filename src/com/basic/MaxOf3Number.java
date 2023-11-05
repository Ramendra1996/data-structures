package com.basic;

import java.util.Scanner;

public class MaxOf3Number {

    public static int getMax(int a, int b, int c) {
        if (a > b && b > c) {
            return a;
        } else if (b > c && b > a) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the first number:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Enter the second number:");
        int b = scanner.nextInt();
        System.out.println("Enter the tried number");
        int c = scanner.nextInt();
        int max = getMax(a, b, c);
        System.out.println("Max Number is=" + max);
    }
}
