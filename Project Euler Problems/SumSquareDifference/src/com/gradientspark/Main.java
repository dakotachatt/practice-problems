package com.gradientspark;

//The sum of the squares of the first ten natural numbers is,
//              1^2 + 2^2 + ... + 10^2 = 385
//        The square of the sum of the first ten natural numbers is,
//              (1 + 2 + ... + 10)^2 = 55^2 = 3025
//        Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
//              3025 - 385 = 2640
//        Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

public class Main {

    public static void main(String[] args) {
        System.out.println(SumSquareDifference(1, 10));
        System.out.println(SumSquareDifference(1, 100));
    }

    public static long SumSquareDifference(int lowRange, int highRange) {

        //goal of this is to (through a for loop) both calculate the sum of squares, and sum of integers from the range given as an input.
        //afterward, the sum of integers variable (sum) is squared and then the difference is taken to solve the problem. Long was chosen in order
        //to give this a more broad application

        long sumOfSquares = 0;
        long sum = 0;
        long squareOfSum = 0;
        long sumSquareDifference = 0;

        for(int i = lowRange; i <= highRange; i++) {
            sumOfSquares += Math.pow(i, 2);
            sum += i;
        }

        squareOfSum = (long) Math.pow(sum, 2);

        sumSquareDifference = squareOfSum - sumOfSquares;

        return sumSquareDifference;
    }
}
