package Inheritance;

public class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Grade: " + this.grade);
    }

    public int getGrade() {
        return grade;
    }
}
