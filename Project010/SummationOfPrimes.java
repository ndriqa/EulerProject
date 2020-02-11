package Project010;

import HelperPackage.PrimeNumbers;

/**The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * @author ndriqa
 */

public class SummationOfPrimes {
    long sum;
    int MAX;

    public SummationOfPrimes(int max){
        sum = 2;          //start from the first prime since it's the only even prime
        MAX = max;
    }
    public void calculate(){
        for(int i = 3; i < MAX; i = i + 2){     //we eliminate even numbers
            if(PrimeNumbers.isPrime(i)){
                sum+=i;
            }
        }
    }
    @Override
    public String toString(){
        return "the sum of prime numbers below " + MAX + " is: " + sum;
    }

    public static void main(String[] args) {
        int max = 2000000;
        SummationOfPrimes prisum = new SummationOfPrimes(max);
        prisum.calculate();
        System.out.println(prisum);
    }
}
