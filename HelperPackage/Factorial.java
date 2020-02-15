package HelperPackage;
/**Factorial static methods finding factorial as int, long, biginteger
 *
 * @author ndriqa
 * */
import java.math.BigInteger;

public class Factorial {
    public static int fact(int n){
        int prod = 1;
        for (int i = n; i > 1; i++) {
            prod *= i;
        }
        return prod;
    }

    public static long fact(long n){
        long prod = 1;
        for (long i = n; i > 1; i++) {
            prod *= i;
        }
        return prod;
    }

    public static BigInteger fact(BigInteger n){
        BigInteger prod = new BigInteger("1");
        for (long i = n.longValue(); i > 1; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        return prod;
    }
}
