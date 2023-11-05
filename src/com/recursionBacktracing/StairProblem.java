package com.recursionBacktracing;

import java.util.Scanner;

public class StairProblem {
    public static int getStair(int n){
        if(n==0|| n==1){
            return  1;
        }
        return getStair(n-1)+getStair(n-2);
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner  scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int stair = getStair(n);
        System.out.println("count="+stair);
    }
}
