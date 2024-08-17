package com.stack;

import java.util.Stack;

public class TheCelebrityProblem {
     static int celebrity(int M[][], int n)
    {
        Stack<Integer>st = new Stack<>();
        //step1 :push all person into stack
        for (int i=0;i<n;i++){
             st.push(i);

        }
        //step2: run discard  method to get a mightBeCelebrity
        while (st.size()>1){
            int a = st.pop();
            int b= st.pop();
            //if a knows b
            if(M[a][b]==1){
                //a not celebrity , b might be
                st.push(b);
            }else {
                //b not celebrity a might
                st.push(a);
            }
        }
        //step 3: check that single person is acutely celebirty
        int mightBeCelebirty =st.pop();
        //cel should not know anyone
        for(int i=0;i<n;i++){
            if(M[mightBeCelebirty][i]==1){
                return -1;
            }
        }
        //everyone should know cel
        for (int i=0;i<n;i++){
            if(M[i][mightBeCelebirty]==0 && i!=mightBeCelebirty){
                return -1;
            }
        }
        // mightBeCelebirty hoga
        return mightBeCelebirty;
    }
    public static void main(String[] args) {
        int N=3;
        int M[][] = {{0, 1, 0}, {0 ,0, 0}, {0 ,1 ,0}};
        int celeb = celebrity(M, N);

        if (celeb == -1) {
            System.out.println("No celebrity found");
        } else {
            System.out.println("The celebrity is person " + celeb);
        }
    }
}
