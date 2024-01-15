package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Reactif;

import java.util.List;

public interface I_Reactif {
    public Reactif addReactif(Reactif reactif);
    public Reactif modReactif(Reactif reactif);
    public Boolean delReactif(Reactif reactif);
    public List<Reactif> showReactifs();
}
