public class Student {

    private int rollno;
    private String fullName;
    private String className;
    private static int instanceCount = 0;

    Student(int rollno, String fullName, String className) {
        instanceCount++;
        this.rollno = rollno;
        this.fullName = fullName;
        this.className = className;
    }

    public void getDetails() {
        System.out.println("------- Student Details -------");
        System.out.println("Roll Number : " + rollno);
        System.out.println("Full Name : " + fullName);
        System.out.println("Class : " + className);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
