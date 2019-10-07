package Project001;
/**Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author ndriqa*/

public class N001 {
    int sum;
    int max;

    public N001(int maxNumber){
        sum = 0;
        max = maxNumber;

        for(int i = 1; i < maxNumber; i++){
            if(isMultipleOfDenominator(i, 3)
                    || isMultipleOfDenominator(i, 5)){
                sum += i;
            }
        }
        System.out.println("The sum of all the multiples of 3 or 5 below 1000 is: "+ sum);
    }

    public boolean isMultipleOfDenominator(int numerator, int denominator){
        return ((numerator%denominator)==0);
    }

    public static void main(String[] args){
        new N001(1000);
    }
}
