package com.basic;

import java.util.Scanner;

public class EvenNumberSum {

    public static int getEvenSum(int n) {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int evenSum = getEvenSum(n);
        System.out.println("evenSum=" + evenSum);
    }
}
