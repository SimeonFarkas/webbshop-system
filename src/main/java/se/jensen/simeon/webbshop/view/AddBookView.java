package se.jensen.simeon.webbshop.view;

import se.jensen.simeon.webbshop.controller.PromptController;
import se.jensen.simeon.webbshop.model.SubBook;

public class AddBookView {
    private PromptController viewMessage;


    public AddBookView(PromptController viewMessage) {
        this.viewMessage = viewMessage;
    }

    public SubBook getBookInput() {
        String articleNumber = viewMessage.prompt("Ange produktens artikelnummer: ");
        String titel = viewMessage.prompt("Ange produktens titel: ");
        String price = viewMessage.prompt("Ange produktens pris: ");
        String description = viewMessage.prompt("Ange produktens beskrivning: ");

        return new SubBook(articleNumber, titel, price, description);
    }

}
