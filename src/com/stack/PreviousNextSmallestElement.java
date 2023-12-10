package com.stack;


import java.util.*;

public class PreviousNextSmallestElement {

    static List<Integer> getPreviousSmallest(List<Integer>list){
        Stack<Integer> st = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        st.push(-1);
        for (int i=0;i<list.size();i++){
            int curr = list.get(i);
            while (st.peek()>=curr){
                st.pop();
            }
            ans.add(st.peek());
            st.push(curr);
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
            while (st.peek()>=curr){
                st.pop();
            }
            ans.add(st.peek());
            st.push(curr);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,1,4,3);
        List<Integer> solve = getNextSmallest(list);
        System.out.println("nextSmallest="+solve);
        List<Integer> previousSmallest = getPreviousSmallest(list);
        System.out.println("previous="+previousSmallest);


    }
}
