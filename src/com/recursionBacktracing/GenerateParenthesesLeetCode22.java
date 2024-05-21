package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesLeetCode22 {

    static void solve(List<String>ans,int n,int open,int close,String output){

        if(open==0 && close==0){
            ans.add(output);
            return;
        }
        //include open
        if(open>0){
            solve(ans,n,open-1,close,output+"(");
        }

        //include close
        if(close>open){
            solve(ans,n,open,close-1,output+")");
        }
    }

    public static List<String> generateParenthesis(int n) {

        List<String>ans = new ArrayList<>();
        int open =n;
        int close=n;
        String output="";
        solve(ans,n,open,close,output);
        return ans;

    }
    public static void main(String[] args) {

        List<String> strings = generateParenthesis(3);
        System.out.println(strings);

    }
}
