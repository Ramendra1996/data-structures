package com.string;

public class RemoveAllOccurrencesOfASubstring1910LeetCode {

    public static  String getRemaingString(String str, String part){


         while (str.indexOf(part)>=0 && part.length()<=str.length()){
             int index=str.indexOf(part);
             str= str.substring(0,index)+str.substring(index+part.length());
         }
         return str;
    }

    public static void main(String[] args) {
        String str = "daabcbaabcbc";
        String part= "abc";
        String remaingString = getRemaingString(str, part);
        System.out.println("remaing string="+remaingString);

    }
}
