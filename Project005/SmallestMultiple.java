package Project005;

import HelperPackage.GCD;

/**2520 is the smallest number that can be divided by
 * each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly
 * divisible by all of the numbers from 1 to 20?*/

public class SmallestMultiple {
    int multiple;
    int N;
    public SmallestMultiple(int n){
        N = n;
        multiple = 1;
    }
    public void calculate(){
        for (int i = 1; i <= N; i++) {
            multiple = GCD.findGCD(multiple, i);
        }
    }
    public int getMultiple(){
        return multiple;
    }

    public static void main(String[] args) {
        int n = 20;
        SmallestMultiple multi = new SmallestMultiple(n);
        multi.calculate();
        System.out.println("Smallest multiple of numbert up to " + n
                            + " that is divisible by every number up to that, is: ");
    }
}
