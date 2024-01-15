package org.techlab.labxpert.service.serviceImp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.techlab.labxpert.entity.Fournisseur;
import org.techlab.labxpert.entity.Numeration;
import org.techlab.labxpert.entity.Reactif;
import org.techlab.labxpert.repository.FournisseurRepository;
import org.techlab.labxpert.service.I_Reactif;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReactifServiceTest {

    @Autowired
    I_Reactif i_reactif;
    @Autowired
    FournisseurRepository fournisseurRepository;
    @ParameterizedTest
    @CsvFileSource(resources = "/listreactif.csv" , numLinesToSkip = 1)
    void addReactif(String Name,String Description,int Quantite,String DateExperation,Long idfournisseur) throws ParseException {
        Reactif reactif=new Reactif();
        reactif.setNom(Name);
        reactif.setDescription(Description);
        reactif.setQuantite(Quantite);
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = inputFormat.parse(DateExperation);
        reactif.setDateExpiration(date);
        Fournisseur fournisseur=fournisseurRepository.findById(idfournisseur).get();
        reactif.setFournisseur(fournisseur);
        i_reactif.addReactif(reactif);
    }
}