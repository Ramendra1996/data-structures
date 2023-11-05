package com.patterns;

import java.util.Scanner;

public class HollowRectangle {
    public static void main(String[] args) {

        System.out.println("Enter the row");
        Scanner scanner= new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("Enter the column");
        int col = scanner.nextInt();

        for (int i=0;i<row;i++){

            if(i==0 || i==row-1){
                for (int j=0;j<col;j++){
                    System.out.print("*");
                }

            }else {
                System.out.print("*");
                for (int j=0;j<col-2;j++){
                    System.out.print(" ");
                }
                System.out.print("*");

            }
            System.out.println();
        }


    }

}
