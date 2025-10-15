package se.jensen.simeon.webbshop.model;

public interface MenuControllerInterface {

    /*===========
     HANTERA VAL
    ============*/

    void handleChoice(int choice);

    void handleAddItem(int category);

    void handleShowList(int category);

    void handleShowInfo(int category);
}
