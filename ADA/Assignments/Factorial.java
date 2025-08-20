public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int[] factorial(int num){
        double n = 0;
        for(int i=2;i<=num;i++){
            n+= Math.log10(i);
        }
        int size= (int)(Math.floor(n)+1) ;
        int[] res = new int[size];
        for(int i=2;i<=num;i++){
            int carry=0;
            
        }
    }
}
