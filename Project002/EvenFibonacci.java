package Project002;
/**Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 *
 * @author ndriqa*/

public class EvenFibonacci {
    int fibonaci1;
    int fibonaci2;

    public EvenFibonacci(int f1, int f2){
        fibonaci1 = f1;
        fibonaci2 = f2;
    }

    public int calculate(int max){
        int sum = 0;
        if(fibonaci1%2==0) {
            sum += fibonaci1;
        } else {
            sum += fibonaci2;
        }
        while (fibonaci1+fibonaci2 < max){
            int currentFib = fibonaci1 + fibonaci2;
            if(currentFib%2 == 0){
                sum += currentFib;
            }
            fibonaci1 = fibonaci2;
            fibonaci2 = currentFib;
        }
        return sum;
    }

    public static void main(String[] args) {
        int maximum = 4000000;
        EvenFibonacci ef = new EvenFibonacci(1, 2);
        int sumOfEvenFibbonaci = ef.calculate(maximum);
        System.out.println(sumOfEvenFibbonaci);
    }
}
