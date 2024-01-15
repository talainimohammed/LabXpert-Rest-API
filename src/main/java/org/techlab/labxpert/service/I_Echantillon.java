package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Echantillon;

import java.util.List;

public interface I_Echantillon {
    public Echantillon addEchantillon(Echantillon echantillon);
    public Echantillon modEchantillon(Echantillon echantillon);
    public Boolean delEchantillon(Echantillon echantillon);
    public List<Echantillon> showEchantillons();
}
