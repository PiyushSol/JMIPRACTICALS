import java.util.ArrayList;
import java.util.List;

public class LCS {
    public static void main(String[] args) {
        String X ="ABCBDAB";
        String Y = "BDCABA";
        List<int[][]> ans = lcs(X,Y);

        System.out.print("LCS using direction matrix (b): ");
        print_LCS(ans.get(1), X, X.length(), Y.length());
        System.out.println();

        System.out.print("LCS using length matrix (c): ");
        print_LCS1(ans.get(0), X, Y, X.length(), Y.length());
        System.out.println();
    }

    public static List<int[][]> lcs(String X , String Y){
        List<int[][]> ans =  new ArrayList<>();
        int m = X.length();
        int n=Y.length();
        int c[][] =new int[m+1][n+1];
        int b[][] = new int[m+1][n+1];
        for(int i=0;i<m;i++){c[i][0]=0;}
        for(int j=0;j<n;j++){c[0][j]=0;}
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(X.charAt(i-1)== Y.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]=1;
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]=-1;
                }else{
                    c[i][j]= c[i][j-1];
                    b[i][j]=0;
                }
            }
        }
        ans.add(c);
        ans.add(b);
        return ans;
    }

    //Printing using b matrix
    public static void print_LCS(int b[][],String X , int i, int j){
        if(i==0||j==0)return;
        if(b[i][j]==1){
            print_LCS(b,X,i-1,j-1);
            System.out.print(X.charAt(i-1)+" ");
        } else if (b[i][j]== -1) {
            print_LCS(b,X,i-1,j);
        }else{
            print_LCS(b,X,i,j-1);
        }
    }

    //Printing using C matrix
    public static void print_LCS1(int c[][],String X,String Y ,int i , int j){
        if(i==0||j==0)return;
        if(X.charAt(i-1)==Y.charAt(j-1)){
            print_LCS1(c,X,Y,i-1,j-1);
            System.out.print(X.charAt(i-1)+" ");
        } else if (c[i-1][j]>=c[i][j-1]) {
            print_LCS1(c,X,Y,i-1,j);
        }else{
            print_LCS1(c,X,Y,i,j-1);
        }
    }
}
