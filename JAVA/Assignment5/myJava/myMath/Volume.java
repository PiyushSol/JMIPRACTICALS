package myJava.myMath;

public class Volume {
    //Function to calculate volume of sphere
    public static double vol(double r){
        return (4/3*Math.PI*r*r*r);
    }

    //Function to calculate volume of cuboid
    public static double vol(double a, double b, double c){
        return a*b*c;
    }

    //Function to calculate volume of cylinder
    public static double vol(double r , double h){
        return (Math.PI *r*r*h);
    }
}
