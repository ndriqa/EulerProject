package Project016;

import java.math.BigInteger;

/**2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * @author ndriqa
 * */
public class PowerDigitSum {
    int sum;
    int power;
    int base;
    String digits;

    public PowerDigitSum(int bas, int pow){
        base = bas;
        power = pow;
        sum = 0;
        digits = "";
    }
    public void calculate(){
        BigInteger number = new BigInteger("1");
        for (int i = 0; i < power; i++) {
            number = number.multiply(BigInteger.valueOf(base));
        }
        digits = number.toString();

        for (int i = 0; i < digits.length(); i++) {
            sum += Character.getNumericValue(digits.charAt(i));
        }
    }
    @Override
    public String toString(){
        return "the sum of the digits of " +base+"^"+power+" is: " + sum;
    }

    public static void main(String[] args) {
        int bas = 2;
        int pow = 1000;
        PowerDigitSum powpow = new PowerDigitSum(bas, pow);
        powpow.calculate();
        System.out.println(powpow);
    }
}
