package com.search;

import java.util.Scanner;

public class DivideTwoNumber {
    public static int getSolve(int divident, int divisor){
        int start=0;
        int end=Math.abs(divident);
        int ans=0;
        while (start<=end){
            int mid =start+(end-start)/2;
            if (Math.abs(mid*divisor)==Math.abs(divident)){
                ans= mid;
                break;
            } else if (Math.abs(mid*divisor)>Math.abs(divident)) {
                end=mid-1;
            } else {
                ans=mid;
                start=mid+1;
            }
        }
        if((divisor<0 && divident<0) ||(divisor>0 &&divident>0)){
            return ans;
        }else {
            return -ans;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the divident");
        int divident = scanner.nextInt();
        System.out.println("enter the divisor");
        int divisor = scanner.nextInt();
        int solve = getSolve(divident, divisor);
        System.out.println("Ans="+solve);
    }
}
