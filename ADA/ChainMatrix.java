public class ChainMatrix {
    public static void main(String[] args){
        int n =4;
        int[] d = {5, 2, 3, 4, 6};
//        minMul(d,n);
         optimisedMinMul(d,n);
    }


    //Opitimised Algorithm for chain matrix multilpication
    public static void optimisedMinMul(int []d , int n){
        int M[][] =new int[n][];
        int P[][] =new int[n-1][];
        for(int i=0;i<n;i++){
            M[i]=new int[n-i];
        }
        for(int i=0;i<n-1;i++){
            P[i]=new int[n-i-1];
        }
        //Printing matrix M
        for(int i=0;i<n;i++){
            M[i][0] = 0;
        }

        for(int diagonal=1;diagonal<n;diagonal++){
            for(int i=0;i<n-diagonal;i++){
                int j = i+diagonal;
                int k=i;
                M[i][j-i] =M[i][k-i]+M[k+1][j-(k+1)]+d[i]*d[k+1]*d[j+1];
                P[i][j-i-1]=k;
                for (k = i + 1; k <= j - 1; k++) {
                    if ((M[i][k-i] + M[k + 1][j-(k+1)] + d[i] * d[k+1] * d[j+1]) < M[i][j-i]) {
                        M[i][j-i] = M[i][k-i] + M[k + 1][j-(k+1)] + d[i] * d[k+1] * d[j+1];
                        P[i][j-i-1] = k;
                    }
                }
            }
        }

        System.out.println("Printing the matrix M for chain matrix : ");
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Printing the matrix P for chain matrix : ");
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P[i].length; j++) {
                System.out.print(P[i][j] + "\t");
            }
            System.out.println();
        }
        opitimisedprintOrder(0, n-1, P, n);
    }

    public static void minMul(int []d, int n){
        int M[][] = new int[n][n];
        int[][] P = new int[n][n];
        for(int i=0;i<n;i++){
            M[i][i] =0;
        }
        for (int diagonal = 1; diagonal < n; diagonal++) {
            for (int i = 0; i <= n - diagonal-1; i++) {
                int j = i + diagonal;
                int k = i;
                M[i][j] = M[i][k] + M[k + 1][j] + d[i] * d[k+1] * d[j+1];
                P[i][j] = k;
                for (k = i + 1; k <= j - 1; k++) {
                    if ((M[i][k] + M[k + 1][j] + d[i] * d[k+1] * d[j+1]) < M[i][j]) {
                        M[i][j] = M[i][k] + M[k + 1][j] + d[i] * d[k+1] * d[j+1];
                        P[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Printing the matrix M for chain matrix : ");
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Printing the matrix P for chain matrix : ");
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P.length; j++) {
                System.out.print(P[i][j] + "\t");
            }
            System.out.println();
        }
        printOrder(0, n-1, P, n);
    }

    public static void printOrder(int i, int j, int[][] p, int n) {
        if (i == j) {
            System.out.print("A" + j);
        } else {
            int k = p[i][j];
            System.out.print("(");
            printOrder(i, k, p, n);
            printOrder(k + 1, j, p, n);
            System.out.print(")");
        }
    }

      public static void opitimisedprintOrder(int i, int j, int[][]p,int n){
        if(i==j){
            System.out.print("A"+(i));
        }
        else{
            int k = p[i][j-i-1];
            System.out.print("(");
            opitimisedprintOrder(i,k,p,n);
            opitimisedprintOrder(k+1,j,p,n);
            System.out.print(")");
        }
    }
}


