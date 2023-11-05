package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.List;

public class CheckKey {

    public static List<Integer> getSerach(String str ,char ch,int i,List<Integer>list){
        if(i>=str.length()){
            return list;
        }
        if(str.charAt(i)==ch){
           list.add(i);
        }
         return  getSerach(str,ch,i+1,list);
    }
    public static void main(String[] args) {
        String str = "ramendra";
        String key= "r";
        char ch = key.charAt(0);
        int i=0;
        List<Integer>list = new ArrayList<>();
      /*  if (getSerach(str,ch,i)){
            System.out.println("present");
        }else {
            System.out.println("not present");
        }*/
        List<Integer> serach = getSerach(str, ch, i, list);
        System.out.println(serach);
    }
}
