package com.string;

import java.util.Scanner;

public class ConvertUppercase {
    public static String getConvert(String str){
       char ch[]= str.toCharArray();
       for(int i=0;i<ch.length;i++){
           if(ch[i]>='a'&& ch[i]<='z'){
                 ch[i]=(char)(ch[i]-'a'+'A');
           }
       }
       return String.valueOf(ch);
    }
    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner scanner= new Scanner(System.in);
        String str = scanner.next();
        String convert = getConvert(str);
        System.out.println("Convert String="+convert);

    }
}
