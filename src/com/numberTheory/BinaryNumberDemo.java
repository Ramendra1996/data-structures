package com.numberTheory;

public class BinaryNumberDemo {
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num >> i) & 1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int s = (1 << 31) - 1;
        System.out.println(s);

        // int b = (1<<32)-1; // This line is incorrect and will cause an error

        printBinary(9);

        int num = 14;
        int i = 1;
        if ((num & (1 << i)) != 0) {
            System.out.println("set bit");
        } else {
            System.out.println("not set bit");
        }

        // set bit
        printBinary(num | (1 << 1));
        // unset bit
        printBinary(num & ~(1 << 3));
        // toggle bit
        printBinary(num ^ (1 << 2));

        // count set bits
        int count = 0;
        for (int j = 31; j >= 0; j--) {
            if ((num & (1 << j)) != 0) {
                ++count;
            }
        }
        System.out.println("count=" + count);

        if((num & 1)!=0){
            System.out.println("odd");
        }else {
            System.out.println("even");
        }

        System.out.println("right sift" +(num>>1));
        System.out.println("left sift"  +(num<<1));

        //convert uppercase and lowercase

        for(char  c='A'; c<'E';++c){
            System.out.println(c);
            printBinary(c);
        }
        for (char c='a' ;c<'e';++c){
            System.out.println(c);
            printBinary(c);
        }
        char A= 'A';
        char a = (char) (A | (1<<5));
        System.out.println("print lowercase= "+a);
        System.out.println("print uppercase= "+ (char)(a&(~(1<<5))));

         //another method to conversion

        //uppercase to lowercase
        char B = 'B';
        char b = (char) (B |' ');
        System.out.println("print= "+ b);

        //lowercase to uppercase

        char d ='d';
        char D =(char)(d & '_');
        System.out.println("print= "+D);
         printBinary(59);

         //lsb technique
        int num1 = 59;
        int index =4;
        int num2 = (num1&(~((1<<(index+1))-1)));
        printBinary(num2);

        //msb technique
        index=3;
        int num3 = (num1 &((1<<(index+1))-1));
        printBinary(num3);

        int num4 = 16;
        if ((num4 & (num4 - 1)) == 0 && num4 != 0) {
            System.out.println("power of 2");
        } else {
            System.out.println("not power of 2");
        }

    }
}
