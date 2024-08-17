package com.array;

public class AddTwoNumberRepresentByTwoArray {
    String calc_Sum(int a[], int n, int b[], int m) {
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
            int x = a[i] + b[j] + carry;
            int digit = x % 10;
            sb.append(digit);
            carry = x / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int x = a[i] + carry;
            int digit = x % 10;
            sb.append(digit);
            carry = x / 10;
            i--;
        }
        while (j >= 0) {
            int x = b[j] + carry;
            int digit = x % 10;
            sb.append(digit);
            carry = x / 10;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.reverse();
        return sb.toString();
    }
   /**
    *  //recursion method
    *  */
    public static  String addNum(int num1[], int num2[], int carry, int i, int j, StringBuffer sb){
        if (i < 0 && j < 0) {
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='0' ){
            sb.deleteCharAt(sb.length()-1);
        }
        int digit = 0;
        if (i >= 0) {
            digit += num1[i];
        }
        if (j >= 0) {
            digit += num2[j];
        }
        sb.append(digit % 10);
        carry = digit / 10;
        return addNum(num1, num2, carry, i - 1, j - 1, sb);
    }

    public static void main(String[] args) {
        AddTwoNumberRepresentByTwoArray ab = new AddTwoNumberRepresentByTwoArray();
        int a[] = {1, 2};
        int b[] = {2, 1};
        int n = 2;
        int m = 2;
        String s = ab.calc_Sum(a, n, b, m);
        System.out.println(s);
    }
}
