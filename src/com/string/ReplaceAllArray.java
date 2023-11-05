package com.string;

import java.util.Scanner;

public class ReplaceAllArray {
    public static  String getReplace(String str){
        char ch[] = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]==' '){
                ch[i]='@';
            }
        }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String replace = getReplace(str);
        System.out.println("replace string="+replace);
    }
}
