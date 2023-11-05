package com.basic;


import java.util.Scanner;

public class AreaOfCircle {

    public  static  int getAreaOfCircle(int r){
        return (int) (3.14*r*r);
    }
    public static void main(String[] args) {
        System.out.println("Enter the redius");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int result = getAreaOfCircle(r);
        System.out.println("Area"+result);

    }
}
