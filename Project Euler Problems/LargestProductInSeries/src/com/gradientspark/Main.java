package com.gradientspark;

public class Main {

    public static void main(String []args){
        String number= "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";

        System.out.println(LargestProductInSeries(number, 13));

    }

    public static long LargestProductInSeries(String number, int numberOfDigits) {
        int[] digitArray = new int[numberOfDigits];
        int k;
        //initialized both product variables as 1, due to inner array loop using the *= operator to avoid all results = 0
        long product = 1L;
        long finalProduct = 1L;

        //iterates to become the starting index on the next round of integer selection
        for(int i = 0; i < (number.length() - (numberOfDigits -1)); i++) {
            //Resets product for each outer loop that occurs so number isn't constantly being appended with past results
            product = 1L;
            //used (in addition to the loop below) to gather all requested adjacent digits with i being the starting index in the
            //user supplied number
            k = i;
            //chose this method as it seemed the easiest way (as opposed to doing arithmetic) to select individual digits in the
            //user supplied number, converting from a string to an int to perform arithmetic after
            digitArray[0] = Character.getNumericValue(number.charAt(k));

            //loop to continue until user specified digits reached
            for(int j = 1; j < numberOfDigits; j++) {
                k += 1;
                digitArray[j] = Character.getNumericValue(number.charAt(k));
            }

            for(int digit : digitArray) {
                product *= digit;
            }

            if(product >= finalProduct) {
                finalProduct = product;
            }
        }


        return finalProduct;
    }
}
