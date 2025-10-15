package se.jensen.simeon.webbshop.view;

import se.jensen.simeon.webbshop.controller.PromptController;
import se.jensen.simeon.webbshop.model.SubElectronic;


public class AddElectronicView {
    private PromptController viewMessage;


    public AddElectronicView(PromptController viewMessage) {
        this.viewMessage = viewMessage;
    }

    public SubElectronic getElectronicInput() {
        String articleNumber = viewMessage.prompt("Ange produktens artikelnummer: ");
        String titel = viewMessage.prompt("Ange produktens titel: ");
        String price = viewMessage.prompt("Ange produktens pris: ");
        String description = viewMessage.prompt("Ange produktens beskrivning: ");

        return new SubElectronic(articleNumber, titel, price, description);
    }
}
