package se.jensen.simeon.webbshop.model;

public interface MenuViewInterface {

    //Behöver inte skriva public för de är det automatiskt i en interface

    /*======
      MENY
    =======*/
    void showMenu();

    void showSubMenu();

    void showMenuAddItem();

    void showMenuWriteOutList();

    void showMenuProductInfo();

    int getUserChoice();
}