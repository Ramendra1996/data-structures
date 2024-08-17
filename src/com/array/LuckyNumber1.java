package com.array;

import java.util.Scanner;
/**
 * any number will be lucky number if Number has unique prime factors (non
 * repeated factors)
 *
 * @author apple
 *
 */

public class LuckyNumber1 {
    public static boolean isLuckyNumber(int n) {
        if (n < 2)
            return false;
        int freqOfFactor = 0;
        while (n % 2 == 0) {
            freqOfFactor++;
            n /= 2;
            if (freqOfFactor > 1)
                return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            freqOfFactor = 0;
            while (n % i == 0) {
                freqOfFactor++;
                n /= i;
                if (freqOfFactor > 1)
                    return false;
            }
        }

        return true;
    }

    public static int countLukyNumbers(int L, int R) {
        int count = 0;
        for (int val = L; val <= R; val++) {
            if (isLuckyNumber(val)) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        int R = scan.nextInt();

        System.out.println("lucky numbers in given range = " + countLukyNumbers(L, R));

    }
}
