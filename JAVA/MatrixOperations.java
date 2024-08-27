import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

       
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];
        int[][] diff = new int [rows][cols];
        int[][] prod = new int [rows][cols];

        populateMatrix(matrix1, random);
        populateMatrix(matrix2, random);

     
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);

      
        addMatrices(matrix1, matrix2, sum);
        System.out.println("Sum of matrices:");
        printMatrix(sum);

        difference(matrix1,matrix2,diff);
        System.out.println("Difference of matrices: ");
        printMatrix(diff);
        
        multiply(matrix1 ,matrix2 , prod);
        System.out.println("Product of two matrices: ");
        printMatrix(prod);
      

        scanner.close();
    }


    private static void populateMatrix(int[][] matrix, Random random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10); 
            }
        }
    }

 
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[i].length; j++)   {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


    private static void addMatrices(int[][] matrix1, int[][] matrix2, int[][] result) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
    
    private static void difference(int [][]matrix1 , int [][]matrix2 , int [][]result){
      for(int i=0 ; i<matrix1.length ; i++){
        for ( int j=0 ; j<matrix1[i].length;j++){
          result[i][j]=matrix1[i][j] - matrix2[i][j];
        }
      }
    }
    
    
     private static void multiply(int [][]matrix1 , int [][]matrix2 , int [][]result){
      for(int i=0 ; i<matrix1.length ; i++){
        for ( int j=0 ; j<matrix1[i].length;j++){
          for (int k=0 ; k<matrix1[i].length ; k++){
            result[i][j] += matrix1[i][k]*matrix2[j][k];
          }
        }
      }
    }
   
    
}
   
   

