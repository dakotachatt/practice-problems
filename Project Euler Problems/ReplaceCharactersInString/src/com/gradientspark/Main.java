package com.gradientspark;

public class Main {

    public static void main(String[] args) {
	    System.out.println(makeComplement("TCATG"));
	    System.out.println(makeComplement("TTT"));
	    System.out.println(makeComplement("ATATAGTGAC"));
    }


    public static String makeComplement(String dna) {
        char[] dnaArray = dna.toCharArray();
        for(int i=0;i<dnaArray.length;i++)
        {
            if(dnaArray[i]=='A')
                dnaArray[i] = 'T';

            else if(dnaArray[i]=='T')
                dnaArray[i] = 'A';

            else if(dnaArray[i]=='C')
                dnaArray[i] = 'G';

            else if(dnaArray[i]=='G')
                dnaArray[i] = 'C';

        }
        return String.valueOf(dnaArray);
    }
}

