package se.jensen.simeon.webbshop.repository;

import se.jensen.simeon.webbshop.model.SubBook;
import se.jensen.simeon.webbshop.view.InfoView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class BookRepository {
    private InfoView infoView;

    /*============
        LISTA
    =============*/
    private List<SubBook> books = new ArrayList<>();

    //Konstruktor
    public BookRepository(InfoView infoView) {
        this.infoView = infoView;

        //Förinställda produkter
        books.add(new SubBook("A001", "The Pragmatic Programmer", "360 kr",
                "The Pragmatic Programmer is one of those rare tech books you'll read," +
                        " re-read, and read again over the years. Whether you're new to the field or an experienced practitioner," +
                        " you'll come away with fresh insights each and every time."));

        books.add(new SubBook("A002", "Java steg för steg", "339 kr",
                "Denna bok är tänkt att passa som kurslitteratur i grundläggande programmeringskurser," +
                        " till exempel i en första kurs på universitet eller högskolan."));

        books.add(new SubBook("A003", "Effective Java", "395 kr",
                "Written in a crisp, example-driven style, " +
                        "Effective Java is a must-read for every serious Java developer " +
                        "from intermediate programmers striving for mastery to seasoned professionals aiming to write cleaner," +
                        " more elegant, and maintainable code."));
    }

    //Användaren lägger till produkt
    public void addBook(SubBook book) {
        for (SubBook existingBook : books) {
            if (existingBook.getArticleNumber().equals(book.getArticleNumber())) {
                System.out.println("FEL: Artikelnummer " + book.getArticleNumber() + " finns redan.");
                return;
            }
        }

        books.add(book);
        saveToFile(book);
    }

    /*============
         FIL
    =============*/
    private Path file = Path.of("Bok-fil.txt");

    private void saveToFile(SubBook book) {
        try {
//            for (SubBook book : books) {//En loop som går igenom varje 'book' i 'books' och skapar string genom att:
            String bookInfo = book.getArticleNumber() + "; " + //hämtar artikelnummer
                    book.getTitle() + "; " + //hämtar titel
                    book.getPrice() + "; " + //hämtar pris
                    book.getDescription() + "\n"; //hämtar beskrivning och hoppar ner en rad i dokumentet
            //till nästa 'book' i 'books'

            Files.writeString(file, bookInfo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//            }
        } catch (IOException e) {
            System.err.println("Fel vid skrivning: " + e.getMessage());
        }
    }

    public void readFile() {
        try {
            String content = Files.readString(file);
            System.out.println(content + "\n");
        } catch (IOException e) {
            System.err.println("Fel vid länsning: " + e.getMessage());
        }
    }

    public void searchFile(String articleNumber) {
        try {
            List<String> lines = Files.readAllLines(file);

            for (String line : lines) {
                String[] parts = line.split(";", 4);
                if (parts.length >= 4) {
                    String currentArticleNumber = parts[0].trim();

                    if (currentArticleNumber.equals(articleNumber)) {
                        String description = parts[3].trim();
                        //Produkten hittades
                        System.out.println("Det här är produktbeskrivningen för " + articleNumber + ": '" + description + "'\n");
                        return;
                    }
                }
            }
            infoView.infoNotFound();
        } catch (IOException e) {
            System.err.println("Fel vid inläsning: " + e.getMessage());
        }
    }


}
