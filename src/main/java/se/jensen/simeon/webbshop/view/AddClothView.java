package se.jensen.simeon.webbshop.view;

import se.jensen.simeon.webbshop.controller.PromptController;
import se.jensen.simeon.webbshop.model.SubCloth;

public class AddClothView {
    private PromptController viewMessage;


    public AddClothView(PromptController viewMessage) {
        this.viewMessage = viewMessage;
    }

    public SubCloth getClothInput() {
        String articleNumber = viewMessage.prompt("Ange produktens artikelnummer: ");
        String titel = viewMessage.prompt("Ange produktens titel: ");
        String price = viewMessage.prompt("Ange produktens pris: ");
        String description = viewMessage.prompt("Ange produktens beskrivning: ");

        return new SubCloth(articleNumber, titel, price, description);
    }
}
