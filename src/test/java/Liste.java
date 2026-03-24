import java.util.ArrayList;
import java.util.List;

public class Liste {

    public static void main(String[] args) {

        // crearea unei liste - v1
        List<String> lista = new ArrayList<>();

        // crearea unei liste - v2
        List<Integer> numere = List.of(1, 2, 48, 345);

        // afisarea listei - v1
        System.out.println(lista);
        System.out.println(numere);

        // afisarea listei - v2
        for (int i = 0; i < numere.size(); i++) {
            System.out.print(numere.get(i) + " ");
        }

        // afisarea listei - v3
        for (Integer item : numere) {
            System.out.print(item + " ");
        }

        System.out.println();

        // operatii de baza
        List<String> fructe = new ArrayList<>();

        // adaugare elemente in lista
        fructe.add("apple");
        fructe.add("banana");
        fructe.add("orange");

        fructe.add(1, "kiwi");

        System.out.println(fructe);

        // afisarea unui anumit element
       String item = fructe.get(2);

        System.out.println(item);

        // modificarea unui element
        fructe.set(3, "pear");

        System.out.println(fructe);

        // stergerea unui element
        fructe.remove("kiwi");
        System.out.println(fructe);
        fructe.remove(1);
        System.out.println(fructe);

        // dimensiunea unei liste

       int dimensiune = fructe.size();
        System.out.println(dimensiune);
    }
}