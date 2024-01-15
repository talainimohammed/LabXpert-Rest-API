package org.techlab.labxpert.serviceImp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.techlab.labxpert.Enum.RoleUser;
import org.techlab.labxpert.entity.Utilisateur;
import org.techlab.labxpert.service.I_Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UtilisateurServiceTest {

    @Autowired
    I_Utilisateur i_utilisateur;

    Utilisateur utilisateur;
    @BeforeEach
    void setUp() throws ParseException {
        String dateString = "02/02/1995";
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = inputFormat.parse(dateString);
        utilisateur=new Utilisateur();
        utilisateur.setNom("med");
        utilisateur.setPrenom("imad");
        utilisateur.setDateNaissance(date);
        utilisateur.setSexe("male");
        utilisateur.setAdresse("qwerty");
        utilisateur.setTel("03251325625");
        utilisateur.setRole(RoleUser.Technicien);
        utilisateur.setPassword("12346");
        utilisateur.setNomUtilisateur("medtala");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ajouterUtilisateur() {
       Utilisateur u=i_utilisateur.addUser(utilisateur);
        assertNotNull(u);
    }

    @Test
    void afficherUtilisateurs() {
        System.out.println(i_utilisateur.showUsers().toString());
    }
}