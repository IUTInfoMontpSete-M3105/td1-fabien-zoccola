package fr.umontpellier.cpoa.tp1.homework;

import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class Rendu {

    public Rendu(Devoir d, Etudiant e)
    {
        etudiant = e;
        etat = EtatRendu.EMPTY;
        documents = new ArrayList<>();
        devoir = d;
    }

    private final Etudiant etudiant;
    private final Devoir devoir;
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
                e.attribuerRendu(this);
                break;
        }
    }

    public void ajouterDocument(String doc)
    {
        if (etat.equals(EtatRendu.EMPTY) || etat.equals(EtatRendu.HAS_DOCUMENTS)) {
            etat = EtatRendu.HAS_DOCUMENTS;
            documents.add(doc);
        }
    }

    public List<String> consulterDocuments() {
        return documents;
    }

    public void saisirNote(int n) {
        if (!etat.equals(EtatRendu.AFFECTE)) return;
        note = Math.max(0, Math.min(devoir.getNoteMax(), n));
        etat = EtatRendu.NOTED;
    }

    public int getNote() {
        return note;
    }

    public EtatRendu getEtat() {
        return etat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }
}