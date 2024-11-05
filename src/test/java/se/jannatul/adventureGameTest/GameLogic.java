package se.jannatul.adventureGameTest;
import se.jannatul.adventureGameTest.Model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogic {
    @Test
    public void testPunchLowerHealth() {
        // Arrange: Create instances of Resident and Burglar
        ResidentTest residentTest = new ResidentTest();
        BurglarTest burglarTest = new BurglarTest();

        int startHealth = burglarTest.getHealth();
        int HealthAfterPunch = startHealth - residentTest.getDamage();

        residentTest.punch(burglarTest);

        assertEquals(HealthAfterPunch, burglarTest.getHealth(), residentTest.getHealth());
    }
    @Test
    public void testtakehit() {
        ResidentTest residentTest = new ResidentTest();
        BurglarTest burglarTest = new BurglarTest();

        int startHealth = residentTest.getHealth();

        residentTest.takeHit(burglarTest.getDamage());

        int expectedHealth = startHealth - burglarTest.getDamage();
        assertEquals(expectedHealth, residentTest.getHealth());
    }
    @Test
    public void PersonIsConsciousYes() {
        ResidentTest residentTest = new ResidentTest();
        BurglarTest burglarTest = new BurglarTest();
        int startHealth = burglarTest.getHealth();

        residentTest.punch(burglarTest);

        assertTrue(burglarTest.isConscious());

    }
    @Test
    public void PersonIsConsciousNo() {
        ResidentTest residentTest = new ResidentTest();
        BurglarTest burglarTest = new BurglarTest();
        int startHealth = burglarTest.getHealth();

        residentTest.punch(burglarTest);
        residentTest.punch(burglarTest);
        residentTest.punch(burglarTest);
        residentTest.punch(burglarTest);

        assertFalse(burglarTest.isConscious());
    }
}
