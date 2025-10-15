package se.jensen.simeon.webbshop;

import se.jensen.simeon.webbshop.controller.*;
import se.jensen.simeon.webbshop.repository.BookRepository;
import se.jensen.simeon.webbshop.repository.ClothRepository;
import se.jensen.simeon.webbshop.repository.ElectronicRepository;
import se.jensen.simeon.webbshop.view.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfoView infoView = new InfoView();

        //Skapa repository
        BookRepository bookRepository = new BookRepository(infoView);
        ClothRepository clothRepository = new ClothRepository(infoView);
        ElectronicRepository electronicRepository = new ElectronicRepository(infoView);

        //Skapa gemensam PromptController
        PromptController promptController = new PromptController(scanner);

        //Skapa kontrollers
        BookController bookController = new BookController(bookRepository,
                new InfoView(), new AddBookView(promptController));

        ClothController clothController = new ClothController(clothRepository,
                new InfoView(), new AddClothView(promptController));

        ElectronicController electronicController = new ElectronicController(electronicRepository,
                new InfoView(), new AddElectronicView(promptController));

        MenuController menuController = new MenuController(new MenuView(scanner), bookRepository, clothRepository,
                electronicRepository, bookController, clothController, electronicController, scanner);

        menuController.startMenu();

        scanner.close();
    }

}
