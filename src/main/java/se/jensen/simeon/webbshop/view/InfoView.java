package se.jensen.simeon.webbshop.view;

import se.jensen.simeon.webbshop.model.InfoInterface;

public class InfoView implements InfoInterface {

    @Override
    public void infoAdd() {
        System.out.println("Produkten har lagts till.");
    }

    @Override
    public void infoNotFound() {
        System.out.println("Produkten hittades inte.");
    }

}
