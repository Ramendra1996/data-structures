package com.string;

import java.util.Arrays;

public class RemoveAllSpace {

    static  String removeSpace(String  str){
        char ch []= str.toCharArray();
        int index =0;
        for(int i=0;i< ch.length;i++){
            if(ch[i]!=' '){
                ch[index++]=ch[i];
            }
        }
        return String.valueOf(Arrays.copyOf(ch,index));
    }
    public static void main(String[] args) {
        String  str = "my name is ramendra kumar";
        str=removeSpace(str);
        System.out.println(str);
    }
}
