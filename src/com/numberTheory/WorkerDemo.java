package com.numberTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int n = scan.nextInt();
        List<Integer> masks = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int mask = 0;
            System.out.println("Enter the number of workers for day " + (i + 1) + ":");
            int num_worker = scan.nextInt();
            System.out.println("Enter the working days for each worker:");
            for (int j = 0; j < num_worker; j++) {
                int day = scan.nextInt();
                mask = (mask | (1 << day));
            }
            masks.add(mask);
        }

        int maxDays=0;
        int person1=-1;
        int person2=-1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int interSection = (masks.get(i) & masks.get(j));
                int commonDays = Integer.bitCount(interSection);

                if(commonDays >maxDays){
                    maxDays = commonDays;
                    person1=i;
                    person2=j;
                }
                System.out.println(person1 + " " + person2 + " " + maxDays);
            }
        }
    }
}

//TC =0(n^2)