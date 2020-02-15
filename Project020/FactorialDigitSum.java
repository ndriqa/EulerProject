package Project020;

import HelperPackage.Factorial;

import java.math.BigInteger;

/**n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * @author ndriqa
 * */
public class FactorialDigitSum {
    int N;
    BigInteger factorialValue;
    int sumOfDigits;

    public FactorialDigitSum(int n){
        N = n;
        sumOfDigits = 0;
    }
    public void calculate(){
        factorialValue = Factorial.bigFact(N);
        String digits = factorialValue.toString();

        for (int i = 0; i < digits.length(); i++) {
            sumOfDigits += Character.getNumericValue(digits.charAt(i));
        }
    }

    @Override
    public String toString(){
        return "the sum of the digits of the factorial of the number "+N+" is: " +sumOfDigits;
    }

    public static void main(String[] args) {
        int n = 100;
        FactorialDigitSum fact = new FactorialDigitSum(n);
        fact.calculate();
        System.out.println(fact);

        System.out.println("and that's a fact (sorry)");
    }
}
