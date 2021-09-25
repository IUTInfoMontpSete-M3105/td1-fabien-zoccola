package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.users.Etudiant;

public class Participation {

    public Participation(Etudiant concerne, Cours cours) {
        this.concerne = concerne;
        this.cours = cours;

        status = EtatParticipation.ACTIVE;
    }

    private int totalPoints;
    private String certificat;

    private EtatParticipation status;
    private final Etudiant concerne;
    private final Cours cours;

}