package com.string;

import java.util.Scanner;

public class CharArrayUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the character array: ");
        int arraySize = scanner.nextInt();

        char[] charArray = new char[arraySize];

        System.out.print("Enter " + arraySize + " characters: ");

        // Read characters one by one and store them in the array
        for (int i = 0; i < arraySize; i++) {
            charArray[i] = scanner.next().charAt(0);
        }

        System.out.print("You entered the following characters: ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
    }
}
