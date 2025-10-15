package se.jensen.simeon.webbshop.controller;

import se.jensen.simeon.webbshop.model.PromptInterface;

import java.util.Scanner;

public class PromptController implements PromptInterface {
    private Scanner scanner;

    public PromptController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    
}
