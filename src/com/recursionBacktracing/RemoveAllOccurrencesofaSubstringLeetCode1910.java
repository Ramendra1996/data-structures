package com.recursionBacktracing;

public class RemoveAllOccurrencesofaSubstringLeetCode1910 {

    static String removeOccurrences1(String s, String part) {
        int index = s.indexOf(part);

        // Base case: if the part is not found, return the original string
        if (index == -1) {
            return s;
        }

        // Recursive case: remove the part and call the function again
        return removeOccurrences1(s.substring(0, index) + s.substring(index + part.length()), part);

    }
    static String removeOccurrences(String s, String part) {
        while(s.indexOf(part)>=0 && part.length()<=s.length()){
            int index=s.indexOf(part);
            s= s.substring(0,index)+s.substring(index+part.length());
        }
        return s;
    }

    public static void main(String[] args) {
    String s = "daabcbaabcbc", part = "abc";

        String s1 = removeOccurrences(s, part);
        System.out.println(s1);
        String s2 = removeOccurrences1(s, part);
        System.out.println(s2);
    }
}
