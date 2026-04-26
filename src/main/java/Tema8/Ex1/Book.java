package Tema8.Ex1;

//
//Creează clasa Book:
//        - atribute private: title, author
//- getter + setter pentru fiecare
//- în main: creează obiect, setează valori, afișează-le

public class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
