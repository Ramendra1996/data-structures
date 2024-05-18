package com.recursionBacktracing;

public class MinimumCostForTicketsLeetCode983 {
    //dp qustion

    static int mincostTicketsHelper(int[] days, int[] costs, int i) {
        //base case
          if(i>=days.length){
              return 0;
          }
        //1 case
        // 1 day pass
     int cost1 = costs[0]+mincostTicketsHelper(days,costs,i+1);
     //7 day pass
        int passEndDay =days[i]+7-1;
        int j =i;
        while ( j<days.length  &&days[j]<=passEndDay){
            j++;
        }
        int cost7 =costs[1]+mincostTicketsHelper(days,costs,j);

        //30 day pass
         passEndDay =days[i]+3-1;
         j =i;
        while ( j<days.length  &&days[j]<=passEndDay){
            j++;
        }
        int cost30 =costs[2]+mincostTicketsHelper(days,costs,j);

        return Math.min(cost1,Math.min(cost7,cost30));

    }

    static int mincostTickets(int[] days, int[] costs) {
        return  mincostTicketsHelper(days,costs,0);
    }

    public static void main(String[] args) {
       int[] days = {1,4,6,7,8,20};
       int [] costs = {2,7,15};

        int i = mincostTickets(days, costs);
        System.out.println(i);
    }
}
