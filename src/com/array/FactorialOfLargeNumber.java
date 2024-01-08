package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorialOfLargeNumber {
    List<Integer> factorial(int n){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int carry=0;
        for(int i=2;i<=n;i++){
            for(int j=0;j<ans.size();j++){
                int x = ans.get(j)*i+carry;
                ans.set(j,x%10);
                carry=x/10;
            }
            while (carry!=0){
                ans.add(carry%10);
                carry/=10;
            }
            carry=0;
        }
         Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        FactorialOfLargeNumber fact = new FactorialOfLargeNumber();
        int n =50;
        List<Integer> factorial = fact.factorial(n);
        System.out.println(factorial);
    }
}
