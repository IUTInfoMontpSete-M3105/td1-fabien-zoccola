package fr.umontpellier.cpoa.tp1.util.factories;

import fr.umontpellier.cpoa.tp1.users.Admin;

public class AdminFactory {

    public static Admin factory(String prenom)
    {
        return new Admin(prenom, "", "", "");
    }

}
