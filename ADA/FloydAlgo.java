public class FloydAlgo {
    public static void floyd(int [][]w ,int n){
        int[][] d = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                d[i][j]=w[i][j];
            }
        }
        int p[][]= new int[n][n];
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE
                            && d[i][j]>(d[i][k]+d[k][j])){
                        d[i][j]= d[i][k]+d[k][j];
                        p[i][j]=k;
                    }
                }
            }
        }

        printPath(1,3,p);
    }

    public static void printPath(int s , int e,int [][]p){
        System.out.print("V"+s+"->");
        path(s,e,p);
        System.out.print("V"+e);
    }

    public static void path(int s, int e,int [][]p){
        if(p[s][e]!=0){
            path(s,p[s][e],p);
            System.out.print("V"+p[s][e]+"->");
            path(p[s][e],e,p);
        }
    }

    public static void main(String[] args) {
        int w[][]={
                {0,1,6,5},
                {2,0,2,Integer.MAX_VALUE}
                ,{Integer.MAX_VALUE,1,0,1},
                {3,Integer.MAX_VALUE,Integer.MAX_VALUE,0}
        };
        floyd(w,4);
    }
}
