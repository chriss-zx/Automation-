public class Person {
    String name;
    int age;

    public Person(String nameParam) {
        this.name = nameParam;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String nameParam, int ageParam) {
        this.name = nameParam;
        this.age = ageParam;
    }


    public void displayInfo() {
        System.out.println(this.name + " " + this.age);
    }



    public static void main(String []args) {
        Person p1 = new Person("Maria", 25);

        p1.name = "Ana";
        p1.age = 23;

        Person p2 = new Person("Andrei", 43);
//        p2.name = "Andrei";
//        p2.age = 43;

        Person p3 = new Person("George");
        Person p4 = new Person(74);

        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();
    }
}
