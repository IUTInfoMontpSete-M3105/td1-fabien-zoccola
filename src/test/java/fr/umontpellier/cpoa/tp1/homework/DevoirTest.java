package fr.umontpellier.cpoa.tp1.homework;

import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DevoirTest {

    private Devoir d;

    @BeforeEach
    void setup()
    {
        d = new Devoir("Test", 20);
    }

    @Test
    void getNoteMax()
    {
        assertEquals(20, d.getNoteMax());
    }

    @Test
    void getInstructions()
    {
        assertEquals("Test", d.telecharger());
    }

    @Test
    void rendreDevoir()
    {
        Etudiant e = EtudiantFactory.factory("Fabien", 123);
        Rendu r = d.rendreDevoir(e);

        assertEquals(new ArrayList<Rendu>(){{add(r);}}, d.getListRendus());
    }

}
