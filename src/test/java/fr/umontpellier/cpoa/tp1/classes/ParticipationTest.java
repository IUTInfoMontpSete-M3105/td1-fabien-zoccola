package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipationTest {

    private Participation p;

    @BeforeEach
    void setup()
    {
        Etudiant e = EtudiantFactory.factory("Fabien", 123);
        Cours c = new Cours("CPOA", EnseignantFactory.factory("Najib", 1));

        p = new Participation(e, c);
    }

    @Test
    void status()
    {
        assertEquals(EtatParticipation.ACTIVE, p.getStatus());
    }

    @Test
    void ajouterPoints_working()
    {
        p.commencerCalcul();
        assertEquals(EtatParticipation.LOCKED, p.getStatus());
        p.ajouterPoints(10);
        assertEquals(10, p.getTotalPoints());
    }

    @Test
    void ajouterPoints_notWorking_before()
    {
        p.ajouterPoints(10);
        assertEquals(0, p.getTotalPoints());
    }

    @Test
    void ajouterPoints_notWorking_after()
    {
        p.ajouterPoints(10);
        assertEquals(0, p.getTotalPoints());

        p.commencerCalcul();
        p.finirCalcul();
        p.ajouterPoints(10);

        assertEquals(0, p.getTotalPoints());
    }

    @Test
    void updateStatusUsingAverage_belowAverage()
    {
        p.commencerCalcul();
        p.finirCalcul();
        p.updateStatusUsingAverage(10);

        assertEquals(EtatParticipation.REFUSE, p.getStatus());
    }

    @Test
    void updateStatusUsingAverage_aboveAverage()
    {
        p.commencerCalcul();
        p.ajouterPoints(15);
        p.finirCalcul();
        p.updateStatusUsingAverage(20);

        assertEquals(EtatParticipation.ATTENTE_CERTIF, p.getStatus());
        assertTrue(p.shouldRecieveCertificat());
    }

    @Test
    void setCertificat_working()
    {
        p.commencerCalcul();
        p.ajouterPoints(15);
        p.finirCalcul();
        p.updateStatusUsingAverage(20);

        p.setCertificat("WORKING!");
        assertEquals("WORKING!", p.getCertificat());
    }

    @Test
    void setCertificat_notWorking_before()
    {
        p.setCertificat("WORKING!");
        assertEquals("", p.getCertificat());

        p.commencerCalcul();

        p.setCertificat("WORKING!");
        assertEquals("", p.getCertificat());

        p.finirCalcul();

        p.setCertificat("WORKING!");
        assertEquals("", p.getCertificat());
    }

    @Test
    void setCertificat_notWorking_belowAverage()
    {
        p.commencerCalcul();
        p.ajouterPoints(5);
        p.finirCalcul();
        p.updateStatusUsingAverage(20);

        p.setCertificat("WORKING!");
        assertEquals("", p.getCertificat());
    }

}
