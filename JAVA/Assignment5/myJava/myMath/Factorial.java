package myJava.myMath;

import java.math.BigInteger;

public class Factorial {
    //Factorial function to calculate for small numbers
    public static int fact(int n){
        int fact =1;
        for(int i=1;i<=n;i++){
            fact *=i;
        }
        return fact;
    }

    //Factorial function to handle BigNumbers
    public static BigInteger factB(int n){
        BigInteger fact= BigInteger.ONE;
        for(int i=1;i<=n;i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

}
