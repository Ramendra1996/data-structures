package com.string;

public class IntegerToRomanLeetCode12 {
    static String intToRoman(int num) {
        String [] romanSymbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};

        String ans ="";
        for(int i=0;i<13;i++){
           while (num>=values[i]){
             ans+=romanSymbols[i];
             num-=values[i];
           }
        }
          return ans;
    }
    public static void main(String[] args) {
        int num=3;
        String s = intToRoman(num);
        System.out.println(s);
    }
}
