public class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void isPassed() {
        if(grade >= 5) {
            System.out.println(this.name + " a trecut.");
        } else {
            System.out.println(this.name + " nu a trecut.");
        }
    }

    public void setGrade(int newGrade) {
        this.grade = newGrade;
    }

    public void getGrade() {
        System.out.println(this.grade);
    }

    public static void main(String []args) {
        Student student1 = new Student("Gratiela", 9);
        Student student2 = new Student("Ioana", 3);

        student1.isPassed();
        student2.isPassed();

        student2.setGrade(6);
        student2.getGrade();
    }
}