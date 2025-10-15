package se.jensen.simeon.webbshop.model;

public class SubBook extends SuperclassProduct {

    public SubBook(String articleNumber, String title, String price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Bok";
    }

}
