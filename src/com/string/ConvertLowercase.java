package com.string;

import java.util.Scanner;

public class ConvertLowercase {
    public static String getConvert(String str){
         char ch[]= str.toCharArray();
         for(int i=0;i<ch.length;i++){
             if(ch[i]>='A' && ch[i]<='Z'){
                 ch[i]=(char)(ch[i]-'A'+'a');
             }
         }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("convert string="+getConvert(str));
    }
}
//Tc->0(n)
//SC->0(n)