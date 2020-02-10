/**Palindromes class is a helper class that holds useful
 * methods to check if a number or a string is palindrome or not.
 *
 * A palindrome is a text that reads the same forwards and backwards
 * ie. kimik, aga, 12321, 432343234
 *
 * @author ndriqa
 */

package HelperPackage;

public class Palindromes {
    public static boolean isPalindrome(int a){
        return isPalindrome(""+a);
    }
    public static boolean isPalindrome(String a){
        boolean temp = true;
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length()-1-i)){
                temp = false;
            }
        }

        return temp;
    }
}
