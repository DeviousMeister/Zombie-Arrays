import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;


/**
 * Methods that test the readEntities() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class readEntitiesTests {

    /**
     * Test if all values from aNonZombie.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadANonZombie() {
        // Test "aNonZombie"'s value
        double[][] values = ZombieSimulator.readEntities("aNonZombie.sim");
        assertEquals(1, values.length);
        assertEquals(2, values[0][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.5, values[0][ZombieSimulator.X], 1e-4);
        assertEquals(0.5, values[0][ZombieSimulator.Y], 1e-4);
    }

    /**
     * Test if all values from aZombie.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadAZombie() {
        // Test "aNonZombie"'s value
        double[][] values = ZombieSimulator.readEntities("aZombie.sim");
        assertEquals(1, values.length);
        assertEquals(1, values[0][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.5, values[0][ZombieSimulator.X], 1e-4);
        assertEquals(0.5, values[0][ZombieSimulator.Y], 1e-4);
    }

    /**
     * Test if all values from zombies.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadZombies() {
        // Test "aNonZombie"'s value
        double[][] values = ZombieSimulator.readEntities("zombies.sim");

        assertEquals(5, values.length);
        assertEquals(1, values[0][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.1, values[0][ZombieSimulator.X], 1e-4);
        assertEquals(0.9, values[0][ZombieSimulator.Y], 1e-4);
        assertEquals(1, values[1][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.2, values[1][ZombieSimulator.X], 1e-4);
        assertEquals(0.8, values[1][ZombieSimulator.Y], 1e-4);
        assertEquals(1, values[2][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.3, values[2][ZombieSimulator.X], 1e-4);
        assertEquals(0.7, values[2][ZombieSimulator.Y], 1e-4);
        assertEquals(1, values[3][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.4, values[3][ZombieSimulator.X], 1e-4);
        assertEquals(0.6, values[3][ZombieSimulator.Y], 1e-4);
        assertEquals(1, values[4][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.5, values[4][ZombieSimulator.X], 1e-4);
        assertEquals(0.5, values[4][ZombieSimulator.Y], 1e-4);
    }

    /**
     * Test if all values from nonzombies.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadNonzombies() {
        // Test "aNonZombie"'s value
        double[][] values = ZombieSimulator.readEntities("nonzombies.sim");

        assertEquals(5, values.length);
        assertEquals(2, values[0][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.9, values[0][ZombieSimulator.X], 1e-4);
        assertEquals(0.1, values[0][ZombieSimulator.Y], 1e-4);
        assertEquals(2, values[1][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.8, values[1][ZombieSimulator.X], 1e-4);
        assertEquals(0.2, values[1][ZombieSimulator.Y], 1e-4);
        assertEquals(2, values[2][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.7, values[2][ZombieSimulator.X], 1e-4);
        assertEquals(0.3, values[2][ZombieSimulator.Y], 1e-4);
        assertEquals(2, values[3][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.6, values[3][ZombieSimulator.X], 1e-4);
        assertEquals(0.4, values[3][ZombieSimulator.Y], 1e-4);
        assertEquals(2, values[4][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.5, values[4][ZombieSimulator.X], 1e-4);
        assertEquals(0.5, values[4][ZombieSimulator.Y], 1e-4);
    }

    /**
     * Test if all select values from zombieWorls.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadNZombieWorld() {
        // Test "aNonZombie"'s value
        double[][] values = ZombieSimulator.readEntities("zombieWorld.sim");

        assertEquals(3454, values.length);
        // 2 0.07958084190886894 0.5812935597950022
        assertEquals(2, values[0][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.07958084190886894, values[0][ZombieSimulator.X], 1e-4);
        assertEquals(0.5812935597950022, values[0][ZombieSimulator.Y], 1e-4);

        //1 0.6132873446925958 0.25900102588653595
        assertEquals(1, values[3453][ZombieSimulator.TYPE], 1e-4);
        assertEquals(0.6132873446925958, values[3453][ZombieSimulator.X], 1e-4);
        assertEquals(0.25900102588653595, values[3453][ZombieSimulator.Y], 1e-4);
    }
}
