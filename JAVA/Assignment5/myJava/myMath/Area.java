package myJava.myMath;

public class Area {
    //Function to calculate area of Circle
    public static double area(double r){
        return (Math.PI * r * r);
    }

    //Function to calculate area of rectangle
    public static double area(double l , double b){
        return l * b;
    }

    //Function to calcuate surface area of cylinder
    public static double areaCylinder(double r , double h){
        double result = (2*area(r))+(2*Math.PI*r*h);
        return result;
    }

}
