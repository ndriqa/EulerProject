package Project021;

/**Let d(n) be defined as the sum of proper divisors of n
 * (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable
 * pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
 * 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * @author ndriqa
 * */

public class AmicableNumbers {

    private int MAX;
    private int SUM;

    public AmicableNumbers(int max){
        MAX = max;
        SUM = 0;
    }

    public void calculate(){
        for (int i = 1; i <= MAX; i++) {
            for (int j = i+1; j <= MAX; j++) {
                if (divisorSum(i) == j && divisorSum(j) == i && i != j){
                    SUM += i + j;
                    System.out.println(""+i+" - " + j);
                }
            }
        }
    }

    private int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n%i == 0){
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public String toString(){
        return "the sum of amicable numbers up to " + MAX + " is: " + SUM;
    }

    public static void main(String[] args) {
        int max = 10000;

        AmicableNumbers amic = new AmicableNumbers(max);
        amic.calculate();
        System.out.println(amic);
    }
}
