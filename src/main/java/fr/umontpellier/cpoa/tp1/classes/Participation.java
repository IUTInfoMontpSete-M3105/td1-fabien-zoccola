package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.users.Etudiant;

public class Participation {

    public Participation(Etudiant concerne, Cours cours) {
        this.concerne = concerne;
        this.cours = cours;
        totalPoints = 0;
        certificat = "";

        status = EtatParticipation.ACTIVE;
    }

    private int totalPoints;
    private String certificat;

    private EtatParticipation status;
    private final Etudiant concerne;
    private final Cours cours;

    public EtatParticipation getStatus() {
        return status;
    }

    public void commencerCalcul()
    {
        status = EtatParticipation.LOCKED;
    }

    public void ajouterPoints(int n)
    {
        if (!status.equals(EtatParticipation.LOCKED)) return;
        totalPoints += Math.max(n, 0);
    }

    public void finirCalcul()
    {
        if (!status.equals(EtatParticipation.LOCKED)) return;
        status = EtatParticipation.ATTENTE_DECISION;
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    public void setCertificat(String certificat) {
        if (!status.equals(EtatParticipation.ATTENTE_CERTIF)) return;

        this.certificat = certificat;
        status = EtatParticipation.DELIVRE;
    }

    public String getCertificat() {
        return certificat;
    }

    public void updateStatusUsingAverage(int maxPoints)
    {
        if (!status.equals(EtatParticipation.ATTENTE_DECISION)) return;

        status = ((float)totalPoints)/maxPoints >= 0.5
                    ? EtatParticipation.ATTENTE_CERTIF
                    : EtatParticipation.REFUSE;
    }

    public boolean shouldRecieveCertificat()
    {
        return status.equals(EtatParticipation.ATTENTE_CERTIF);
    }

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

    @Override
    public String toString() {
        return "Participation{" +
                "totalPoints=" + totalPoints +
                ", certificat='" + certificat + '\'' +
                ", status=" + status +
                ", concerne=" + concerne.getPrenom() + " " + concerne.getNom() +
                ", cours=" + cours.getNom() +
                '}';
    }
}