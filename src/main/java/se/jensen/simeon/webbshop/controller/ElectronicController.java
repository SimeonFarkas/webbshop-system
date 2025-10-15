package se.jensen.simeon.webbshop.controller;

import se.jensen.simeon.webbshop.model.SubElectronic;
import se.jensen.simeon.webbshop.repository.ElectronicRepository;
import se.jensen.simeon.webbshop.view.AddElectronicView;
import se.jensen.simeon.webbshop.view.InfoView;

public class ElectronicController {
    private ElectronicRepository electronicRepository;
    private InfoView infoView;
    private AddElectronicView addElectronicView;


    public ElectronicController(ElectronicRepository electronicRepository, InfoView infoView, AddElectronicView addElectronicView) {
        this.electronicRepository = electronicRepository;
        this.infoView = infoView;
        this.addElectronicView = addElectronicView;
    }

    public void addElectronic() {
        SubElectronic electronic = addElectronicView.getElectronicInput();

        electronicRepository.addElectronic(electronic);
        infoView.infoAdd();
    }
}
