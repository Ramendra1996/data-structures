package com.recursionBacktracing;

public class CutIntoSegment {
    public static int getSolve(int n, int x, int y, int z){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        int ans1 = getSolve(n-x,x,y,z)+1;
        int ans2 = getSolve(n-y,x,y,z)+1;
        int ans3 = getSolve(n-z,x,y,z)+1;
        int ans = Math.max(ans1,Math.max(ans2,ans3));
        return ans;

    }
    public static void main(String[] args) {
        int n=7;
        int x=5;
        int y=2;
        int z=2;

        int ans = getSolve(n, x, y, z);
        if(ans<0){
            ans=0;
        }
        System.out.println("ans="+ans);
    }
}
