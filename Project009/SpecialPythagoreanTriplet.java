package Project009;
/**A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * */
public class SpecialPythagoreanTriplet {
    int a, b, c;
    int sumABC;

    public SpecialPythagoreanTriplet(int sumabc){
        sumABC = sumabc;
        a = b = c = 0;
    }
    public void calculate(){
        /**By having a<b<c and a+b+c=1000, we conclude that the smallest value c
         * can have is 334 since 332<333<334 and 332+333+334=999 ≈ 1000
         *
         * So, we dont need c to be lower than at least 333, which is a lower bound of c,
         * although not infimum, but helps avoid hard coding.
         * */
        for (int i = sumABC/3; i < sumABC; i++){
            for(int j = 1; j < i; j++){
                for(int k = 0; k < j; k++){
                    if(i+j+k == sumABC){
                        if(k*k + j*j == i*i){
                            a = k;
                            b = j;
                            c = i;
                        }
                    }
                }
            }
        }

        System.out.println("The special pythagorean triplet is ("
                            + a + ", " + b + ", " + c + ") : ");
        System.out.println("-----------------------------------------------");
        System.out.println("a + b + c = " + a +" + "+ b +" + "+ c + " = " + (a+b+c));
        System.out.println("-----------------------------------------------");
        System.out.println("a^2 + b^2 = " + a*a +" + "+ b*b +" = "+ c*c + " = c^2");
        System.out.println("-----------------------------------------------");
        System.out.println("a * b * c = " + a*b*c);
    }

    public static void main(String[] args) {
        int sum = 1000;
        SpecialPythagoreanTriplet pyth = new SpecialPythagoreanTriplet(sum);
        pyth.calculate();
    }
}
