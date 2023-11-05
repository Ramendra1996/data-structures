package com.patterns;

import java.util.Scanner;

public class NumericFullPyramid {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0;i<n;i++){
            //space
           for(int j=0;j<n-i-1;j++){
               System.out.print(" ");
           }
            //number
            for (int j=0;j<i+1;j++){
                System.out.print(i+j+1);
            }
            //reverseCounting
            int start = 2*i;
            for (int j=0;j<i;j++){
                System.out.print(start);
                start--;
            }

            System.out.println();
        }










      /*  for (int i=0;i<n;i++){
            int start= i+1;
            for (int j=0;j<i+1;j++){
                System.out.print(start+" ");
                start++;
            }
            System.out.println();
        }*/
    }
}
