package com.lijwen.interview.calc;

public class plus {

    /**
     * 常见的加法计算
     */
    public static void plusplus() {
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

    public static void div() {
        int total = 35;
        System.out.println(total / 15);
        System.out.println(total % 15);

    }


    public static void main(String[] args) {
        div();

    }
}
