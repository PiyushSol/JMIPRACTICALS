import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        byte[] res = factorial(1000);
        long end = System.currentTimeMillis();
        System.out.println("Time take : "+(end-start)+" ms.");
        System.out.println(Arrays.toString(res));
        System.out.println(res.length);
    }

    public static byte[] factorial(int num){
        double n = 0;
        for(int i=2;i<=num;i++){
            n+= Math.log10(i);
        }
        int size= (int)(Math.floor(n)+1) ;
        byte[] res = new byte[size];
        res[size - 1] = 1;
        int k = size - 1;
        for (int i = 2; i <= num; i++) {
            int carry = 0;
            for (int j = size - 1; j>=k; j--) {
                int x = res[j] * i + carry;
                res[j] = (byte) (x % 10);
                carry = x / 10;
            }
            while (carry != 0) {
                k = k - 1;
                res[k] = ((byte) (carry % 10));
                carry /= 10;
            }
            
        }
        return res;
    }
}
