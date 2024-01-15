package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Utilisateur;

import java.util.List;

public interface I_Utilisateur {
    public Utilisateur addUser(Utilisateur user);
    public Utilisateur modUser(Utilisateur user);
    public Boolean delUser(Utilisateur user);
    public List<Utilisateur> showUsers();

    public Utilisateur authentification(String username,String password);
}
