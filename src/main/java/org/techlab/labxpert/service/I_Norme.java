package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Norme;

import java.util.List;

public interface I_Norme {
    public Norme addNorme(Norme norme);
    public Norme modNorme(Norme norme);
    public Boolean delNorme(Norme norme);
    public List<Norme> showNormes();
}
