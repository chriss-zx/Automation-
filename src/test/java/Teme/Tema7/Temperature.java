package Teme.Tema7;

public class Temperature {

//    3. Creează clasa Temperature:

//    Atribute:
//    celsius

//    Metode:
//    toFahrenheit() → returnează conversia
//    toKelvin() → returnează conversia

//    Formule:
//    F = C * 9/5 + 32
//    K = C + 273.15

//    În main:
//    creează obiect și afișează valorile

    int celsius;

    public Temperature(int celsius) {
        this.celsius = celsius;
    }

    public double toFahrenheit() {
        return celsius * 9.0/5.0 + 32;
    }

    public double toKelvin() {
        return celsius + 273.15;
    }

    public static void main(String []args) {
        Temperature t1 = new Temperature(10);
        Temperature t2 = new Temperature(27);
        Temperature t3 = new Temperature(-16);

        System.out.println(t1.toFahrenheit());
        System.out.println(t1.toKelvin());

        System.out.println();

        System.out.println(t2.toKelvin());
        System.out.println(t2.toFahrenheit());

        System.out.println();

        System.out.println(t3.toFahrenheit());
        System.out.println(t3.toKelvin());
    }

}
