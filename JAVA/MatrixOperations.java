import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    //Code to create matrix with random values
    private static void createMatrix(int m[][], Random random) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = random.nextInt(10);
            }
        }
    }

    //Code to Display the created Matrix
    private static void displayMatrix(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Code to perform addition of two matrices
    private static void addMatrices(int m1[][], int m2[][], int res[][]) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
    }

    //Code to perform subtraction of two matrices
    private static void subMatrices(int m1[][], int m2[][], int res[][]) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                res[i][j] = m1[i][j] - m2[i][j];
            }
        }
    }

    private static void multiplyMatrices(int m1[][], int m2[][], int res[][]) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                res[i][j] = 0;
                for (int k = 0; k < m1[i].length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
    }


    public static void main(String[] args) {
        int rows, cols;
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the the no. of rows :");
        rows = scan.nextInt();
        System.out.println("Enter the the no. of cols :");
        cols = scan.nextInt();
        int m1[][] = new int[rows][cols];
        int m2[][] = new int[rows][cols];
        int add[][] = new int[rows][cols];
        int diff[][] = new int[rows][cols];
        int prod[][] = new int[rows][cols];

        //Creating and Populating the matrices
        createMatrix(m1, random);
        System.out.println("The Matrix 1 is : ");
        displayMatrix(m1);
        createMatrix(m2, random);
        System.out.println("The Matrix 2 is : ");
        displayMatrix(m2);

        //Performing Operations
        //1. Addition
        addMatrices(m1, m2, add);
        System.out.println("------------Matrices After Addition --------------");
        displayMatrix(add);

        //2. Subtraction
        subMatrices(m1, m2, diff);
        System.out.println("------------Matrices After Difference --------------");
        displayMatrix(diff);

        //3. Multiplication
        multiplyMatrices(m1, m2, prod);
        System.out.println("------------Matrices After Multiplication --------------");
        displayMatrix(prod);

        scan.close();
    }

}

