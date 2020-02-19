package Project023;

import HelperPackage.GeneralHelp;
import java.util.LinkedList;

/**A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors
 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n
 * and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than
 * 28123 can be written as the sum of two abundant numbers. However, this upper
 * limit cannot be reduced any further by analysis even though it is known that
 * the greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of
 * two abundant numbers.
 *
 * @author ndriqa
 * */

public class NonAbundantSums {
    private int MAX;
    private int[] abundant;
    private boolean[] areValid;
    private int SUM;


    public NonAbundantSums(int max){
        MAX = max;
        findAbundants();
        areValid = new boolean[MAX];
        for (int i = 0; i < MAX; i++) {
            areValid[i] = true;
        }
        SUM = 0;
    }

    private void findAbundants() {
        LinkedList<Integer> abunds = new LinkedList<>();
        for (int i = 6; i < MAX; i++) {
            int[] divs = GeneralHelp.divisors(i);
            int sumOfDivs = 0;
            for (int div : divs) {
                sumOfDivs += div;
            }
            if (sumOfDivs > i){
                abunds.add(i);
            }
        }

        abundant = new int[abunds.size()];
        for (int i = 0; i < abunds.size(); i++) {
            abundant[i] = abunds.get(i);
        }
    }

    public void calculate(){
        for (int i = 0; i < abundant.length; i++) {
            for (int j = i; j < abundant.length; j++) {
                int tempSum = abundant[i] + abundant[j];
                if (tempSum < MAX){
                    areValid[tempSum] = false;
                }
            }
            //System.out.println("i = " + i);
        }

        for (int i = 0; i < areValid.length; i++) {
            if (areValid[i]){
                SUM += i;
            }
        }
        System.out.println();
    }

    @Override
    public String toString(){
        return "the sum of non abundant numbers is: " + SUM;
    }

    public static void main(String[] args) {
        int max = 28123;
        NonAbundantSums nona = new NonAbundantSums(max);
        nona.calculate();
        System.out.println(nona);
    }
}
