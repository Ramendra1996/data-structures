package com.recursionBacktracing;

public class ReverseString {

    static String swap(String str , int i, int j){
        char ch[] = str.toCharArray();
        char temp =ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return String.valueOf(ch);
    }

    static  String  getReverse(String str, int start, int end){

        if(start>=end){
            return str;
        }
        str = swap(str, start, end);
        str= getReverse(str, start + 1, end - 1);
        return str;
    }

    public static void main(String[] args) {
        String str = "ramendra";
        int start=0;
        int end = str.length()-1;
        String reverse = getReverse(str, start, end);
        System.out.println(reverse);

    }
}
