package com.string;

public class StringToIntegerLeetCode8 {
    static int myAtoi(String s) {
         /*int r = Integer.parseInt(s);
         return r;*/

        int num = 0;
        int i = 0;
        int sign = 1;

        // Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        // Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            //digit allow only 7 tk
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // Update num
            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }
    public static void main(String[] args) {
        String s="    -42";
        int i = myAtoi(s);
        System.out.println(i);
    }
}
