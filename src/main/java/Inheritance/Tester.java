package Inheritance;

public class Tester extends Employee {

    public Tester(String name) {
        super(name);
    }

    public void work(String aplicatie) {
        System.out.println(name + " testeaza " + aplicatie);
    }
}
