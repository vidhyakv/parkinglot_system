package com.parkinglot;

import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args){
        int hours = 31;


        System.out.println();
    }

    public static int test(){
        int[] intArray = new int[]{ 1,2,3,4 };
        for (int a: intArray){
            if(a==6){
                System.out.println(a);
                return a;
            }
        }
        return 10;
    }
}
