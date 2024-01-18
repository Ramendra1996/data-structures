package com.practies;

import java.util.Arrays;


public class Demo {


    static String removeSpace(String str){
        char ch []= str.toCharArray();
        for (int i=0;i< ch.length;i++){
            if(ch[i]>='A' && ch[i]<='Z'){
                ch[i]= (char) (ch[i]-'A'+'a');
            }
        }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        String str = "RAMENDRA";
        str=removeSpace(str);
        System.out.println(str);


    }

}
