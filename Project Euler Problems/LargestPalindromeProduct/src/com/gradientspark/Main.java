package com.gradientspark;

public class Main {

    public static void main(String[] args) {
        System.out.println(largestPalindromeProduct());
    }

    // this code is to find the largest 3 digit 2 number product that is a palindrome, does not need a method really
    // using int data type as 999 * 999 is still an int

    // This version uses modular arithmetic to get each digit and compare, this can also be done, potentially easier with strings
    // plan to make this work for any series of numbers not just 3 digits, but for now this is hardcoded in to solve for 3 digit
    // number products

    public static int largestPalindromeProduct() {

        // initializes both numbers as smallest 3 digit number
        int firstNum = 100;
        int secondNum = 100;
        int maxPalindrome = 0;

        int digitOne;
        int digitTwo;
        int digitThree;
        int digitFour;
        int digitFive;
        int digitSix;

        // Very brute force method of getting all possible products, determine way to make this more efficient
        for(int i = firstNum; i < 1000; i++) {
            for(int j = secondNum; j < 1000; j++) {

                // code block to work with 5 digit products - ie. is digit 12 reversed from digit 45 (ie. is 1 = 5, 2 = 4?)
                // Never checks 3rd digit, as it doesn't matter and won't affect whether it's is a palindrome or not
                // Note that for checking the largest palindrome, this code block is unnecessary as the largest one would be a 6 digit
                // number. This is just for completeness, and can be used if we needed to print out all palindromes from 3 digit products
                if(String.valueOf(i * j).length() == 5) {

                    // counterintuitive, but digitOne is in reading order, digit 5 as per input, is based on the mathematical formula
                    digitOne = singleDigit(i * j, 5);
                    digitTwo = singleDigit(i * j, 4);
                    digitFour = singleDigit(i * j, 2);
                    digitFive = singleDigit(i * j, 1);

                    if((digitOne == digitFive) && (digitTwo == digitFour) && ((i * j) > maxPalindrome)) {
                        maxPalindrome = i * j;
                    }

                } else if(String.valueOf(i * j).length() == 6) {
                    digitOne = singleDigit(i * j, 6);
                    digitTwo = singleDigit(i * j, 5);
                    digitThree = singleDigit(i * j, 4);
                    digitFour = singleDigit(i * j, 3);
                    digitFive = singleDigit(i * j, 2);
                    digitSix = singleDigit(i * j, 1);

                    if((digitOne == digitSix) && (digitTwo == digitFive) && (digitThree == digitFour) && ((i * j) > maxPalindrome)) {
                        maxPalindrome = i * j;
                    }
                }
            }
        }




        // code block to work with 6 digit products  - does digit 1 = 6, 2 = 5, 3 = 4?
        // has to check all 6 digits

        return maxPalindrome;
    }

    public static int singleDigit(int product, int digit) {
        return (int) ((product % Math.pow(10, digit)) / Math.pow(10, digit - 1));
    }
}
