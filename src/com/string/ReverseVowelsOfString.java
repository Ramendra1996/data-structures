package com.string;

public class ReverseVowelsOfString {
 /*   static boolean isVowel(char ch){
        // Convert the character to lowercase to handle both uppercase and lowercase vowels
        ch = Character.toLowerCase(ch);
        // Check if the character is a vowel
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    static String swap(String str , int i , int j){
        char ch []=str.toCharArray();
        char temp =ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return String.valueOf(ch);
    }
    static String reverseVowels(String str) {
        int l=0;
        int h=str.length()-1;
        while (l<h){
            if(isVowel(str.charAt(l)) && isVowel(str.charAt(h))){
                str=swap(str,l,h);
                l++;
                h--;
            } else if (!isVowel(str.charAt(l))) {
                l++;
            }else {
                h--;
            }
        }
      return str;
    }*/
 static boolean isVowel(char ch) {
     // Convert the character to lowercase to handle both uppercase and lowercase vowels
     ch = Character.toLowerCase(ch);
     // Check if the character is a vowel
     return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
 }

    static String reverseVowels(String str) {
        int l = 0;
        int h = str.length() - 1;
        char[] charArray = str.toCharArray(); // Convert string to character array
        while (l < h) {
            if (isVowel(charArray[l]) && isVowel(charArray[h])) {
                // Swap vowels using a temporary variable
                char temp = charArray[l];
                charArray[l] = charArray[h];
                charArray[h] = temp;
                l++;
                h--;
            } else if (!isVowel(charArray[l])) {
                l++;
            } else {
                h--;
            }
        }
       // return String.valueOf(charArray); // Convert character array back to string
        return  new String(charArray);
    }

    public static void main(String[] args) {
     String   s = "leetcode";

        String s1 = reverseVowels(s);
        System.out.println(s1);

    }
}
