package fr.umontpellier.cpoa.tp1.homework;

import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class Rendu {

    public Rendu(Etudiant e)
    {
        etudiant = e;
        etat = EtatRendu.EMPTY;
        documents = new ArrayList<>();
    }

    private Enseignant ens;
    private final Etudiant etudiant;
    private int note;
    private final List<String> documents;
    private EtatRendu etat;

    public void assignerEns(Enseignant e) {
        switch (etat)
        {
            case EMPTY:
                etat = EtatRendu.LOCKED;
                note = 0;
                break;
            case HAS_DOCUMENTS:
                etat = EtatRendu.AFFECTE;
                break;
        }
        ens = e;
    }

    public void ajouterDocument(String doc)
    {
        if (etat.equals(EtatRendu.EMPTY) || etat.equals(EtatRendu.HAS_DOCUMENTS)) {
            etat = EtatRendu.HAS_DOCUMENTS;
            documents.add(doc);
        }
    }

    public String consulterDocument(int d) {
        return documents.get(d);
    }

    public void saisirNote(int n) {
        if (!etat.equals(EtatRendu.AFFECTE)) return;
        note = n;
        etat = EtatRendu.NOTED;
    }

    public int getNote() {
        return note;
    }

}