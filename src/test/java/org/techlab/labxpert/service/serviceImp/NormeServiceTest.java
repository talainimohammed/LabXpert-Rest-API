package org.techlab.labxpert.service.serviceImp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.techlab.labxpert.entity.Norme;
import org.techlab.labxpert.repository.NormeRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class NormeServiceTest {

    @Autowired
    NormeRepository normeRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/listTest.csv", numLinesToSkip = 1)
    void addNorme(String Name,double Min,double Max,String Unit) {
        Norme norme=new Norme();
        norme.setLibelle(Name);
        norme.setUnite(Unit);
        norme.setMaxValue(Max);
        norme.setMinValue(Min);
        normeRepository.save(norme);
    }

    @Test
    void showNormes() {
        System.out.println(normeRepository.findAll());
    }
}