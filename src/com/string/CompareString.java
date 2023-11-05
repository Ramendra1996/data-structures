package com.string;

import java.util.Scanner;

public class CompareString {

    public static boolean getCompare(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }else {

            for(int i=0;i<str1.length();i++){
                if(str1.charAt(i)!=str2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the first String");
        String str1= scanner.nextLine();
        System.out.println("Enter the second String");
        String str2= scanner.nextLine();

        if(getCompare(str1,str2)){
            System.out.println("String first and second are same");
        }else {
            System.out.println("String first and second are not same");
        }
    }
}
