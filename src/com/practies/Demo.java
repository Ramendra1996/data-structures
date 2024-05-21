package com.practies;


import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static int reachStrears(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return reachStrears(n - 1) + reachStrears(n - 2);
    }

    public static int findFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * findFactorial(n - 1);
    }

    public static int findFibonacciSerice(int n) {

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return findFibonacciSerice(n - 1) + findFibonacciSerice(n - 2);
    }

    public static void printArray(int array[], int i) {

        if (i >= array.length) {
            return;
        }
        System.out.print(array[i] + " ");
        printArray(array, i + 1);
    }

    public static int findMaxi(int array[], int i, int maxi) {

        if (i >= array.length) {
            return maxi;
        }

        if (array[i] > maxi) {
            maxi = array[i];
        }
        return findMaxi(array, i + 1, maxi);

    }

    public static boolean checkKey(String str, char key, int i) {
        if (i >= str.length()) {
            return false;
        }
        if (str.charAt(i) == key) {
            return true;
        }
        return checkKey(str, key, i + 1);
    }

    public static int printdigit(int number) {

        int ans = 0;
        boolean flage = false;

        if (number <= Integer.MIN_VALUE) {
            return 0;
        }
        if (number < 0) {
            flage = true;
            number = -number;
        }

        while (number != 0) {

            if (ans > Integer.MAX_VALUE / 10) {
                return 0;
            }

            int digit = number % 10;
            ans = ans * 10 + digit;
            number = number / 10;


        }
        return flage ? -ans : ans;

    }

    public static boolean getKey(int[] array, int key1, int i) {
        if (i >= array.length) {
            return false;
        }
        if (array[i] == key1) {
            return true;
        }

        return getKey(array, key1, i + 1);
    }

    public static boolean checkSorted(int array[], int i) {

        if (i >= array.length - 1) {
            return true;
        }

        if (array[i] > array[i + 1]) {
            return false;
        }

        return checkSorted(array, i + 1);
    }

    public static int binarySearch(int array[], int start, int end, int key1) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array[mid] == key1)
            return mid;

        if (array[mid] < key1) {
            return binarySearch(array, mid + 1, end, key1);
        } else {
            return binarySearch(array, start, mid - 1, key1);
        }

    }

    public static void getSequence(String s, String output, List<String> list , int i){
       if(i>=s.length()){
           list.add(output);
            return ;
       }
       //include
         getSequence(s,output+s.charAt(i),list,i+1);
       //exclude
        getSequence(s,output,list,i+1);

    }

    public static int  coinChange(int arr[], int target) {
      if(target==0){
          return 0;
      }
      if(target<0){
          return Integer.MAX_VALUE;
      }
      int mini = Integer.MAX_VALUE;
      for(int i=0;i<arr.length;i++){
          int ans = coinChange(arr, target-arr[i]);

          if(ans!=Integer.MAX_VALUE){
              mini = Math.min(ans+1,mini);
          }
      }
      return mini;
    }

    public static  int cuttingSize(int n , int x ,int y, int z){

        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        int a = cuttingSize(n-x,x,y,z)+1;
        int b = cuttingSize(n-y,x,y,z)+1;
        int c = cuttingSize(n-z,x,y,z)+1;

        return Math.max(a,Math.max(b,c));
    }

    public static  int getMaxSum(int arr[],int i , int sum ,int newMaxi){
        if(i>= arr.length){
            newMaxi = Math.max(sum,newMaxi);
            return newMaxi;
        }
        //include
        newMaxi= getMaxSum(arr, i+2, sum+arr[i], newMaxi);
        //exlude
       newMaxi= getMaxSum(arr,i+1,sum,newMaxi);
        return newMaxi;
    }

    public static String swap(String str , int i , int j){
        char ch[]= str.toCharArray();
        char k = ch[i];
        ch[i]=ch[j];
        ch[j]=k;
        return String.valueOf(ch);
    }

    public static  void  getPer(String str , int i){
        if(i>=str.length()){
            System.out.println(str);
            return;
        }
        for (int j=i;j<str.length();j++){
            str = swap(str, i, j);
            getPer(str,i+1);
            str = swap(str,i,j);
        }
    }

    public static void solveParenthesis(List<String> ans , int open , int close, String output){
        if(open==0 && close==0){
            ans.add(output);
            return;
        }
        if(open>0){
            solveParenthesis(ans,open-1,close,output+"(");
        }
        if(close>open){
           solveParenthesis(ans,open,close-1,output+")");
        }
    }

    public static List<String> generateParenthesis(int n){

        int open = n;
        int close = n;
        String output = "";
        List<String> ans = new ArrayList<>();
        solveParenthesis(ans, open, close,output);
        return ans;

    }

    public static int getIndex(String str, char ch , int index,int ans){

        if(index>=str.length()){
            return ans;
        }
        if(str.charAt(index)==ch){
            ans = index;
        }
       return getIndex(str,ch,index+1,ans);

    }

    public static String reverseString(String str, int start, int end){

        if(start>=end){
            return str;
        }

        str=swap(str, start, end);
       return reverseString(str,start+1,end-1);

    }

    public static  boolean checkPalindrom(String str , int start , int end){

        if(start>=end){
            return true;
        }

        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return checkPalindrom(str,start+1,end-1);
    }

    public static  String removeOccurance(String str, String part){

        int found = str.indexOf(part);

        if(found==-1){
            return str;
        }
        return removeOccurance(str.substring(0,found) + str.substring(found+part.length()),part);
    }

    public static  void printSubArray_util(int array[], int start, int end){
        if(end>array.length){
            return;
        }

        for(int i=start;i<end;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println( );
        printSubArray_util(array,start,end+1);
    }
    public static  void printSubArray(int array[]){
        for(int start=0;start<array.length;start++){
            int end = start;
            printSubArray_util(array,start,end);
        }
    }

    public static  int maxProfitForStock(int array[], int miniPrice,int maxProfit, int index){

        if(index>=array.length){
            return maxProfit;
        }


        if(miniPrice>array[index]){
            miniPrice= array[index];
        }
        int todayProfit = array[index]-miniPrice;

        if(todayProfit>maxProfit){
            maxProfit=todayProfit;
        }
       return maxProfitForStock(array,miniPrice,maxProfit,index+1);


    }

    public static  int getRob(int arr[], int index){

        if(index>=arr.length){
            return 0;
        }
         int robAmt1 = arr[index] +getRob(arr,index+2);
        int robAmt2 = 0+getRob(arr,index+1);
        return Math.max(robAmt1,robAmt2);
    }

    public static void main(String[] args) {
    /*    int n = 5;
        int reachCount = reachStrears(5);
        System.out.println(reachCount);
        int factorial = findFactorial(5);
        System.out.println(factorial);
        int fibonacciSerice = findFibonacciSerice(5);
        System.out.println(fibonacciSerice);
        int array[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int key1 = 50;
        int i = 0;
        int maxi = Integer.MIN_VALUE;
        printArray(array, i);
        System.out.println(" ");
        int maxi1 = findMaxi(array, i, maxi);
        System.out.println(maxi1);
        String str = "ramendra";
        char key = 'g';
        boolean b = checkKey(str, key, i);
        System.out.println(b);
        int number = -123;
        int printdigit = printdigit(number);
        System.out.println(printdigit);
        boolean ans = getKey(array, key1, i);
        System.out.println(ans);
        boolean b1 = checkSorted(array, i);
        System.out.println(b1);
        int start = 0;
        int end = array.length - 1;
        int check = binarySearch(array, start, end, key1);
        System.out.println(check);

        String s ="abc";
        String output ="";
        List<String> list = new ArrayList<>();



        getSequence(s, output, list, i);

        for (String ss:list){
            System.out.println(ss);
        }

        int arr[]={1,2};
        int target = 5;

        int finalAns = coinChange(arr, target);
        System.out.println(finalAns);
        int cut = cuttingSize(7 ,5, 2, 2);
        System.out.println(cut);

        int newArray[] ={2,1,4,9};
        int sum =0;
        int newMaxi = Integer.MIN_VALUE;

        int maxSum = getMaxSum(newArray, i, sum, newMaxi);
        System.out.println(maxSum);

        String per = "abc";
        getPer(per,0);
*/

/*
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);


         String str = "abcddedg";
         char ch = 'd';
         int index=0;
         int ans =-1;

        int index1 = getIndex(str, ch, index, ans);
        System.out.println(index1);

        int start=0;
         int end = str.length()-1;

         str=reverseString(str, start,end);
        System.out.println(str);*/

//        String str = "racecar";
//        int start =0;
//         int end = str.length()-1;
//        boolean b = checkPalindrom(str, start, end);
//        System.out.println(b);

       /* String str="daabcbaabcbc";
        String part ="abc";

       str= removeOccurance(str,part);
        System.out.println(str);*/
//        int arr[]={1,2,3,4,5};
//        int start=0;
//         int end = start;
//         printSubArray(arr);


      /*  int array[]= {7,1,5,3,6,4};
        int miniPrice= Integer.MAX_VALUE;
        int maxProfit =Integer.MIN_VALUE;

        int index=0;

        int ans=maxProfitForStock(array,miniPrice,maxProfit, index);
        System.out.println(ans);*/

        int arr[]= {1,2,3,1};
        int index =0;
         int ans=getRob(arr, index);
        System.out.println(ans);


    }


}
