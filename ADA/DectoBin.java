import java.util.Arrays;

public class DectoBin {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(1234));
        System.out.println(Arrays.toString(toBinary(1234)));
    }

    public static long decimalToBinary(int d){
        if(d<=0){
            System.out.println("Must be a postive integer!");
            return -1L;
        }
        long b =0;
        long p=1;
        while(d!=0){
            b = b+ (d%2)*p;
            p = p*10;
            d =(int) Math.floor(d/2);
        }
        return b;
    }

    public static byte[] toBinary(int d){
        int n = (int)(Math.log(d)/Math.log(2))+1;
        byte b[]=new byte[n];
        for(int i=n-1;i>=0;i--){
            b[i]= (byte) (d%2);
            d/=2;
        }
        return b;
    }
}
