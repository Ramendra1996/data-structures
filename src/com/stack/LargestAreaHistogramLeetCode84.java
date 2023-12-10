package com.stack;

import java.util.*;

public class LargestAreaHistogramLeetCode84 {
    static List<Integer> getPreviousSmallest(List<Integer>list){
        Stack<Integer> st = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        st.push(-1);
        for (int i=0;i<list.size();i++){
            int curr = list.get(i);
            while ( st.peek()!=-1 &&list.get(st.peek())>=curr){
                st.pop();
            }
            ans.add(st.peek());
            st.push(i);
        }
        return ans;
    }
    //wrong approach cheek it
    static  List<Integer> getNextSmallest(List<Integer> list ){
        Stack<Integer> st = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        st.push(-1);
        for (int i=list.size()-1;i>=0;i--){
            int curr = list.get(i);
            while ( st.peek()!=-1&& list.get(st.peek())>=curr){
                st.pop();
            }
            ans.add(st.peek());
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
    static int getRectangularAreaHistogram(List<Integer>heights){
        List<Integer> pre = getPreviousSmallest(heights);
        List<Integer> next = getNextSmallest(heights);
        int maxArea = Integer.MIN_VALUE;
        int size = heights.size();
        for(int i=0;i<heights.size();i++){
            int length =heights.get(i);
            if(next.get(i)==-1){
                next.add(size);
            }
            int width =next.get(i)- pre.get(i)-1;
            int area =length*width;
            maxArea =Math.max(maxArea,area);

        }
        return maxArea;
    }
    public static void main(String[] args) {
         List<Integer>heights = Arrays.asList(2,1,5,6,2,3);
        int area = getRectangularAreaHistogram(heights);
        System.out.println("area="+area);
    }
}
