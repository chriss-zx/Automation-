package Tema8.Ex5;

public class Course {
    public String courseName;
    public int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void courseDetails() {
        System.out.println("Particip la cursul de " + courseName + " care dureaza " + duration + " luni");
    }
}
