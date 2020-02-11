package Project004;

import HelperPackage.Palindromes;

/**A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author ndriqa
 * */

public class LargestPalindromeProduct {
    int maxA, maxB;
    int largestPalinProd;

    public LargestPalindromeProduct(int a, int b){
        maxA = a;
        maxB = b;
        largestPalinProd = 1;
    }

    public void calculate(){
        for (int i = 0; i < maxA; i++) {
            for (int j = 0; j < maxB; j++) {
                int tempProd = i * j;
                if (Palindromes.isPalindrome(tempProd) && tempProd > largestPalinProd){
                    largestPalinProd = tempProd;
                }
            }
        }
    }

    @Override
    public String toString(){
        return ("Largest palindrome product is: " + largestPalinProd);
    }

    public static void main(String[] args) {
        int a = 1000;
        int b = a;

        LargestPalindromeProduct palindrome = new LargestPalindromeProduct(a, b);
        palindrome.calculate();
        System.out.println(palindrome);
    }
}
