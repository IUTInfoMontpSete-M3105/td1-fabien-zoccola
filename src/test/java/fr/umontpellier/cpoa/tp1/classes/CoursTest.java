package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CoursTest {

    private static Cours c;

    @BeforeAll
    static void setup() {
        Enseignant chargeDeCours = EnseignantFactory.factory("Najib", 1);
        c = new Cours("test", chargeDeCours);
    }

    @Test
    void inscrireEtudiant()
    {
        Etudiant e1 = EtudiantFactory.factory("Fabien", 123);
        Etudiant e2 = EtudiantFactory.factory("Paul", 456);

        c.inscrire(e1);
        c.inscrire(e2);

        List<Participation> expected = new ArrayList<>() {{
            add(new Participation(e1, c)); add(new Participation(e2, c));
        }};

        assertTrue(c.getParticipations().containsAll(expected));
        assertTrue(expected.containsAll(c.getParticipations()));
    }

}
