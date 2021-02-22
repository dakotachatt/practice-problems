package com.gradientspark;

public class Main {

    public static void main(String[] args) {

        //answer to test conditions; 5, 23, 83, 6857
        System.out.println(largestPrimeFactors(15L));
        System.out.println(largestPrimeFactors(276L));
        System.out.println(largestPrimeFactors(15687L));
        System.out.println(largestPrimeFactors(600851475143L));
    }

    // First Version - theory from https://www.geeksforgeeks.org/java-program-for-find-largest-prime-factor-of-a-number/
    // Assumes positive integer as input

    public static long largestPrimeFactors(long number) {
        // declared variable n, in order to perform arithmetic on user input, and update value as needed in loop below
        long n = number;

        // assumes 1 at a minimum, if number is even, become 2 through code block below as initial looping
        long largestPrimeFactor = 1;

        // Handles all even numbers (if even to begin with)
        while(n % 2 == 0) {
            largestPrimeFactor = 2;

            // Takes number from each iteration and halves it (effectively going through total number of 2's in prime factors)
            n /= 2;
        }

        // remaining numbers would be odd as all even numbers have been handled in block above
        for(long i=3; i <= Math.sqrt(n); i+=2) {
            while(n % i == 0) {
                largestPrimeFactor = i;

                // continues dividing by i until remainder is no longer zero, then continues the for loop iterating i by 2 (odd number)
                n /= i;
            }
        }

        // handles case where n is actually a prime number that's greater than 2
        // based on above, n will always become 1 or 2, unless the number happens to also be prime and greater than 2 (ie 13),
        // in which case it will then be the largest prime factor
        if(n > 2) {
            largestPrimeFactor = n;
        }

        return largestPrimeFactor;

    }
}
