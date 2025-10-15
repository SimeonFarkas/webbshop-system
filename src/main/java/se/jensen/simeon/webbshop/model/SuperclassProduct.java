package se.jensen.simeon.webbshop.model;

public abstract class SuperclassProduct {
    private String articleNumber;
    private String title;
    private String price;
    private String description;

    public SuperclassProduct(String articleNumber, String title, String price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    //Jag använder en metod istället för attribut för att sätta en fast kategori per subklass.
    //Med attribut kan jag råka skriva in fel kategori när jag skapar instansen.
    public abstract String category();
}
