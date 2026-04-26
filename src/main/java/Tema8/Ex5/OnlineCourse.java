package Tema8.Ex5;

public class OnlineCourse extends Course {
    public String platform;
    public OnlineCourse(String courseName, int duration, String platform) {
        super(courseName, duration);
        this.platform = platform;
    }

    public void onlineCourseDetails() {
        System.out.println("Particip la cursul de " + courseName + " care dureaza " + duration + " luni pe platforma " + platform);
    }
}
