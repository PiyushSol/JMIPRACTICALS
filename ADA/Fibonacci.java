public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("-".repeat(20));
        long start = System.currentTimeMillis();

        for (int i = 5; i <= 100; i++) {
            System.out.print(fibo_rec(i)+ "\t");
        }
        long end = System.currentTimeMillis();
        System.out.println("Recursive 1 time : " + (end - start) + " ms");
        System.out.println("-".repeat(20));

        long start1 = System.currentTimeMillis();
        for (int i = 5; i <= 100; i++) {
            System.out.print(fibo_rec2(i)+ "\t");
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Recursive 2 time : " + (end1 - start1)+ " ms");
        System.out.println("-".repeat(20));

        long start3 =System.currentTimeMillis();
        for (int i = 5; i <= 100; i++) {
            System.out.print(fibo_Iterative(i)+ "\t");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("Iterative time : " + (end3 - start3) + " ms");
        System.out.println("-".repeat(20));

    }

    //Iterative
    public static int fibo_Iterative(int n) {
        int n1 = 1, n2 = 1;
        for (int i = 3; i <= n; i++) {
            int fib = n1 + n2;
            n1 = n2;
            n2 = fib;
        }
        return n2;
    }

    //Recursive
    public static int fibo_rec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo_rec(n - 1) + fibo_rec(n - 2);
    }

    public static int fibo_rec2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo_rec2(n - 2) + fibo_rec2(n - 1);
    }
}

