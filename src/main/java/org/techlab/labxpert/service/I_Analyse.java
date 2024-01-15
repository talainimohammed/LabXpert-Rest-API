package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Analyse;
import org.techlab.labxpert.entity.Echantillon;

import java.util.List;

public interface I_Analyse {
    public Analyse addAnalyse(Analyse analyse);
    public Analyse modAnalyse(Analyse analyse);
    public Boolean delAnalyse(Analyse analyse);
    public List<Analyse> showAnalyses();
    public Analyse planifierAnalyse(Analyse analyse);
}
