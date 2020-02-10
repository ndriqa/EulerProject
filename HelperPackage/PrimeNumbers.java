/**PrimeNumbers class is a helper class that holds useful
 * methods to check if a number is prime or not.
 *
 * @author ndriqa
 */

package HelperPackage;

public class PrimeNumbers {
    public static boolean isPrime(int p){
        return  isPrime((long) p);
    }
    public static boolean isPrime(long p){
        if (p<=1) {
            return false;
        }
        if (p==2) {
            return true;
        }
        if (p%2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(p) + 1; i = i + 2) {
            if (p%i == 0) {
                return false;
            }
        }
        return true;
    }
}
