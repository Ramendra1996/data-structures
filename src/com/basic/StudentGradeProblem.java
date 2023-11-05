package com.basic;

import java.util.Scanner;

public class StudentGradeProblem {

    public static String getGrade(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >=80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else if (marks >= 50) {
            return "E";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the marks:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String grade = getGrade(m);
        System.out.println("Grade=" + grade);

    }
}
