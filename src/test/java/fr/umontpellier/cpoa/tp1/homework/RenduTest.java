package fr.umontpellier.cpoa.tp1.homework;

import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RenduTest {

    private Rendu r;
    private Enseignant ens;
    private Etudiant etu;

    @BeforeEach
    void setup()
    {
        Devoir d = new Devoir("faire le TP1 de CPOA", 20);
        etu = EtudiantFactory.factory("Fabien", 123);
        ens = EnseignantFactory.factory("Najib", 1);

        r = new Rendu(d, etu);
    }

    @Test
    void statusEmpty()
    {
        assertEquals(EtatRendu.EMPTY, r.getEtat());
    }

    @Test
    void ajouterDocuments()
    {
        assertEquals(EtatRendu.EMPTY, r.getEtat());
        r.ajouterDocument("doc1");
        assertEquals(EtatRendu.HAS_DOCUMENTS, r.getEtat());
    }

    @Test
    void deadline_noDocuments_locked()
    {
        r.assignerEns(ens);
        assertEquals(EtatRendu.LOCKED, r.getEtat());
        assertEquals(0, r.getNote());
    }

    @Test
    void deadline_hasDocuments_affected()
    {
        r.ajouterDocument("doc1");
        r.assignerEns(ens);
        assertEquals(EtatRendu.AFFECTE, r.getEtat());
    }

    @Test
    void deadline_affecte_saisirNote_works()
    {
        r.ajouterDocument("doc1");
        r.assignerEns(ens);
        r.saisirNote(18);
        assertEquals(18, r.getNote());
    }

    @Test
    void deadline_locked_saisirNote_doesntWork()
    {
        r.assignerEns(ens);
        r.saisirNote(18);
        assertEquals(0, r.getNote());
    }

    @Test
    void consulterDocuments()
    {
        r.ajouterDocument("doc1");
        r.ajouterDocument("doc2");

        List<String> expected = new ArrayList<>() {{
            add("doc1"); add("doc2");
        }};
        List<String> actual = r.consulterDocuments();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    void saisirNote_upperLimit()
    {
        r.ajouterDocument("doc1");
        r.assignerEns(ens);
        r.saisirNote(21);
        assertEquals(20, r.getNote());
    }

    @Test
    void saisirNote_lowerLimit()
    {
        r.ajouterDocument("doc1");
        r.assignerEns(ens);
        r.saisirNote(-1);
        assertEquals(0, r.getNote());
    }

    @Test
    void getEtudiant()
    {
        assertEquals(etu, r.getEtudiant());
    }

}
