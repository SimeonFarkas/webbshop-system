package se.jensen.simeon.webbshop.repository;

import se.jensen.simeon.webbshop.model.SubElectronic;
import se.jensen.simeon.webbshop.view.InfoView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ElectronicRepository {
    private InfoView infoView;

    /*============
        LISTA
    =============*/
    private List<SubElectronic> electronics = new ArrayList<>();

    public ElectronicRepository(InfoView infoView) {
        this.infoView = infoView;

        electronics.add(new SubElectronic("C001", "Samsung 65” Q7F3 4K QLED Smart TV (2025)",
                "7990 kr",
                "Upplev dina favoritprogram i förstklassig kvalitet med Samsung 65\" Q7F3 4K QLED Smart TV."));

        electronics.add(new SubElectronic("C002", "HP OmniBook 5 14 Snap-8C/16/512/OLED 14\" Copilot+ PC",
                "7995 kr",
                "HP OmniBook 5 14 Snap-8C/16/512/OLED 14\" Copilot+ PC levererar AI-driven prestanda," +
                        " upp till 34 timmars batteritid, ansiktsigenkänning och fantastiska 2K OLED-bilder, " +
                        "allt i en tunn och bärbar design."));

        electronics.add(new SubElectronic("C003", "Samsung Serie 5000 Tvättmaskin WW95CGC04CAEEE (9kg)",
                "4995 kr",
                "Upplev nästa generations tvätt med Samsung-tvättmaskinen WW95CGC04CAEEE. " +
                        "Den har en kapacitet på 9 kg, Smart Things-appen, Hygiene Steam," +
                        " EcoBubble och Digital Inverter-teknik."));

    }

    //Användaren lägger till produkt
    public void addElectronic(SubElectronic electronic) {
        for (SubElectronic existingElectronic : electronics) {
            if (existingElectronic.getArticleNumber().equals(electronic.getArticleNumber())) {
                System.out.println("FEL: Artikelnummer " + electronic.getArticleNumber() + " finns redan.");
                return;
            }
        }

        electronics.add(electronic);
        saveToFile(electronic);
    }

    /*============
         FIL
    =============*/
    private Path file = Path.of("Elektronik-lista.txt");

    private void saveToFile(SubElectronic electronic) {
        try {
            String electronicInfo = electronic.getArticleNumber() + ", "
                    + electronic.getTitle() + ", "
                    + electronic.getPrice() + ", "
                    + electronic.getDescription() + "\n";

            Files.writeString(file, electronicInfo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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
