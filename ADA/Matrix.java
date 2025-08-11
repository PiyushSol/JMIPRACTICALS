public class Matrix {
    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 3, 4 } };
        int[][] b = { { 5, 6 }, { 7, 8 } };
        long s1 = System.currentTimeMillis();

        int[][] res1 = product1(a, b, 2);
        long e1 = System.currentTimeMillis();
        System.out.println("Execution Time for Direct Product: " + (e1 - s1) + " ms.");
        for (int[] r : res1) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        long s2 = System.currentTimeMillis();
        int[][] res2 = product2(a, b, 2);
        long e2 = System.currentTimeMillis();
        System.out.println("Execution Time for Divide and Conquer Product: " + (e2 - s2) + " ms.");

        for (int[] r : res2) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        long s3 = System.currentTimeMillis();
        int[][] res3 = product3(a, b, 2);
        long e3 = System.currentTimeMillis();
        System.out.println("Execution Time for Strassen Product: " + (e3 - s3) + " ms.");
        for (int[] r : res3) {
            for (int e : r) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

    }

    // Normal Multiplication
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

    // Divide and Conquer Approach
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

        int c11[][] = add(product2(a11, b11, n / 2), product2(a12, b21, n / 2), n / 2);
        int c12[][] = add(product2(a11, b12, n / 2), product2(a12, b22, n / 2), n / 2);
        int c21[][] = add(product2(a21, b11, n / 2), product2(a22, b21, n / 2), n / 2);
        int c22[][] = add(product2(a21, b12, n / 2), product2(a22, b22, n / 2), n / 2);

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

    public static int[][] sub(int a[][], int b[][], int n) {
        int res[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }

    // Strassen Multiplication
    public static int[][] product3(int[][] a, int[][] b, int n) {

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

        int m1[][] = product3(add(a11, a22, n / 2), add(b11, b22, n / 2), n / 2);
        int m2[][] = product3(add(a21, a22, n / 2), b11, n / 2);
        int m3[][] = product3(a11, sub(b12, b22, n / 2), n / 2);
        int m4[][] = product3(a22, sub(b21, b11, n / 2), n / 2);
        int m5[][] = product3(add(a11, a12, n / 2), b22, n / 2);
        int m6[][] = product3(sub(a21, a11, n / 2), add(b11, b12, n / 2), n / 2);
        int m7[][] = product3(sub(a12, a22, n / 2), add(b21, b22, n / 2), n / 2);

        int c11[][] = add(add(sub(m4, m5, n / 2), m7, n / 2), m1, n / 2);
        int c12[][] = add(m3, m5, n / 2);
        int c21[][] = add(m2, m4, n / 2);
        int c22[][] = add(add(sub(m3, m2, n / 2), m6, n / 2), m1, n / 2);

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
}
