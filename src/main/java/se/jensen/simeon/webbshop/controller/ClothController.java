package se.jensen.simeon.webbshop.controller;

import se.jensen.simeon.webbshop.model.SubCloth;
import se.jensen.simeon.webbshop.repository.ClothRepository;
import se.jensen.simeon.webbshop.view.AddClothView;
import se.jensen.simeon.webbshop.view.InfoView;

public class ClothController {
    private ClothRepository clothRepository;
    private InfoView infoView;
    private AddClothView addClothView;


    public ClothController(ClothRepository clothRepository, InfoView infoView, AddClothView addClothView) {
        this.clothRepository = clothRepository;
        this.infoView = infoView;
        this.addClothView = addClothView;
    }

    public void addCloth() {
        SubCloth cloth = addClothView.getClothInput();

        clothRepository.addCloth(cloth);
        infoView.infoAdd();
    }
}
