package HelperPackage;

public class GeneralHelp {
    public static int[] divisors(int n){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= n/2; i++) {
            if (n%i == 0){
                temp.append(",").append(i);
            }
        }
        String[] divString = temp.toString().split(",");
        int[] div = new int[divString.length];
        for (int i = 0; i < divString.length; i++) {
            div[i] = new Integer(divString[i]);
        }

        return div;
    }
}
