package Project003;

import HelperPackage.PrimeNumbers;

/**The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author ndriqa
 * */

public class LargestPrimeFactor {
    long number;
    long largest;

    public LargestPrimeFactor(long num){
        number = num;
        largest = 1;
    }

    public void calculate(){
        long i = 1;

        while(i < Math.sqrt(number)){
            if(number%i == 0){
                if(PrimeNumbers.isPrime(i)){
                    largest = i;
                    System.out.println(largest + " is a prime factor of " + number);
                }
            }

            i+=2;
        }
    }

    @Override
    public String toString(){
        return "largest one is: "+largest;
    }

    public static void main(String[] args) {
        long num = 600851475143l;

        LargestPrimeFactor primeFactor = new LargestPrimeFactor(num);
        primeFactor.calculate();
        System.out.println(primeFactor);

    }
}
