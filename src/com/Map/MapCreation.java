package com.Map;

import java.util.HashMap;
import java.util.Map;

public class MapCreation {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("ram",1);
        map.put("raj",2);
        for (Map.Entry<String,Integer>m : map.entrySet()){
            if(m.getKey()=="ram"){
                System.out.println("present");
            }
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
