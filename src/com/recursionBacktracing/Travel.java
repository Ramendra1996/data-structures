package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Travel {
    HashMap<String,Integer>hmap = new HashMap<>();

    public  int cheapestPackage(int place){
        List<Integer> list = new ArrayList<>(hmap.values());
        Collections.sort(list);
        int amount = 0;
        for(int i=0;i<place;i++){
            amount+=list.get(i);
        }
        return amount;
    }
    public int maximumPlace(int amount){
      int count =0;
       List<Integer>list = new ArrayList<>(hmap.values());
       Collections.sort(list);
       int sum=0;
       for(int i=0;i<list.size();i++){
           sum+=list.get(i);
           count++;
           if(sum>amount){
               count--;
               break;
           }
       }
       return count;
    }
    public static void main(String[] args) {
        Travel obj = new Travel();
        obj.hmap.put("Delhi",5000);
        obj.hmap.put("jaipur",4000);
        obj.hmap.put("Agra",2500);
        obj.hmap.put("Goa",7000);
        System.out.println(obj.cheapestPackage(2));
        System.out.println(obj.maximumPlace(3000));

    }
}
