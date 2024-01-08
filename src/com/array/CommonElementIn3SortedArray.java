package com.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CommonElementIn3SortedArray {
    int[] commonElement(int A[], int B[], int C[]) {
        // int ans[] = new int[Math.min(Math.min(A.length, B.length), C.length)];
     //   List<Integer> ans = new ArrayList<>();
        HashSet<Integer>ans = new HashSet<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && B[j] == C[k]) {
                ans.add(A[i]);
                i++;
                j++;
                k++;
            } else if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }
        //important
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        CommonElementIn3SortedArray ca = new CommonElementIn3SortedArray();
     /*   int A[] = {1, 5, 10, 20, 40, 80};
        int B[] = {6, 7, 20, 80, 100};
        int C[] = {3, 4, 15, 20, 30, 70, 80, 120};*/
        int A[]={3,3,3};
        int B[]={3,3,3};
        int C[]={3,3,3};
        int[] ints = ca.commonElement(A, B, C);
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }
}
