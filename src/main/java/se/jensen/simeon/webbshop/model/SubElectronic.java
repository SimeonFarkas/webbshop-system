package se.jensen.simeon.webbshop.model;

public class SubElectronic extends SuperclassProduct {

    public SubElectronic(String articleNumber, String title, String price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Elektronik";
    }

}
