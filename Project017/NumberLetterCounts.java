package Project017;
/**If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were
 * written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens.
 * For example, 342 (three hundred and forty-two)
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 *
 * @author ndriqa
 * */

public class NumberLetterCounts {
    final int THOUSAND = 1000;
    final int HUNDRED = 100;
    final int TEN = 10;

    String[] tenNums;
    String[] fromTenToTwenty;
    String[] tens;
    String[] tenPow;

    int MAX;
    int sum;

    public NumberLetterCounts(int m){
        initializeNums();
        MAX = m;
    }

    void initializeNums() {
        tenNums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        fromTenToTwenty = new String[]{
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        tens = new String[]{
                "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };
        tenPow = new String[]{"hundred", "thousand"};
    }

    String getNumString(int n){
        String temp = "";
        int N = n;
            if(N/THOUSAND > 0){
                temp = temp + tenNums[N/THOUSAND] + tenPow[1];
                N = N % THOUSAND;
            }
            if(N/HUNDRED > 0){
                temp = temp + tenNums[N/HUNDRED] + tenPow[0];
                N = N % HUNDRED;
                if (N > 0){
                    temp = temp + "and";
                }
            }
            if(N > 19){
                temp = temp + tens[N/TEN];
                N = N % TEN;
                if (N != 0){
                    temp = temp + tenNums[N];
                }
            } else if ( N > 9){
                temp = temp + fromTenToTwenty[N % TEN];
            } else {
                if (N != 0) {
                    temp = temp + tenNums[N];
                }
            }
        return temp;
    }

    public void calculate(){
        for (int i = 1; i <= MAX; i++) {
            sum += getNumString(i).length();
        }
    }

    @Override
    public String toString(){
        return "there is a total of " + sum + " letters that are used to write out \n" +
                "all numbers from 1 to " + MAX;
    }

    public static void main(String[] args) {
        int max = 1000;
        NumberLetterCounts num = new NumberLetterCounts(max);
        num.calculate();
        System.out.println(num);
    }

}
