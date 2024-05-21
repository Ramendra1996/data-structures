package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNoLeetCode17 {

    public static void  solve(String digits,List<String>list , String output,int index,String mapping[]){
        //basecase
        if(index>=digits.length()){
            list.add(output);
            return;
        }
        int number = digits.charAt(index)-'0';
        String value = mapping[number];

        for (int i=0;i<value.length();i++){
            solve(digits,list,output+value.charAt(i),index+1,mapping);
        }
    }

 public static    List<String> letterCombinations(String digits){

        List<String> list = new ArrayList<>();
        String output="";
        String mapping[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index=0;
        if (digits.length()==0){
            return list;
        }
        solve(digits,list,output,index,mapping);
        return list;


    }

    public static void main(String[] args) {
       String digits = "23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }
}
