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
