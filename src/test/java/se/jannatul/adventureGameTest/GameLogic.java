package se.jannatul.adventureGameTest;
import se.jannatul.adventureGame.Model.Burglar;
import se.jannatul.adventureGame.Model.Resident;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogic {
    @Test
    public void testPunchLowerHealth() {
        //  Create instances of Resident and Burglar
        Burglar burglar = new Burglar("burglar", 10, 10);
        Resident resident = new Resident("resident", 10, 10);

        //Store the starting health of the burglar before the punch
        int startHealth = burglar.getHealth();
        // Calculate the expected health of the burglar after receiving a punch
        int HealthAfterPunch = startHealth - resident.getDamage();

        resident.punch(burglar);

        assertEquals(HealthAfterPunch, burglar.getHealth());
    }
    @Test
    public void testtakehit() {
        Burglar burglar = new Burglar("burglar", 10, 10);
        Resident resident = new Resident("resident", 10, 10);

        int startHealth = resident.getHealth();

        resident.takeHit(burglar.getDamage());

        int expectedHealth = startHealth - burglar.getDamage();
        assertEquals(expectedHealth, resident.getHealth());
    }

    @Test
   public void PersonIsConsciousYes() {
        Burglar burglar = new Burglar("burglar", 10, 5);
        Resident resident = new Resident("resident", 10, 5);

        burglar.takeHit(2);
        assertTrue(burglar.isConcious());
    }

    @Test
    public void PersonIsConsciousNo() {
        Burglar burglar = new Burglar("burglar", 10, 10);
        Resident resident = new Resident("resident", 10, 10);

        burglar.takeHit(burglar.getHealth());

        assertFalse(burglar.isConcious());

    }
}
