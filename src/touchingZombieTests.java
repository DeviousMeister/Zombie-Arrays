import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;


/**
 * Methods that test the touchingZombie() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class touchingZombieTests {

    /**
     * Check a single nonzombie isn't touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombie() {
        double entities[][] = {{2, 0.5, 0.5}};
        assertEquals(false, ZombieSimulator.touchingZombie(0, entities));
    }

    /**
     * Check a single nonzombie that is touching a zombie
     */
    @Test
    public void testTwoEntitiesSingleNonzombieTouching() {
        double entities[][] = { {1, 0.5, 0.5},
                                {2, 0.5, 0.50001},
                                {2, 0.5, 0.8}};
        assertEquals(true, ZombieSimulator.touchingZombie(1, entities));
    }

    /**
     * Check a single nonzombie that is barely non touching a zombie
     */
    @Test
    public void testTwoEntitiesSingleNonzombieNotTouching() {
        double entities[][] = { {1, 0.5, 0.5},
                                {2, 0.5, 0.50001},
                                {2, 0.5, 0.8}};
        assertEquals(false, ZombieSimulator.touchingZombie(2, entities));
    }

    /**
     * Check a nonzombie that is barely above and barely touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyTouchingYAbove() {
        double entities[][] = { {1, 0.5, 0.5},
                                {2, 0.5, 0.5 + 2*.005-.0005},
                                {2, 0.5, 0.8}};
        assertEquals(true, ZombieSimulator.touchingZombie(1, entities));
    }

    /**
     * Check a  nonzombie that is below and barely touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyTouchingYBelow() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5, 0.5 - 2*.005+.0005},
                {2, 0.5, 0.8}};
        assertEquals(true, ZombieSimulator.touchingZombie(1, entities));
    }
    /**
     * Check a nonzombie that is left of and barely touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyTouchingXRight() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5 + 2*.005-.0005, 0.5},
                {2, 0.5, 0.8}};
        assertEquals(true, ZombieSimulator.touchingZombie(1, entities));
    }

    /**
     * Check a nonzombie that is right of and barely touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyTouchingLeft() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5 - 2*.005+.0005, 0.5},
                {2, 0.5, 0.8}};
        assertEquals(true, ZombieSimulator.touchingZombie(1, entities));
    }


    /**
     * Check a nonzombie that above and is barely not touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyNotTouchingYAbove() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5, 0.5 + 2*.005 + .0005},
                {2, 0.5, 0.8}};
        assertEquals(false, ZombieSimulator.touchingZombie(1, entities));
    }
    /**
     * Check a nonzombie that is below and barely not touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyNotTouchingYBelow() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5, 0.5 - 2*.005 - .0005},
                {2, 0.5, 0.8}};
        assertEquals(false, ZombieSimulator.touchingZombie(1, entities));
    }

    /**
     * Check a nonzombie that is left of and barely not touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyNotTouchingXRight() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5 + 2*.005 + .0005, 0.5},
                {2, 0.5, 0.8}};
        assertEquals(false, ZombieSimulator.touchingZombie(1, entities));
    }
    /**
     * Check a nonzombie that is right of and barely not touching a zombie
     */
    @Test
    public void testSingleEntitySingleNonzombieBarelyNotTouchingXLeft() {
        double entities[][] = { {1, 0.5, 0.5},
                {2, 0.5, 0.5 - 2*.005 - .0005},
                {2, 0.5, 0.8}};
        assertEquals(false, ZombieSimulator.touchingZombie(1, entities));
    }
}
