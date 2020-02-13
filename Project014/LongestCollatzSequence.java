package Project014;
/**The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * @author ndriqa
 * */

public class LongestCollatzSequence {
    long finalTerms;
    int startingNumber;

    int MAX;

    public LongestCollatzSequence(int max){
        MAX = max;
    }

    public void calculate(){
        for (int i = 1; i < MAX; i++) {

            long temp = collatz(i);
            //System.out.println("we're now at number " + i);

            if(temp > finalTerms){
                finalTerms = temp;
                startingNumber = i;
                System.out.println(""+startingNumber+" produces "+finalTerms+" terms");
            }
        }
    }

    public long collatz(int n){
        long chainCount = 1;
        long N = n;
        while (N != 1){
            chainCount++;

            if (N%2 == 0){
                N = N/2;
            } else {
                N = N*3 + 1;
            }
        }
        return chainCount;
    }

    @Override
    public String toString(){
        return "The longest chain with " + finalTerms + " terms is produced by the number: " + startingNumber;
    }

    public static void main(String[] args) {
        LongestCollatzSequence coll = new LongestCollatzSequence(1000000);
        coll.calculate();
        System.out.println(coll);
    }
}
