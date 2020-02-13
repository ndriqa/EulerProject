package Project015;

import java.math.BigInteger;

/**Starting in the top left corner of a 2×2 grid,
 * and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * @author ndriqa
 * */
public class LatticePaths {
    int horizontal;
    int vertical;

    BigInteger ways;

    public LatticePaths(int x, int y){
        horizontal = x;
        vertical = y;
        ways = new BigInteger("1");
    }
    public void calculate (){
        /**
         * This is more of a math problem, thus, I'm going to use a formula
         * which true for any grid x*y.
         * This formula can easily be proven by mathematical induction
         * f(x, y) = (x+y)! / (x! * (y-x)!)
         *
         * Lattice paths problem can be expressed like a combinatorics problem
         * */
        ways = ways.multiply(factoriel(horizontal+vertical));

        BigInteger denominator = new BigInteger(String.valueOf(factoriel(vertical)));
        denominator = denominator.multiply(factoriel(horizontal));

        ways = ways.divide(denominator);
    }
    public BigInteger factoriel(int n){
        BigInteger temp = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            temp = temp.multiply(BigInteger.valueOf(i));
        }
        return temp;
    }

    @Override
    public String toString(){
        return "In a grid with dimensions " + horizontal + "x" + vertical + ", \nthere are " +
                ways + " ways to go from the top left corner to the bottom right one.";
    }

    public static void main(String[] args) {
        int x = 20;
        int y = 20;

        LatticePaths paths = new LatticePaths(x, y);
        paths.calculate();
        System.out.println(paths);
    }
}
