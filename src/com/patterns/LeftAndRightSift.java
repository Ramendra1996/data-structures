package com.patterns;

public class LeftAndRightSift {
    public static void main(String[] args) {
        int n = 12;
        //left sift
       /* n=n<<1;
        System.out.println(n);
        //rightsift
        n=n>>1;
        System.out.println(n);*/
        int a=1;
        System.out.println((++a)*(++a));

        int dayOfWeek = 3;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day of the week");
        }

    }
}
