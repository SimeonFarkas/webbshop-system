package se.jensen.simeon.webbshop.controller;

import se.jensen.simeon.webbshop.model.MenuControllerInterface;
import se.jensen.simeon.webbshop.repository.BookRepository;
import se.jensen.simeon.webbshop.repository.ClothRepository;
import se.jensen.simeon.webbshop.repository.ElectronicRepository;
import se.jensen.simeon.webbshop.view.MenuView;

import java.util.Scanner;

public class MenuController implements MenuControllerInterface {
    private MenuView menuView;
    private BookRepository bookRepository;
    private ClothRepository clothRepository;
    private ElectronicRepository electronicRepository;
    private BookController bookController;
    private ClothController clothController;
    private ElectronicController electronicController;
    private Scanner scanner;

    public MenuController(MenuView menuView, BookRepository bookRepository, ClothRepository clothRepository,
                          ElectronicRepository electronicRepository, BookController addBook, ClothController addCloth,
                          ElectronicController addElectronic, Scanner scanner) {
        this.menuView = menuView;
        this.bookRepository = bookRepository;
        this.clothRepository = clothRepository;
        this.electronicRepository = electronicRepository;
        this.bookController = addBook;
        this.clothController = addCloth;
        this.electronicController = addElectronic;
        this.scanner = scanner;
    }

    /*=============
         STARTA MENYN
        ==============*/
    public void startMenu() {
        int choice;
        do {
            menuView.showMenu();
            choice = menuView.getUserChoice();
            handleChoice(choice);
        } while (choice != 4);
    }

    /*==========
     HANTERA VAL
    ===========*/

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1 -> {
                menuView.showMenuAddItem();
                int subChoice = menuView.getUserChoice();
                handleAddItem(subChoice);
            }
            case 2 -> {
                menuView.showMenuWriteOutList();
                int subChoice = menuView.getUserChoice();
                handleShowList(subChoice);
            }
            case 3 -> {
                menuView.showMenuProductInfo();
                int subChoice = menuView.getUserChoice();
                handleShowInfo(subChoice);
            }
        }
    }

    @Override
    public void handleAddItem(int category) {
        switch (category) {
            case 1 -> bookController.addBook();

            case 2 -> clothController.addCloth();

            case 3 -> electronicController.addElectronic();

        }
    }

    @Override
    public void handleShowList(int category) {
        switch (category) {
            case 1 -> bookRepository.readFile();
            case 2 -> clothRepository.readFile();
            case 3 -> electronicRepository.readFile();
        }
    }

    @Override
    public void handleShowInfo(int category) {
        switch (category) {
            case 1 -> {
                System.out.print("Skriv in produktens artikelnummer: ");
                String userInput = scanner.nextLine();
                bookRepository.searchFile(userInput);
            }
            case 2 -> {
                System.out.print("Skriv in produktens artikelnummer: ");
                String userInput = scanner.nextLine();
                clothRepository.searchFile(userInput);
            }
            case 3 -> {
                System.out.print("Skriv in produktens artikelnummer: ");
                String userInput = scanner.nextLine();
                electronicRepository.searchFile(userInput);
            }
        }
    }

}
