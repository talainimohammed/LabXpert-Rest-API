package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Fournisseur;

import java.util.List;

public interface I_Fournisseur {
    public Fournisseur addFournisseur(Fournisseur fournisseur);
    public Fournisseur modFournisseur(Fournisseur fournisseur);
    public Boolean delFournisseur(Fournisseur fournisseur);
    public List<Fournisseur> showFournisseurs();
}
