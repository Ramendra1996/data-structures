package com.string;

public class ReverseOnlyLettersLeetCode917 {

    static String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }
    static String reverseOnlyLetters1(String s) {
        char[] ch = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if (Character.isLetter(ch[low]) && Character.isLetter(ch[high])) {
                char temp = ch[low];
                ch[low] = ch[high];
                ch[high] = temp;
                low++;
                high--;
            } else if (!Character.isLetter(ch[low])) {
                low++;
            } else {
                high--;
            }
        }

        return String.valueOf(ch);
    }

    static String reverseOnlyLetters(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if ((s.charAt(low) >= 'a' && s.charAt(low) <= 'z' || s.charAt(low) >= 'A' && s.charAt(low) <= 'Z')
                    && (s.charAt(high) >= 'a' && s.charAt(high) <= 'z' || s.charAt(high) >= 'A' && s.charAt(high) <= 'Z')) {
                s = swap(s, low, high);
                low++;
                high--;
            } else if (!(s.charAt(low) >= 'a' && s.charAt(low) <= 'z' || s.charAt(low) >= 'A' && s.charAt(low) <= 'Z')) {
                low++;
            } else {
                high--;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        String s= "ab_cd";
        String s1 = reverseOnlyLetters1(s);
        System.out.println(s1);
    }
}
