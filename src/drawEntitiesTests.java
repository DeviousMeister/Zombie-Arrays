import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import support.cse131.ArgsProcessor;
import static org.junit.Assert.*;


/**
 * Methods that test the drawEntities() method.
 * These rely on human intervention to confirm the tests.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class drawEntitiesTests {

    /**
     * Draw a zombie and confirm its appearance
     */
    @Test
    public void testDrawAZombie() {
        double[][] zombie = {{1, 0.75, 0.5}};
        ZombieSimulator.drawEntities(zombie);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show a single red dot at (0.75, 0.5)? true or false?"));
    }


    /**
     * Draw a nonzombie and confirm its appearance
     */
    @Test
    public void testDrawANonzombie() {
        double[][] zombie = {{2, 0.25, 0.5}};
        ZombieSimulator.drawEntities(zombie);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show a single black dot at (0.25, 0.5)? true or false?"));
    }

    /**
     * Draw a zombie and a nonzombie confirm their appearance
     */
    @Test
    public void testDrawTwoEntities() {
        double[][] entities = {{2, 0.25, 0.5},
                               {1, 0.75, 0.5}};
        ZombieSimulator.drawEntities(entities);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show both a single black dot at (0.25, 0.5) and a single red tot at (0.75, 0.5)? true or false?"));
    }
}
