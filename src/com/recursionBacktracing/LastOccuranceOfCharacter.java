package com.recursionBacktracing;

public class LastOccuranceOfCharacter {

    static  int getFirstIndex(String str, char ch,int i){
      if(i>=str.length()){
          return -1;
      }

      if(str.charAt(i)==ch){
          return i;
      }
      return getFirstIndex(str,ch,i+1);
    }

    static  int getLastIndex(String  str, char ch ,int i){
        if(i<0){
            return -1;
        }
        if(str.charAt(i)==ch){
            return i;
        }
        return getLastIndex(str,ch,i-1);
    }
    public static void main(String[] args) {
        String str = "abcddefdg";
        char ch = 'd';
        int firstIndex=0;
        int lastIndex =str.length()-1;
        int firstIndex1 = getFirstIndex(str, ch, firstIndex);
        System.out.println("firstIndex="+firstIndex1);

        int lastIndex1 = getLastIndex(str, ch, lastIndex);
        System.out.println("lastIndex="+lastIndex1);

    }
}
