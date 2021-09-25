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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participation that = (Participation) o;

        if (!concerne.equals(that.concerne)) return false;
        return cours.equals(that.cours);
    }

    @Override
    public int hashCode() {
        int result = concerne.hashCode();
        result = 31 * result + cours.hashCode();
        return result;
    }
}