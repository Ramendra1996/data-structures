package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {

    public static  void  getSubsequences(String str,String output,int i,List<String>list){
        //basecase
        if(i>=str.length()){
         //   System.out.println(output);
            list.add(output);
            return ;
        }
        //exclude
          getSubsequences(str,output,i+1,list);
        //include
        output=output+str.charAt(i);
        getSubsequences(str,output,i+1,list);

    }
    public static void main(String[] args) {
        List<String >list= new ArrayList<>();
        String str="abc";
        String output="";
        int i=0;
        getSubsequences(str,output,i,list);
        System.out.println(list);
        for (String s:list){
            System.out.println(s);
        }
    }
}


/*
    public static List<String> getSubsequences(String str) {
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("");
        int length = str.length();

        while (!stack.isEmpty()) {
            String output = stack.pop();
            if (output.length() == length) {
                list.add(output);
            } else {
                int index = output.length();
                stack.push(output);
                stack.push(output + str.charAt(index));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> list = getSubsequences(str);
        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
        }
    }*/
