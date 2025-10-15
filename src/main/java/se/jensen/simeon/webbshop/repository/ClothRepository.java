package se.jensen.simeon.webbshop.repository;

import se.jensen.simeon.webbshop.model.SubCloth;
import se.jensen.simeon.webbshop.view.InfoView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClothRepository {
    private InfoView infoView;

    /*============
        LISTA
    =============*/
    private List<SubCloth> clothes = new ArrayList<>();

    public ClothRepository(InfoView infoView) {
        this.infoView = infoView;

        clothes.add(new SubCloth("B001", "Enfärgad Hoodie med blixtlås", "399,95 kr",
                "- Produkttyp: Hoodie med blixtlås \n" +
                        "- Nacken: Hoodie \n" +
                        "- Ärm: Långa ärmar \n" +
                        "- Passform: Avslappnad"));

        clothes.add(new SubCloth("B002", "Enfärgad Sweatshirt", "299,95 kr",
                "- Produkttyp: Sweatshirt \n" +
                        "- Nacken: Rundringning \n" +
                        "- Ärm: Långa ärmar \n" +
                        "- Passform: Avslappnad"));

        clothes.add(new SubCloth("B003", "Enfärgad Hoodie", "399,95 kr",
                "- Produkttyp: Hoodie \n" +
                        "- Nacken: Hoodie \n" +
                        "- Ärm: Långa ärmar \n" +
                        "- Fickor: Känguruficka \n" +
                        "- Passform: Avslappnad"));

    }

    //Användaren lägger till produkt
    public void addCloth(SubCloth cloth) {
        for (SubCloth existingCloth : clothes) {
            if (existingCloth.getArticleNumber().equals(cloth.getArticleNumber())) {
                System.out.println("FEL: Artikelnummer " + cloth.getArticleNumber() + " finns redan.");
                return;
            }
        }

        clothes.add(cloth);
        saveToFile(cloth);
    }

    /*============
         FIL
    =============*/
    private Path file = Path.of("Kläd-lista.txt");

    private void saveToFile(SubCloth cloth) {
        try {
            String clothInfo = cloth.getArticleNumber() + ", " +
                    cloth.getTitle() + ", " +
                    cloth.getPrice() + ", " +
                    cloth.getDescription() + "\n";

            Files.writeString(file, clothInfo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Fel vid skrivning: " + e.getMessage());
        }
    }

    public void readFile() {
        try {
            String content = Files.readString(file);
            System.out.println(content + "\n");
        } catch (IOException e) {
            System.err.println("Fel vid länsning: " + e.getMessage());
        }
    }

    public void searchFile(String articleNumber) {
        try {
            List<String> lines = Files.readAllLines(file);

            for (String line : lines) {
                String[] parts = line.split(";", 4);
                if (parts.length >= 4) {
                    String currentArticleNumber = parts[0].trim();

                    if (currentArticleNumber.equals(articleNumber)) {
                        String description = parts[3].trim();
                        //Produkten hittades
                        System.out.println("Det här är produktbeskrivningen för " + articleNumber + ": '" + description + "'\n");
                        return;
                    }
                }
            }
            infoView.infoNotFound();
        } catch (IOException e) {
            System.err.println("Fel vid inläsning: " + e.getMessage());
        }
    }
}
