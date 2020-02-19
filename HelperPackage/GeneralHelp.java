package HelperPackage;

public class GeneralHelp {
    public static int[] divisors(int n){
        String temp = "1";
        for (int i = 2; i <= n/2; i++) {
            if (n%i == 0){
                temp = temp + "," + i;
            }
        }
        String[] divString = temp.split(",");
        int[] div = new int[divString.length];
        for (int i = 0; i < divString.length; i++) {
            div[i] = new Integer(divString[i]);
        }
        return div;
    }
}
