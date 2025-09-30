import java.util.*;

public class ConvexHull {
    static class Point {
        int x;
        int y;

        Point() {
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void read(Point a[], int n) {
            System.out.println("Enter the n points : ");
            Scanner s = new Scanner(System.in);
            System.out.println("Enter X and Y coordinates of Point P:");
            for (int i = 0; i < n; i++) {
                a[i].x = s.nextInt();
                a[i].y = s.nextInt();
            }
        }

        public void print(Point a[], int n) {
            System.out.println("The Points are : ");
            for (int i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }

        public double dist(Point p2) {
            return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
        }

        public String toString() {
            String s = "(" + this.x + " , " + this.y + ")";
            return s;
        }
    }

    //Convex Hull using Brute Force
    public static void getConvexHull(Point p[], int n) {
        List<Point> hullPoints = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Point p_i = p[i];
                Point p_j = p[j];

                int a = p_j.y - p_i.y;
                int b = p_i.x - p_j.x;
                int c = a * p_i.x + b * p_i.y;

                boolean flag = true;
                int oldSign = 0;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;

                    Point p_k = p[k];
                    int val = a * p_k.x + b * p_k.y;

                    int newSign;
                    if (val < c)
                        newSign = -1;
                    else if (val > c)
                        newSign = 1;
                    else
                        newSign = 0;

                    if (newSign == 0 && (p_i.dist(p_k) + p_k.dist(p_j) > p_i.dist(p_j) + 1e-6)) {
                        flag = false;
                        break;
                    }

                    if (newSign != 0) {
                        if (oldSign == 0) {
                            oldSign = newSign;
                        } else if (oldSign != newSign) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) {
                    if (!hullPoints.contains(p_i))
                        hullPoints.add(p_i);
                    if (!hullPoints.contains(p_j))
                        hullPoints.add(p_j);

                    System.out.println("Edge of Convex Hull: " + p_i + " -> " + p_j);
                }

            }
        }
    }

    public static void main(String[] args) {
        Point p = new Point();
        int n = 4;
        Point[] a = new Point[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Point();
        }
        p.read(a, n);
        p.print(a, n);
    }

}
