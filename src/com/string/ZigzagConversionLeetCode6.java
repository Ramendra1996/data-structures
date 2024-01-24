package com.string;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversionLeetCode6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> zigzag = new ArrayList<>(numRows);

        // Initialize the list with empty StringBuilder objects
        for (int i = 0; i < numRows; i++) {
            zigzag.add(new StringBuilder());
        }

        int i = 0;
        int row = 0;
        boolean direction = true;

        while (i < s.length()) {
            zigzag.get(row).append(s.charAt(i++));

            if (direction) {
                row++;
            } else {
                row--;
            }

            if (row == numRows) {
                row = numRows - 2;
                direction = false;
            } else if (row < 0) {
                row = 1;
                direction = true;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder rowString : zigzag) {
            ans.append(rowString);
        }

        return ans.toString();
    }
    public static void main(String[] args) {
      String  s = "PAYPALISHIRING";
       int numRows = 3;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }
}
