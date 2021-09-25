package fr.umontpellier.cpoa.tp1.util.factories;

import fr.umontpellier.cpoa.tp1.users.Enseignant;

public class EnseignantFactory {

    public static Enseignant factory(String prenom, int numem)
    {
        return new Enseignant(prenom, "", "", "", numem, "");
    }

}
