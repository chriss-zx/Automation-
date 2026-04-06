package Teme.Tema7;

public class Dog {

//    1. Creează clasa Dog:
//    Atribute:
//    name
//    age

//    Metode:
//    bark() → afișează: „Câinele <name> latră”
//    getAgeInHumanYears() → returnează age * 7

//    În main:
//    creează 2 obiecte
//    apelează metodele

    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void bark() {
        System.out.println("Cainele " + name + " latra.");
    }

    public int getAgeInHumanYears() {
        return this.age * 7;
    }

    public static void main(String []args) {
        Dog rex = new Dog("Rex", 4);
        Dog ares = new Dog("Ares", 7);

        rex.bark();
        System.out.println(rex.getAgeInHumanYears());

        System.out.println();

        ares.bark();
        System.out.println(ares.getAgeInHumanYears());
    }

}
