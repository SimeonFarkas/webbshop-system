package se.jensen.simeon.webbshop.view;

import se.jensen.simeon.webbshop.model.MenuViewInterface;

import java.util.Scanner;

public class MenuView implements MenuViewInterface {
    private Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    /*=============
      SYNLIG MENY
    ==============*/
    @Override
    public void showMenu() {
        System.out.println("==== WEBBSHOP MENY ====");
        System.out.println("1. Lägg till en produkt");
        System.out.println("2. Skriv ut hela listan");
        System.out.println("3. Visa info om en produkt");
        System.out.println("4. Avsluta applikationen");
    }

    @Override
    public void showSubMenu() {
        System.out.println("Välj en kategori:");
        System.out.println("1. Böcker");
        System.out.println("2. Kläder");
        System.out.println("3. Elektronik");
    }

    @Override
    public void showMenuAddItem() {
        System.out.println("==== LÄGG TILL EN PRODUKT ====");
        showSubMenu();
    }

    @Override
    public void showMenuWriteOutList() {
        System.out.println("==== SKRIV UT HELA LISTAN ====");
        showSubMenu();
    }

    @Override
    public void showMenuProductInfo() {
        System.out.println("==== INFO OM EN PRODUKT ====");
        showSubMenu();
    }


    @Override
    public int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt val! Ange en siffra: ");
            }
        }
    }
}
