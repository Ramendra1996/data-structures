package com.string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDiffrence539LeetCode {

    public static int findMinDifference(List<String> timePoints) {

        ArrayList<Integer> minutes = new ArrayList<>();

        for(int index=0;index<timePoints.size();index++){
            String curr = timePoints.get(index);
            int hours = Integer.parseInt(curr.substring(0, 2));
            int min = Integer.parseInt(curr.substring(3));
            int totalMin = hours*60+min;
            minutes.add(totalMin);
        }
        Collections.sort(minutes);
        int mini=Integer.MAX_VALUE;

        for(int index=0;index<minutes.size()-1;index++){
            int diff = minutes.get(index+1)-minutes.get(index);
            mini=Math.min(mini, diff);
        }
        int lastDiff1 = (minutes.get(0)+1440)-minutes.get(minutes.size()-1);
        int lastDiff2 =minutes.get(minutes.size()-1)-minutes.get(0);
        int lastDiff=Math.min(lastDiff1,lastDiff2);
        mini=Math.min(mini, lastDiff);
        return mini;
    }

    public static void main(String[] args) {
        List<String>timePoints = Arrays.asList("23:59","00:00");
        int minDifference = findMinDifference(timePoints);

        System.out.println("minimumdiffrence="+minDifference);

    }
}
