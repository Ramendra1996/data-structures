package com.basic;

import java.util.Scanner;

public class Counting1ToN {
    public static void getCounting(int n){
        for (int i=1;i<n+1;i++){
            System.out.println("count="+i);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
         getCounting(n);
    }
}
