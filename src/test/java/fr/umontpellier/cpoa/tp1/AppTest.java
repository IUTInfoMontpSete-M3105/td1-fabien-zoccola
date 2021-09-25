package fr.umontpellier.cpoa.tp1;

import fr.umontpellier.cpoa.tp1.classes.Cours;
import fr.umontpellier.cpoa.tp1.classes.Participation;
import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;
import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void fullTest()
    {
        Enseignant ens = EnseignantFactory.factory("Najib", 1);
        Cours c = new Cours("Test", ens);

        Etudiant e1 = EtudiantFactory.factory("Fabien", 123);
        Etudiant e2 = EtudiantFactory.factory("Paul", 456);

        c.inscrire(e1);
        c.inscrire(e2);

        Devoir d = new Devoir("Faire le TP", 20);
        c.ajouterDevoir(d);

        Rendu r1 = d.rendreDevoir(e1);
        Rendu r2 = d.rendreDevoir(e2);

        r1.ajouterDocument("truc");
        r2.ajouterDocument("muche");

        r1.assignerEns(ens);
        r2.assignerEns(ens);

        r1.saisirNote(15);
        r2.saisirNote(9);

        c.delivrerCertificats();

        Map<Etudiant, Participation> participations = c.getParticipations();

        assertEquals("Cours de CPOA réussi", participations.get(e1).getCertificat());
        assertEquals("", participations.get(e2).getCertificat());

    }

}
