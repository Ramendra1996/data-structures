package com.string;

public class ValidAnagramLeetCode242 {

    static  boolean isAnagram(String s, String t){
        // 256 AssII Characters
     //   char ki range 1byte =8 bit=> to taotal 2^8
        int freqTable[]= new int[256];

        for(int i=0;i<s.length();i++){
            freqTable[s.charAt(i)]++;
        }
        for (int i=0;i<t.length();i++){
            freqTable[t.charAt(i)]--;
        }
        for(int i=0;i<freqTable.length;i++){
            if(freqTable[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t ="anagram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
}
