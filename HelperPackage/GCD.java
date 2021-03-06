package HelperPackage;

public class GCD {

    /**findGCD uses euclidean algorithm in the recursive form*/
    public static int findGCD(int a, int b){
        if(b == 0){
            return a;
        } else {
            return findGCD(b, a%b);
        }
    }
    public static int smallestMultiple(int a, int b){
        return (a * b)/(findGCD(a, b));
    }

    public static long findGCD(long a, long b){
        if(b == 0){
            return a;
        } else {
            return findGCD(b, a%b);
        }
    }
    public static long smallestMultiple(long a, long b){
        return (a * b)/(findGCD(a, b));
    }
}
