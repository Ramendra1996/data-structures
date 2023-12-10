package com.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DefenseOfAKingdom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();

        int t = n;
        int[] rowC = new int[n + 2];
        int[] colC = new int[n + 2];

        rowC[0] = 0;
        colC[0] = 0;

        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            rowC[n - t] = a;
            colC[n - t] = b;
        }

        // size of 2D grid
        rowC[n + 1] = x + 1;
        colC[n + 1] = y + 1;

        Arrays.sort(rowC);
        Arrays.sort(colC);

        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < rowC.length; i++) {
            int a = rowC[i - 1];
            int b = rowC[i];

            maxLen = Math.max(maxLen, b - a - 1);
        }

        int maxWidth = Integer.MIN_VALUE;
        for (int i = 1; i < colC.length; i++) {
            int a = colC[i - 1];
            int b = colC[i];

            maxWidth = Math.max(maxWidth, b - a - 1);
        }

        System.out.println("answer is " + (maxLen * maxWidth));
    }
}
//15 8 3
//3 8
//11 2
//8 6