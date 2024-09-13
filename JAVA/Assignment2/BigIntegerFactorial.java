import java.math.BigInteger;
import java.util.*;
public class BigIntegerFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int num = scanner.nextInt();
        BigInteger fact = BigInteger.ONE;
        for(int i=1; i<=num;i++){
            fact =fact.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println("The Factorial is : "+fact);
    }
}
