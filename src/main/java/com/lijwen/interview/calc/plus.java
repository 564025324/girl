package com.lijwen.interview.calc;

public class plus {
    public static void main(String[] args) {
        int i = 1;
        //i = (1)
        int j = i++;
        // i = (2)   j = (2)
        if ((i > ++j)         // i = (2)j = (2)
                && (i++ == j)) {   //i = (3)j = (3)
            i += j;      //i = (6)j = (3)
            System.out.println("i=" + i);
            System.out.println("j=" + j);
        }
    }
}
