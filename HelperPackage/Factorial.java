package HelperPackage;
/**Factorial static methods finding factorial as int, long, biginteger
 *
 * @author ndriqa
 * */
import java.math.BigInteger;

public class Factorial {
    public static int intFact(int n){
        int prod = 1;
        for (int i = n; i > 1; i++) {
            prod *= i;
        }
        return prod;
    }

    public static long longFact(int n){
        long prod = 1;
        for (int i = n; i > 1; i++) {
            prod *= i;
        }
        return prod;
    }

    public static BigInteger bigFact(int n){
        BigInteger prod = new BigInteger("1");
        for (int i = n; i > 1; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        return prod;
    }
}
