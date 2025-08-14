public class ChainMatrix {
    public static void main(String[] args){
        int n =2;
        int[] d = {2,3,4};
        int[][] P = new int[n+1][n+1];
        minMul(d,P,n);
        printOrder(1,n,P,n);

    }

    public static void minMul(int []d , int P[][] , int n){
        int M[][] = new int[n+1][n+1];
        for(int i=1;i<n;i++){
            M[i][i] =0;
        }
        for(int diagonal = 1 ; diagonal<=n;diagonal++){
            for(int i=1; i<=n-diagonal;i++){
                int j = i+diagonal;
                M[i][j] = M[i][j]+M[i+1][j]+d[i-1]*d[i]*d[j];
                P[i][j]=i;
                for(int k=i+1;k<j-1;k++){
                    if((M[i][k]+M[k+1][j]+d[i-1]*d[k]*d[j])<M[i][j]){
                        M[i][j]=M[i][k]+M[k+1][j]+d[i-1]*d[k]*d[j];
                        P[i][j]=k;
                    }
                }
            }
        }
    }

    public static void printOrder(int i, int j, int[][]p,int n){
        if(i==j){
            System.out.print("A"+j);
        }
        else{
            int k = p[i][j];
            System.out.print("(");
            printOrder(i,k,p,n);
            printOrder(k+1,j,p,n);
            System.out.print(")");
        }
    }
}
