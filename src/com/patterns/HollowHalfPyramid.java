package com.patterns;

import java.util.Scanner;

public class HollowHalfPyramid {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0;i<n;i++){
            int k =0;
            for (int j=0; j<2*n-1;j++){
             if (j<n-i-1){
                 System.out.print(" ");
             }else if (k<2*i+1){
                 if(k==0||k==2*i||i==n-1){
                     System.out.print("*");
                 }else {
                     System.out.print(" ");
                 }

                 k++;
             }else {
                 System.out.print(" ");
             }

            }
            System.out.println();
        }
    }
}
