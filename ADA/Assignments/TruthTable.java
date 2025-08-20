import java.util.Arrays;

public class TruthTable {
    public static void main(String[] args) {
        truthTable(2);
    }

    //Print Truth table of n variables
    public static void truthTable(int n){
        boolean table[]= new boolean[n];
        for(int i=0;i<n;i++){
            table[i]=false;
        }
        for(int i=0; i<=Math.pow(2,n)-1;i++){
            int m=i,j=n-1;
            while(m!=0){
                if(m%2==0){
                    table[j]=false;
                }
                else{
                    table[j]=true;
                }
                m=(int) Math.floor(m/2);
                j=j-1;
            }
            System.out.println(Arrays.toString(table));
        }
    }
}
