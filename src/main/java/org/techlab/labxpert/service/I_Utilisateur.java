package org.techlab.labxpert.service;


import org.techlab.labxpert.dtos.UtilisateurDTO;
import org.techlab.labxpert.entity.Utilisateur;

import java.util.List;

public interface I_Utilisateur {
    public UtilisateurDTO addUser(UtilisateurDTO userdto);
    public UtilisateurDTO modUser(UtilisateurDTO userdto);
    public Boolean delUser(UtilisateurDTO userdto);
    public List<UtilisateurDTO> showUsers();

    public UtilisateurDTO authentification(String username,String password);
}
