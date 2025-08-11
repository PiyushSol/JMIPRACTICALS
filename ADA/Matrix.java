public class Matrix {
    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 3, 4 } };
        int[][] b = { { 5, 6 }, { 7, 8 } };
        int[][] res1 = product1(a, b, 2);

          for (int[] r : res1) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        int[][] res = product2(a, b, 2);

      
        for (int[] r : res) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    //Normal Multiplication
    public static int[][] product1(int[][] a, int[][] b, int n) {
        if (n % 2 != 0) {
            System.out.println("Order should be a power of 2");
            return new int[][] { { -1, -1 } };
        }
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    //Divide and Conquer Approach
    public static int[][] product2(int[][] a, int[][] b, int n) {
        int c[][] = new int[n][n];
        if (n == 1) {
            c[0][0] = a[0][0] * b[0][0];
            return c;
        }

        int a11[][] = new int[n / 2][n / 2];
        int a12[][] = new int[n / 2][n / 2];
        int a21[][] = new int[n / 2][n / 2];
        int a22[][] = new int[n / 2][n / 2];

        int b11[][] = new int[n / 2][n / 2];
        int b12[][] = new int[n / 2][n / 2];
        int b21[][] = new int[n / 2][n / 2];
        int b22[][] = new int[n / 2][n / 2];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                a11[i][j] = a[i][j];
                a12[i][j] = a[i][j + n / 2];
                a21[i][j] = a[i + n / 2][j];
                a22[i][j] = a[n / 2 + i][n / 2 + j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                b11[i][j] = b[i][j];
                b12[i][j] = b[i][j + n / 2];
                b21[i][j] = b[i + n / 2][j];
                b22[i][j] = b[n / 2 + i][n / 2 + j];
            }
        }

        int c11[][] = add(product2(a11, b11, n / 2), product2(a12, b21, n / 2),n/2);
        int c12[][] = add(product2(a11, b12, n / 2), product2(a12, b22, n / 2),n/2);
        int c21[][] = add(product2(a21, b11, n / 2), product2(a22, b21, n / 2),n/2);
        int c22[][] = add(product2(a21, b12, n / 2), product2(a22, b22, n / 2),n/2);

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                c[i][j] = c11[i][j];
                c[i][j + n / 2] = c12[i][j];
                c[i + n / 2][j] = c21[i][j];
                c[i + n / 2][j + n / 2] = c22[i][j];
            }
        }
        return c;
    }

    public static int[][] add(int a[][], int b[][], int n) {
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    //Strassen Multiplication
    //  public static int[][] product3(int[][] a, int[][] b, int n) {
     
    //     int c[][] = new int[n][n];
    //     if (n == 1) {
    //         c[0][0] = a[0][0] * b[0][0];
    //         return c;
    //     }

    //     int a11[][] = new int[n / 2][n / 2];
    //     int a12[][] = new int[n / 2][n / 2];
    //     int a21[][] = new int[n / 2][n / 2];
    //     int a22[][] = new int[n / 2][n / 2];

    //     int b11[][] = new int[n / 2][n / 2];
    //     int b12[][] = new int[n / 2][n / 2];
    //     int b21[][] = new int[n / 2][n / 2];
    //     int b22[][] = new int[n / 2][n / 2];

    //     for (int i = 0; i < n / 2; i++) {
    //         for (int j = 0; j < n / 2; j++) {
    //             a11[i][j] = a[i][j];
    //             a12[i][j] = a[i][j + n / 2];
    //             a21[i][j] = a[i + n / 2][j];
    //             a22[i][j] = a[n / 2 + i][n / 2 + j];
    //         }
    //     }

    //     for (int i = 0; i < n / 2; i++) {
    //         for (int j = 0; j < n / 2; j++) {
    //             b11[i][j] = b[i][j];
    //             b12[i][j] = b[i][j + n / 2];
    //             b21[i][j] = b[i + n / 2][j];
    //             b22[i][j] = b[n / 2 + i][n / 2 + j];
    //         }
    //     }

    //     int c11[][] = add(product2(a11, b11, n / 2), product2(a12, b21, n / 2),n/2);
    //     int c12[][] = add(product2(a11, b12, n / 2), product2(a12, b22, n / 2),n/2);
    //     int c21[][] = add(product2(a21, b11, n / 2), product2(a22, b21, n / 2),n/2);
    //     int c22[][] = add(product2(a21, b12, n / 2), product2(a22, b22, n / 2), n / 2);
        
        
    // }
}
