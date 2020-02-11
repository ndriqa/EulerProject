package Project007;

import HelperPackage.PrimeNumbers;

/**By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author ndriqa
 * */

public class PrimeNo10001 {
    int count;
    final int MAXIMUM;
    long primeSearch;
    long thePrime;

    public PrimeNo10001(int maximum) {
        MAXIMUM = maximum;
        count = 0;
        primeSearch = 1l;
        thePrime = 1;
    }
    public void calculate(){
        while(count!=MAXIMUM){
            primeSearch++;
            if(PrimeNumbers.isPrime(primeSearch)){
                count++;
                thePrime = primeSearch;
            }
        }
        System.out.println("the " + MAXIMUM + "th prime is: " + thePrime);
    }

    public static void main(String[] args) {
        int max = 10001;
        PrimeNo10001 prime = new PrimeNo10001(max);
        prime.calculate();
    }
}
