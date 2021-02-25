package com.gradientspark;

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

//Note this answer was done with another brute force method, there will definitely be an easier more efficient way to do this,
//need to figure out ways to reduce criteria to compare against in range (ie. if number is divisible by 4, it is also divisible by 2,
// or if divisible by 10, also divisible by 5 etc.)

public class Main {

    public static void main(String[] args) {
        System.out.println(SmallestMultiple(1, 10));
        System.out.println(SmallestMultiple(1, 20));
    }

    public static int SmallestMultiple(int lowRange, int highRange) {
        //Nested for loop to iterate through solution. Outer loop iterates to get smallest multiple that is divisible by all numbers
        //between lowRange and highRange (inclusive), while inner loop checks if outer loop number is actually divisible by said
        //numbers.
        //Need to find better way of specifying loop criteria, but for now, assume upper limit is int max value, this will cover
        //several ranges, but will eventually not work

        //Counts how many total ints between range (inclusive)
        int rangeTotal = highRange - lowRange + 1;
        //To be used to count and compare to rangeTotal in nested for loop below
        int rangeCheck = 0;

        for(int i = 1; i < 2147483647; i++) {
            for(int j = lowRange; j <= highRange; j++){
                if(i % j == 0) {
                    rangeCheck += 1;

                    //Checks if rangeCheck at this time equals rangeTotal, which means each of the ints in the range divide evenly
                    //with the number i in the outer loop, which is then the smallestMultiple of each int in the range
                    if(rangeCheck == rangeTotal) {
                        return i;
                    }
                } else {
                    rangeCheck = 0;
                }
            }
        }

        //Returns -1 if no multiple found to satisfy range given with max int value as upper thresh hold
        return -1;
    }
}
