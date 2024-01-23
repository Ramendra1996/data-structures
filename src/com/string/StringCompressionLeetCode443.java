package com.string;

import java.util.Arrays;
import java.util.Collections;

public class StringCompressionLeetCode443 {
    public int compress1(char[] chars) {
        int i=0;
        int ansIndex=0;
        int n =chars.length;

        while(i<n){
            int j = i+1;
            while(j<n && chars[j]==chars[i]){
                j++;
            }

            chars[ansIndex++]=chars[i];
            int count = j-i;

            String str = Integer.toString(count);

            for(int k=0;k<str.length();k++){
                chars[ansIndex++]=str.charAt(k);
            }
            i=j;
        }
        return ansIndex;
    }
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    static int compress(char[] chars) {
        int index = 0;
        int count = 1;
        char prev = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                chars[index++] = prev;
                if (count > 1) {
                    int start = index;
                    while (count != 0) {
                        chars[index++] = (char) ((count % 10) + '0');
                        count /= 10;
                    }
                    // Reverse the compressed digits
                    reverse(chars, start, index - 1);
                }
                prev = chars[i];
                count = 1;
            }
        }

        chars[index++] = prev;
        if (count > 1) {
            int start = index;
            while (count != 0) {
                chars[index++] = (char) ((count % 10) + '0');
                count /= 10;
            }
            // Reverse the compressed digits
            reverse(chars, start, index - 1);
        }

        return index;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int compress = compress(chars);
        System.out.println(compress);
    }
}
