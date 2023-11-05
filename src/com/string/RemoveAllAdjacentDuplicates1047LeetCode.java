package com.string;

public class RemoveAllAdjacentDuplicates1047LeetCode {
    public static String getRemove(String str){
      StringBuffer sb =new StringBuffer();
      for(int i=0;i<str.length();i++){
          if(sb.isEmpty()){
              sb.append(str.charAt(i));
          }
         else if(!sb.isEmpty() && sb.charAt(sb.length()-1)==str.charAt(i)){
              sb.deleteCharAt(sb.length()-1);
          }else {
              sb.append(str.charAt(i));
          }
      }
      return  sb.toString();
    }
    public static void main(String[] args) {
        String str = "abbaca";
        String remove = getRemove(str);
        System.out.println("final string="+remove);
    }
}
