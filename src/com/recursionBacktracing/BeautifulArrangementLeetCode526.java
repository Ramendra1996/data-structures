package com.recursionBacktracing;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangementLeetCode526 {

    public static int countArrangement(int n) {
        // Use a helper method to perform backtracking
        return countArrangementHelper(new boolean[n + 1], 1);
    }

    // Helper method for backtracking
    private  static  int countArrangementHelper(boolean[] visited, int index) {
        // Base case: if all numbers have been placed, return 1 (a beautiful arrangement found)
        if (index == visited.length) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            // Check if the number has not been used and fits the condition
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                // Mark the number as visited
                visited[i] = true;
                // Recursively find the arrangements with the next index
                count += countArrangementHelper(visited, index + 1);
                // Backtrack: unmark the number to explore other possibilities
                visited[i] = false;
            }
        }

        return count;
    }

/*  static  int countArrangementHelper(List<Integer> v,int n , int currNum){
      //base case
      if(currNum==n+1){

          return 1;
      }
      int count =0;
      for(int i=1;i<=n;i++){
          if(v.get(i)==0 &&(currNum%i==0 ||i%currNum==0)){
           v.set(i,currNum);
          count+= countArrangementHelper(v,n ,currNum+1);
           v.set(i,0);
          }
      }
      return count;
    }

    public static int countArrangement(int n) {
        List<Integer> v = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            v.add(0); // initialize the list with 0s
        }
       return   countArrangementHelper(v,n,1);

    }*/
    public static void main(String[] args) {
        int  n = 2;
        int i = countArrangement(n);
        System.out.println(i);
    }
}

//TC=>( O(k^n))
