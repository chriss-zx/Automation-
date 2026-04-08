package Inheritance;

public class Employee {

    public String name;

    public Employee(String name) {
        this.name = name;
    }

    public void work(String meserie) {
        System.out.println(this.name + " lucreaza ca " + meserie);
    }
}
