public class NcR{
    public static void main(String[] args) {
        System.out.println("-".repeat(30));
        long start = System.currentTimeMillis();
        System.out.println(binC(12, 6));
        long end = System.currentTimeMillis();
        System.out.println("Divide and Conquer takes " + (end - start) + " ms.");
        System.out.println("-".repeat(30));

         System.out.println("-".repeat(30));
        long start1 = System.currentTimeMillis();
        System.out.println(binC1(12, 6));
        long end1 = System.currentTimeMillis();
        System.out.println("2D array (n+1) takes " + (end1 - start1) + " ms.");
        System.out.println("-".repeat(30));

         System.out.println("-".repeat(30));
        long start2 = System.currentTimeMillis();
        System.out.println(binC2(12, 6));
        long end2 = System.currentTimeMillis();
        System.out.println("2D triangular array takes " + (end2 - start2) + " ms.");
        System.out.println("-".repeat(30));

         System.out.println("-".repeat(30));
        long start3 = System.currentTimeMillis();
        System.out.println(binC3(12, 6));
        long end3 = System.currentTimeMillis();
        System.out.println("2D trapezium array takes " + (end3 - start3) + " ms.");
        System.out.println("-".repeat(30));

         System.out.println("-".repeat(30));
        long start4 = System.currentTimeMillis();
        System.out.println(binC4(12, 6));
        long end4 = System.currentTimeMillis();
        System.out.println("1D array takes " + (end4 - start4) + " ms.");
        System.out.println("-".repeat(30));
    }
    
    //Using Divide and Conquer Algo
    public static int binC(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        return binC(n - 1, r - 1) + binC(n - 1, r);
    }

    //Using DP and matrix of n+1 size
    public static int binC1(int n, int r) {
        int[][] bin = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    bin[i][j] = 1;
                } else {
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
                }
            }
        }
        return bin[n][r];
    }
    
    //Using DP and 2D array of triangular type
    public static int binC2(int n, int r) {
        int[][] bin = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            bin[i] = new int[i + 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    bin[i][j] = 1;
                } else {
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
                }
            }
        }

        // for (int[] row : bin) {
        //     for (int el : row) {
        //         System.out.print(el + " ");
        //     }
        //     System.out.println();
        // }
        return bin[n][r];

    }

    //Using 2D of trapezium type
    public static int binC3(int n, int r) {
        int[][] bin = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            bin[i] = new int[i + 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    bin[i][j] = 1;
                } else {
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
                }
            }
        }

        // for (int[] row : bin) {
        //     for (int el : row) {
        //         System.out.print(el + " ");
        //     }
        //     System.out.println();
        // }
        return bin[n][r];

    }

    //Using Single 1D array
    public static int binC4(int n, int r) {
        int[] bin = new int[r + 1];
        bin[0] = 1;
        for (int i = 1; i <=n; i++) {
            for (int j = Math.min(i, r); j >= 1; j--) {
                if (j == 0 || j == i) {
                    bin[j] = 1;
                }
                else {
                 bin[j] = bin[j - 1] + bin[j];
                }
               
            }
        }
        return bin[r];
    }
}