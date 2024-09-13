package Part1;

public class Main{
    public static void main(String[] args) {
        System.out.println("Total Instances before any creation : "+ Student.getInstanceCount());
        System.out.println(Student.getInstanceCount());
        Student s1 = new Student(1, "Piyush Solanki", "MCA");
//        System.out.println(Part1.Student.getInstanceCount());
        s1.getDetails();
        Student s2 = new Student(2, "Rajesh Kumar", "PGDCA");
        s2.getDetails();
//        System.out.println(Part1.Student.getInstanceCount());
        System.out.println("Total Instances after object creation : "+ Student.getInstanceCount());
    }
}
