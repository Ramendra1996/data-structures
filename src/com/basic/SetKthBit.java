package com.basic;

import java.util.Scanner;

public class SetKthBit {
    public  static int getSift(int n, int k){
        int mask=1<<k;
        int ans=n|mask;
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int number = getSift(n,k);
        System.out.println(number);
    }
}
