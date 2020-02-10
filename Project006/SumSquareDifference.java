package Project006;

/**The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1+2+...+10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the
 * first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first
 * one hundred natural numbers and the square of the sum
 *
 * @author ndriqa*/

public class SumSquareDifference {
    int N;

    int sumOfSquares;
    int squareOfSum;

    int difference; //sumOfSquares - squareOfSum

    public SumSquareDifference(int n){
        N = n;
        sumOfSquares = 0;
        squareOfSum = 0;
    }
    public void calculate(){
        int tempSum = 0;
        for (int i = 1; i <= N; i++) {
            tempSum += i;
            sumOfSquares += i*i;
        }

        squareOfSum = tempSum * tempSum;

        difference = Math.abs(sumOfSquares - squareOfSum);

        System.out.println("Difference between the sum of the squares and square of the \n" +
                            "sum of the numbers up to N = " + N + " is: " + difference);
    }

    public static void main(String[] args) {
        int n = 100;
        SumSquareDifference s = new SumSquareDifference(n);
        s.calculate();
    }

}
