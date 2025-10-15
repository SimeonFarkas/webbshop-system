package se.jensen.simeon.webbshop.model;

public class SubCloth extends SuperclassProduct {

    public SubCloth(String articleNumber, String title, String price, String descirption) {
        super(articleNumber, title, price, descirption);
    }

    @Override
    public String category() {
        return "Klädesplagg";
    }

}
