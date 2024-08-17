package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
         String str = "aabc";
         int freq[]= new int[26];
        Queue<Character>q= new ArrayDeque<>();
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            //increment frequency
            freq[ch-'a']++;
            //q me push
            q.add(ch);
            while (!q.isEmpty()){
                if(freq[q.peek()-'a']>1){
                    q.poll();
                }else {
                    ans.append(q.peek());
                    break;
                }
            }
            if(q.isEmpty()){
                ans.append("#");
            }
        }
        System.out.println(ans);

    }
}
//TC->0(n)
//SC->0(n)