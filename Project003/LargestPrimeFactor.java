package Project003;

import HelperPackage.PrimeNumbers;

/**The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author ndriqa
 * */

public class LargestPrimeFactor {
    long number;

    public LargestPrimeFactor(long num){
        number = num;
    }

    public long getLargestPrimeFactor(){
        long primeFact = 1l;
        long i = 1;

        while(i < Math.sqrt(number)){
            if(number%i == 0){
                if(PrimeNumbers.isPrime(i)){
                    primeFact = i;
                    System.out.println(primeFact + " is a prime factor of " + number);
                }
            }

            i+=2;
        }
        return primeFact;
    }

    public static void main(String[] args) {
        long num = 600851475143l;

        LargestPrimeFactor primeFactor = new LargestPrimeFactor(num);

        long largestFactor = primeFactor.getLargestPrimeFactor();
        System.out.println("the largest one is: " + largestFactor);

    }
}
