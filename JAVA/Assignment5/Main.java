import myJava.myMath.Area;
import myJava.myMath.Factorial;
import myJava.myMath.Volume;

public class Main {
    public static void main(String[] args) {
        int r =5 , l=2 , b=4 , h=2;
          System.out.println("The Area of Circle is: "+ Area.area(r));
          System.out.println("The Area of Rectangle is :"+Area.area(l,b));
          System.out.println("The Surface area of Cylinder is : "+Area.areaCylinder(r,h));
          System.out.println("The Factorial of BigNumber 25 is : "+ Factorial.factB(25));
          System.out.println("The Volume of Sphere is : "+ Volume.vol(r));
          System.out.println("The Volume of Cubioid is : "+Volume.vol(l,b,h));
          System.out.println("The Volume of Cylinder is : "+Volume.vol(r,h));

    }
}
