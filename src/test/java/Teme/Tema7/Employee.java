package Teme.Tema7;

public class Employee {
//    4. Creează clasa Employee:

//    Atribute:
//    name
//    salary

//    Metode:
//    constructor cu parametri
//    increaseSalary(double percent)
//    getSalary()

//    În main:
//    creează 2 angajați
//    crește salariul unuia
//    afișează rezultatul

    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double percent) {
        this.salary = this.salary + (percent / 100 * this.salary);
    }

    public void getSalary() {
        System.out.println(this.name + " salary is: " + this.salary);
    }

    public static void main(String []args) {
        Employee cristi = new Employee("Cristi", 4000);
        Employee maria = new Employee("Maria", 4000);

        maria.increaseSalary(20);
        maria.getSalary();

        cristi.getSalary();
    }
}
