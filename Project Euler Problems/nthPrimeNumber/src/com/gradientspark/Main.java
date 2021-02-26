package com.gradientspark;

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//        What is the 10 001st prime number?

public class Main {

    public static void main(String[] args) {
        System.out.println(nthPrimeNumber(10001));
    }

    //this only works for int range just for convenience in answering this problem
    public static int nthPrimeNumber(int n) {

        // count listed as 1 because we assume we are looking for prime numbers above 2 in order to save iteration time
        int count = 1;
        int number = 1;
        int i;

        //above 2, ignore all even numbers as they will not be prime numbers
        while(count < n) {
            //we know all prime numbers after 2 are odd numbers
            number += 2;

            for(i = 2; i <= number; i++) {
                if(number % i == 0){
                    break;
                }
            }

            if (i == number) {
                //means we went through entire loop without dividing anything evenly, therefore number is prime
                //increment count and continue to next number
                //if it divides evenly prior to reaching number, it means that i != number and thus this block will not
                //execute and count will not be incremented and it will continue to next number
                count++;
            }

        }

        return number;
    }


}
