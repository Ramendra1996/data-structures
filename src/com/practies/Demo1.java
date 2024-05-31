package com.practies;

import java.util.*;

public class Demo1 {

    //static Scanner scanner = new Scanner(System.in);

    public static int getSearch(int[] array, int key) {

        int ans = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void getCount(int[] array) {

        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroCount++;
            }

            if (array[i] == 1) {
                oneCount++;
            }
        }
        System.out.println("Zero=" + zeroCount);
        System.out.println("one=" + oneCount);
    }

    public static void getMaxAndMin(int[] array, int mini, int maxi) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxi) {
                maxi = array[i];
            }
            if (array[i] < mini) {
                mini = array[i];
            }
        }
        System.out.println("max element=" + maxi);
        System.out.println("mini element=" + mini);
    }

    public static void getPrintExtreme(int[] array, int start, int end) {

        while (start <= end) {

            if (start == end) {
                System.out.println(array[start]);
            } else {
                System.out.println(array[start]);
                System.out.println(array[end]);
            }
            start++;
            end--;
        }
    }

    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void reverseArray(int[] array, int start, int end) {
        while (start <= end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    public static void getSortZeroOne(int[] array, int start, int end) {
        while (start <= end) {
            if (array[start] == 1) {
                swap(array, start, end);
                end--;
            } else {
                start++;
            }
        }
    }

    public static void getMove(int[] array, int start, int end) {
        while (start <= end) {
            if (array[start] > 0) {
                swap(array, start, end);
                end--;
            } else {
                start++;
            }
        }
    }

    public static int findUnique(int[] array) {
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            ans = ans ^ array[i];
        }
        return ans;
    }

    public static int findMissingNumber(int[] array) {
        int n = array.length + 1;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        int missingNumber = (n * (n + 1)) / 2 - sum;


        return missingNumber;
    }

    public static void sortNumber(int[] array) {

        if (array.length <= 0) {
            System.out.println("Array is empty");
        }

        int start = 0;
        int mid = 0;
        int end = array.length - 1;

        while (mid < end) {

            if (array[mid] == 0) {
                swap(array, start, mid);
                start++;
                mid++;
            }
            if (array[mid] == 1) {
                mid++;
            }
            if (array[mid] == 2) {
                swap(array, mid, end);
                end--;
            }
        }
    }

    public static int findDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = Math.abs(array[i]);

            if (array[index] < 0) {
                return index;
            }
            array[index] *= -1;
        }
        return -1;
    }

    public static String addTwoString(String num1, String num2) {
        StringBuffer buffer = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            sum = digit1 + digit2 + carry;
            carry = sum / 10;
            buffer.insert(0, sum % 10);
        }
        return buffer.toString();

    }

    public static int getSerachKey(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int getFirstOccurance(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == key) {
                ans = mid;
                end = mid - 1;
            } else if (array[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int getLastOccurance(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == key) {
                ans = mid;
                start = mid + 1; //check
            } else if (array[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int getSquareRoot(int n){
        int start=0;
         int end =n;
         int ans =-1;
         while (start<=end){
             int mid = start+(end-start)/2;

             if(mid * mid == n ){
                 return mid;
             } else if (mid * mid>n) {
                 end=mid-1;
             }else {
                 ans=mid;
                 start=mid+1;
             }
         }
         return ans;
    }

    public static List<List<Integer>> getTarget(int[][] arr, int target){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int row = arr.length;
        int col = arr[0].length;
        int start = row;
        int end = row*col-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            int rowIndex = mid/col;
            int colIndex = mid%col;

            if(arr[rowIndex][colIndex]==target){
                System.out.println("rowIndex:"+rowIndex);
                System.out.println("colIndex:"+colIndex);
                list.add(rowIndex);
                list.add(colIndex);
                ans.add(list);
                return ans;
            } else if (arr[rowIndex][colIndex]>target) {
                end= mid-1;
            }else {
                start= mid +1;
            }
        }
        return ans;
    }

    public static  int getBinarySerch(int[] array, int target){
        int start = 0;
        int end = array.length-1;

        while (start<=end){
            int mid = start+(end-start)/2;

            if(array[mid]==target){
                return mid;
            } else if ( mid-1>=0 && array[mid-1]==target) {
                return mid-1;
            } else if ( mid+1<array.length &&array[mid+1]==target) {
                return  mid+1;
            } else if (array[mid]>target) {
                end= mid-2;
            }else {
                start= mid+2;
            }
        }
        return -1;
    }

    public static  int getSolve(int divident, int divisor){
        int start =0;
         int end = Math.abs(divident);
          int ans =0;
          while (start<=end){
              int mid = start+(end-start)/2;

              if(Math.abs(mid*divisor)==Math.abs(divident)){
                  ans= mid;
                  break;
              } else if (Math.abs(mid*divisor)>Math.abs(divident)) {
                  end=mid-1;
              }else {
                  ans= mid;
                  start=mid+1;
              }
          }
          if((divident<0 && divisor<0) ||(divident>0 && divisor>0)){
              return ans;
          }else {
              return -ans;
          }
    }

    public static int getOddOccurance(int[] array){
        int start=0;
         int end = array.length-1;
         while (start<=end){

             if(start==end){
                 return start;
             }
             int mid = start+(end-start)/2;

             if(mid%2==0){
                 if(array[mid]==array[mid+1]){
                     start=mid+2;
                 }else {
                     end= mid;
                 }
             }else {
                 if(array[mid]==array[mid-1]){
                     start= mid+1;
                 }else {
                     end= mid-1;
                 }
             }
         }
         return -1;
    }
    public static String  swapString(String str, int i, int j){
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return String.valueOf(ch);
    }

    public static  String  getReverseString(String str){

         int low =0;
         int high = str.length()-1;
         while (low<=high){
           str= swapString(str,low,high);
            low++;
            high--;
         }
         return str;
    }

    public static  String getRemoveSpace(String str){
//        for (int i=0;i<str.length();i++){
//            char ch = str.charAt(i);
//            if( ch == ' '){
//                ch='@';
//            }
//        }

       /* StringBuffer sb = new StringBuffer(str);

        for (int i=0;i<sb.length();i++){
            if(sb.charAt(i)==' '){
                System.out.println("+++++++++++");
                sb.insert(i,'@');
                System.out.println("____________");
            }
        }
        return sb.toString();*/

        char ch[] = str.toCharArray();

        for (int i=0;i<ch.length;i++){
            if(ch[i]==' '){
                ch[i]='@';
            }
        }
        return String.valueOf(ch);
    }

     public static  boolean getPalindrom(String str){
        int low = 0;
        int high =str.length()-1;
        while (low<=high){

            if(str.charAt(low)==str.charAt(high)){
                low++;
                high--;
            }else {
                return false;
            }
        }
        return true;
     }

     public static  String getUpperCase(String str){
      char ch []= str.toCharArray();

      for(int i=0;i<ch.length;i++){
          ch[i]= (char) (ch[i]-'a'+'A');
      }

      return  String.valueOf(ch);
     }

     public static String getLowerCase(String str){

        char ch [] = str.toCharArray();
        for (int i=0;i<ch.length;i++){
            ch[i]= (char) (ch[i]-'A' +'a');
        }
       return  String.valueOf(ch);
     }

     public static  String getRemoveDuplicate(String str){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){

            if((sb.length()-1)>=0 && sb.charAt(sb.length()-1)==str.charAt(i)){
                sb.deleteCharAt(sb.length()-1);
            }else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
     }

     public static  String removeOccurance(String str , String part){


         while (str.indexOf(part)>=0 && str.length()>=part.length()){
             int partIndex = str.indexOf(part);
             str=str.substring(0,partIndex) + str.substring(partIndex+part.length());
         }
         return str;
     }

      public static  boolean checkPalindrom(String str , int start, int end){
        while (start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
      }

     public static  boolean validPalindrom(String str){

         int start =0;
         int end = str.length()-1;
         while (start<=end){
             if(str.charAt(start)!=str.charAt(end)){
               return  checkPalindrom(str,start+1,end) || checkPalindrom(str,start,end-1);
             }else {
                 start++;
                 end--;
             }
         }

        return true;
     }


     public static int  getMiniTime(List<String>timePoints) {
         List<Integer> minutes = new ArrayList<>();

         for (int i = 0; i < timePoints.size(); i++) {
             String curr = timePoints.get(i);
             int hours = Integer.parseInt(curr.substring(0, 2));
             int min = Integer.parseInt(curr.substring(3));

             int totalMin = hours * 60 + min;
             minutes.add(totalMin);
         }
         Collections.sort(minutes);
         int mini = Integer.MAX_VALUE;

         for (int i = 0; i < minutes.size() - 1; i++) {
             int diff = minutes.get(i + 1) - minutes.get(i);

             mini = Math.min(mini, diff);
         }

         int lastDiff1 = (minutes.get(0) + 1440) - minutes.get(minutes.size() - 1);
         int lastDiff2 = minutes.get(minutes.size() - 1) - minutes.get(0);
         int lastDiff = Math.min(lastDiff1, lastDiff2);

         mini =Math.min(lastDiff,mini);

         return mini;
     }

     public static  int expndString(String str , int i , int j){
        int count =0;
        while (i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
     }

     public static  int getCountPalindrom(String str){
        int count =0;

        for(int i=0;i<str.length();i++){
             int oddAns = expndString(str,i,i);
             count = count+oddAns;
             int evenAns = expndString(str,i,i+1);
             count = count+evenAns;
        }
        return count;
     }

     static class  Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
     }

     public static  int bs(int array[], int start, int key){
        int end = array.length-1;

        while (start<=end){
            int mid = start+(end-start)/2;

            if(array[mid]==key){
                return  mid;
            } else if (array[mid]>key) {
                end=mid-1;
            }else {
                start = mid +1;
            }
        }
         return  -1;
     }

     public static  int getKDiff(int array[] , int k){
        int i=0;
         int j =1;

         Arrays.sort(array);
      Set<Pair> set = new HashSet<>();

      while (i<j && j<array.length) {
          int diff = array[j]-array[i];
          if(diff == k){
              set.add( new Pair(array[i],array[j]));
              i++;
              j++;
          }else if (diff>k){
              i++;
          }else {
              j++;
          }
      }
       return  set.size();
     }

     public static  int getKDiff1(int array[] , int k){
         Arrays.sort(array);
         Set<Pair> set = new HashSet<>();

         for(int i=0;i<array.length;i++){
             if(bs(array,i+1,array[i]+k)!=-1){
                 set.add(new Pair(array[i],(array[i]+k)));
             }
         }
         return set.size();
     }

//     public static  boolean isPossible(int arr[], int start, int end, int mid , int m){
//        int pageSum =0;
//         int studentCount =1;
//         for(int i=0;i<arr.length;i++){
//
//             if(arr[i]>mid){
//                 return false;
//             }
//             if(pageSum+arr[i]>mid){
//                 studentCount++;
//                 if(studentCount>m){
//                     return false;
//                 }
//                 pageSum= arr[i];
//             }else {
//                 pageSum+= arr[i];
//             }
//         }
//         return true;
//     }

//     public static  int getResult(int arr[], int m){
//
//        int sum =0;
//        for(int i=0;i<arr.length;i++){
//            sum+=arr[i];
//        }
//         int start =0;
//         int end =sum;
//         int ans =0;
//         while (start<=end){
//           int mid = start+(end-start)/2;
//             if(isPossible(arr, start,end,mid,m)){
//                 ans=mid;
//                 end= mid-1;
//             }else {
//                 start= mid+1;
//             }
//         }
//
//         return ans;
//
//     }

    public static  boolean isPossible(int arr[], int mid , int k){
        int cow = 1;
        int cowPosition =arr[0];
        for(int i=1;i<arr.length;i++){

            if(arr[i]-cowPosition>=mid){
                cow++;
                cowPosition=arr[i];
            }
            if(cow==k){
                return true;
            }
        }
        return false;
    }
     public static int getAggresive(int arr[], int k){
        Arrays.sort(arr);
        int start =0;
         int end = arr[arr.length-1]-arr[0];
         int ans  =-1;
         while (start<=end){
             int mid = start+(end-start)/2;
             if(isPossible(arr,mid,k)){
                  ans= mid;
                  start=mid+1;
             }else {
                 end= mid-1;
             }
         }
         return ans;
     }


    public static void main(String[] args) {
   /*     System.out.println("Enter the Size of Array: ");
        int  n = scanner.nextInt();
        System.out.println("Enter the array element :");
        int array[] =  new int[n];
        for(int i=0;i<n;i++){
            array[i]= scanner.nextInt();
        }

        System.out.println("Print the Array:");

        for(int i=0;i< array.length;i++){
            System.out.print(array[i] +" ");
        }
        System.out.println();*/

       /* int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int key = 6;
        int search = getSearch(array, key);
        System.out.println(search);
*/
//        int array[]={1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,0};
//          getCount(array);
       /* int  array[]= {1,2,3,4,5,6,7,100,9};
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

         getMaxAndMin(array, mini,maxi);*/

//        int array[]={10,20,30,40,50,60,70,80,90};
//        int start =0;
//        int end = array.length-1;
//
//           getPrintExtreme(array, start,end);


//        int array[]={10,20,30,40,50,60,70,80,90};
//        int start=0;
//        int end = array.length-1;
//
//        reverseArray(array,start,end);
//
//        for (int i=0;i<array.length;i++){
//            System.out.print(array[i]+" ");
//        }
//
//        int array[]= {1,0,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,0,0,1};
//
//        int start=0;
//        int end =array.length-1;
//         getSortZeroOne(array, start,end);
//         for (int  i=0; i<array.length;i++){
//             System.out.print(array[i]+" ");
//         }

        /*int array[]={1,2,-4,-5,-9,-8,-1,4,5,-6,7};
        int start =0;
        int end =array.length-1;
         getMove(array,start,end);

         for (int i=0;i<array.length;i++){
             System.out.print(array[i]+" ");
         }*/

//        int array[]={1,1,2,2,3,4,4,5,5,6,6,7,7,8,8,9,9};
//
//        int unique = findUnique(array);
//        System.out.println("unique="+unique);

//        int array[]= {1,2,4,5,6,7,8,9};
//        int missingNumber = findMissingNumber(array);
//
//        System.out.println(missingNumber);

//        int array[]={0,0,0,1,1,1,1,2,2,2,1,0,0,1,1,1,2,2,2,1,1,0,0};
//
//          sortNumber(array);
//
//           for (int i=0;i<array.length;i++){
//               System.out.print(array[i]+" ");
//           }


      /*     int  array[]  ={1,2,3,4,5,6,7,8,9,3};

           findDuplicate(array);


           String num1 = "11";
           String num2 ="123";

        String str= addTwoString(num1,num2);
        System.out.println(str);*/

       /* int array[] = {1,3,4,2,2};
        int duplicate = findDuplicate(array);
        System.out.println(duplicate);*/
//
//        int array []= {2,4,6,8,10,12,14};
//        int target = 2;
//        int serachKey = getSerachKey(array, target);
//        System.out.println(serachKey);

      /*  int array[]={1,2,3,7,7,7,7,7,7,7,7,7,8,9};
        int key = 7;
        int firstOccurance = getFirstOccurance(array, key);
        System.out.println("firstOccurance="+firstOccurance);

        int lastOccurance = getLastOccurance(array, key);
        System.out.println("lastOccurance="+lastOccurance);*/

//        int n =25;
//
//        int squareRoot = getSquareRoot(n);
//        System.out.println(squareRoot);

   /*     int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int target = 13;

        List<List<Integer>> target1 = getTarget(arr, target);
        System.out.println(target1);*/

//        int array[]= {10,3,40,20,50,80,70};
//        int target = 50;
//
//        int binarySerch = getBinarySerch(array, target);
//
//        System.out.println(binarySerch);
/*
        int divident =-22;
        int divisor =-7;

        int solve = getSolve(divident, divisor);
        System.out.println(solve);
*/

       /* int array[]={1,1,2,2,3,3,4,4,3,600,600,4,4};

        int oddOccurance = getOddOccurance(array);
        System.out.println(oddOccurance);*/
      /*  String str = "babbar";
        String reverseString = getReverseString(str);
        System.out.println(reverseString);*/

      /*  String str ="my name is babbar";
        String str1 = getRemoveSpace(str);
        System.out.println(str1);*/

      /*  String str = "nodgon";

        boolean palindrom = getPalindrom(str);
        System.out.println(palindrom);*/
/*
        String str = "ramendra";
        String upperCase = getUpperCase(str);
        System.out.println(upperCase)*/;
//        String str = "RAMENDRA";
//        String lowerCase = getLowerCase(str);
//        System.out.println(lowerCase);

       /* String str = "abbaca";
        String removeDuplicate = getRemoveDuplicate(str);
        System.out.println(removeDuplicate);*/

     /*   String str ="daabcbaabcbc";
        String part ="abc";

        String s = removeOccurance(str, part);
        System.out.println(s);*/

    /*    String str ="abca";

        boolean b = validPalindrom(str);
        System.out.println(b);*/

     /*   List<String>timePoints = Arrays.asList("23:59","00:00");
        int miniTime = getMiniTime(timePoints);

        System.out.println(miniTime);*/

       /* String str = "noon";
        int countPalindrom = getCountPalindrom(str);
        System.out.println(countPalindrom);*/


//        int array[]={1,1,1,1};
//        int kDiff = getKDiff(array, 0);
//        System.out.println(kDiff);
//
//        int kDiff1 = getKDiff1(array, 0);
//        System.out.println(kDiff1);

    /*    int arr[] = {12, 34, 67, 90};
        int m = 2;

        int result = getResult(arr, m);
        System.out.println(result);*/

        int []  stalls = {1, 2, 4, 8, 9};
        int n=5;
        int k=3;
        int aggresive = getAggresive(stalls, k);
        System.out.println(aggresive);
    }


}
