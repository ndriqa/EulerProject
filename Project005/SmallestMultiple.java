package Project005;

import HelperPackage.GCD;

/**2520 is the smallest number that can be divided by
 * each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly
 * divisible by all of the numbers from 1 to 20?*/

public class SmallestMultiple {
    long multiple;
    int N;

    public SmallestMultiple(int n){
        N = n;
        multiple = 1l;
    }
    public void calculate(){
        for (int i = 1; i <= N; i++) {
            multiple = GCD.smallestMultiple(multiple, i);
        }

        System.out.println("Smallest multiple of numbert up to " + N
                + " that is divisible by every number up to that, is: " + getMultiple());

    }
    public long getMultiple(){
        return multiple;
    }

    public static void main(String[] args) {
        int n = 20;
        SmallestMultiple multi = new SmallestMultiple(n);
        multi.calculate();
    }
}
