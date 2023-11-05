package com.patterns;

import java.util.Scanner;

public class AlphabetPlaindromePyramid {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        for (int i=0;i<n;i++){
            int j;
            for ( j=0;j<i+1;j++){
                int ans =j+1;
                char ch = (char) (ans+'A'-1);
                System.out.print(ch);
            }

            for (j=i;j>=1;j--){
                int ans = j;
                char ch =(char)(ans+'A'-1);
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
