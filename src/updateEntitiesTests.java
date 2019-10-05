import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Arrays;
import static org.junit.Assert.*;


/**
 * Methods that test the updateEntities() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class updateEntitiesTests {

    /**
     * Utility to copy an array
     * @param source 2D array to copy
     * @return Deep copy of the array
     */
    public static double[][] copy2DArray(double[][] source) {
        double[][] copy = new double[source.length][];
        for(int i=0;i<source.length;i++) {
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return copy;
    }

    /**
     *
     * @param p1 One coordinate
     * @param p2 Another coordinate
     * @param threshold Threshold to check
     * @return true if p1 is within threshold of p2
     */
    public static boolean checkDistance(double p1, double p2, double threshold) {
        return Math.abs(p1-p2)<=threshold;
    }

    /**
     * Move a single nonzombie repeatedly.  Verify that it never moves more than .005 in any single direction
     * and that it moves along all directions.
     */
    @Test
    public void testSingleNonzombieMotion() {
        double entities[][] = {{2, 0.5, 0.5}};
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;


        for(int i=0;i<100;i++) {
            double[][] original = copy2DArray(entities);

            // Update the positions
            ZombieSimulator.updateEntities(entities);

            // Check the the X coordinate changed
            assertTrue(entities[0][1]!=original[0][1]);
            // Check the the Y coordinate changed
            assertTrue(entities[0][2]!=original[0][2]);

            // Check the the X coordinate didn't change too much
            assertTrue(checkDistance(entities[0][1], original[0][1], .005));

            // Check the the Y coordinate didn't change too much
            assertTrue(checkDistance(entities[0][2], original[0][2], .005));

            // Check if it moved right
            if(entities[0][1]>original[0][1])
                right = true;
            // Check if it moved left
            if(entities[0][1]<original[0][1])
                left = true;
            // Check if it moved up
            if(entities[0][2]>original[0][2])
                up = true;
            // Check if it moved down
            if(entities[0][2]<original[0][2])
                down = true;
        }
        // Check that it moved left at least once
        assertTrue(left);
        // Check that it moved right at least once
        assertTrue(right);
        // Check that it moved up at least once
        assertTrue(up);
        // Check that it moved down at least once
        assertTrue(down);
    }

    /**
     * Move a single zombie repeatedly.  Verify that it never moves more than .005 in any single direction
     * and that it moves along all directions.
     */
    @Test
    public void testSingleZombieMotion() {
        double entities[][] = {{1, 0.5, 0.5}};
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;


        for(int i=0;i<100;i++) {
            double[][] original = copy2DArray(entities);

            // Update the positions
            ZombieSimulator.updateEntities(entities);

            // Check the the X coordinate changed
            assertTrue(entities[0][1]!=original[0][1]);
            // Check the the Y coordinate changed
            assertTrue(entities[0][2]!=original[0][2]);

            // Check the the X coordinate didn't change too much
            assertTrue(checkDistance(entities[0][1], original[0][1], .005));

            // Check the the Y coordinate didn't change too much
            assertTrue(checkDistance(entities[0][2], original[0][2], .005));

            // Check if it moved right
            if(entities[0][1]>original[0][1])
                right = true;
            // Check if it moved left
            if(entities[0][1]<original[0][1])
                left = true;
            // Check if it moved up
            if(entities[0][2]>original[0][2])
                up = true;
            // Check if it moved down
            if(entities[0][2]<original[0][2])
                down = true;
        }
        // Check that it moved left at least once
        assertTrue(left);
        // Check that it moved right at least once
        assertTrue(right);
        // Check that it moved up at least once
        assertTrue(up);
        // Check that it moved down at least once
        assertTrue(down);
    }

    /**
     * Move zombies that are near the screen boarders.  Verify that none ever leave the screen.
     */
    @Test
    public void testZombiesStayingInBoundariesOneStep() {
        double entities[][] = {
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
        };

        for(int i=0;i<100;i++) {
            double[][] testArray = copy2DArray(entities);
            // Update the positions
            ZombieSimulator.updateEntities(entities);
            for(int j=0;j<entities.length;j++) {
                // Check if x>=0
                assertTrue(entities[j][1]>=0);
                // Check if x<=1
                assertTrue(entities[j][1]<=1.0);
                // Check if y>=0
                assertTrue(entities[j][2]>=0);
                // Check if y<=1
                assertTrue(entities[j][2]<=1.0);
            }
        }
    }

    /**
     * Move nonzombies that are near the screen boarders.  Verify that none ever leave the screen.
     */
    @Test
    public void testNonzombiesStayingInBoundariesOneStep() {
        double entities[][] = {
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
        };

        for(int i=0;i<100;i++) {
            double[][] testArray = copy2DArray(entities);
            // Update the positions
            ZombieSimulator.updateEntities(entities);
            for(int j=0;j<entities.length;j++) {
                // Check if x>=0
                assertTrue(entities[j][1]>=0);
                // Check if x<=1
                assertTrue(entities[j][1]<=1.0);
                // Check if y>=0
                assertTrue(entities[j][2]>=0);
                // Check if y<=1
                assertTrue(entities[j][2]<=1.0);
            }
        }
    }

    /**
     * Move zombies that are near the screen boarders for several steps.  Verify that none ever leave the screen.
     */
    @Test
    public void testZombiesStayingInBoundariesMultiStep() {
        double entities[][] = {
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
                {1, 0.0001, .9999},
                {1, 0.0001, .0001},
                {1, 0.9999, .0001},
                {1, 0.9999, .9999},
                {1, 0.5, .9999},
                {1, 0.5, .0001},
                {1, 0.9999, 0.5},
                {1, 0.9999, 0.5},
        };

        for(int i=0;i<200;i++) {
            // Update the positions
            ZombieSimulator.updateEntities(entities);
            for(int j=0;j<entities.length;j++) {
                // Check if x>=0
                assertTrue(entities[j][1]>=0);
                // Check if x<=1
                assertTrue(entities[j][1]<=1.0);
                // Check if y>=0
                assertTrue(entities[j][2]>=0);
                // Check if y<=1
                assertTrue(entities[j][2]<=1.0);
            }
        }
    }

    /**
     * Move nonzombies that are near the screen boarders repeatedly.  Verify that none ever leave the screen.
     */
    @Test
    public void testNonzombiesStayingInBoundariesMultiStep() {
        double entities[][] = {
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
                {2, 0.0001, .9999},
                {2, 0.0001, .0001},
                {2, 0.9999, .0001},
                {2, 0.9999, .9999},
                {2, 0.5, .9999},
                {2, 0.5, .0001},
                {2, 0.9999, 0.5},
                {2, 0.9999, 0.5},
        };

        for(int i=0;i<200;i++) {
            // Update the positions
            ZombieSimulator.updateEntities(entities);
            for(int j=0;j<entities.length;j++) {
                // Check if x>=0
                assertTrue(entities[j][1]>=0);
                // Check if x<=1
                assertTrue(entities[j][1]<=1.0);
                // Check if y>=0
                assertTrue(entities[j][2]>=0);
                // Check if y<=1
                assertTrue(entities[j][2]<=1.0);
            }
        }
    }

    /**
     * Put a zombie in the middle of non-zombies.  Confirm that one of them changes to a zombie
     */
    @Test
    public void testNonZombieToZombie1() {
        double entities[][] = {
                {1, 0.5, 0.5},  // Zombie

                {2, 0.5, 0.5},
                {2, 0.5+0.002, 0.5},
                {2, 0.5-0.002, 0.5},
                {2, 0.5, 0.5+.002},
                {2, 0.5, 0.5-.002},
        };
        ZombieSimulator.updateEntities(entities);

        int zombies = 0;
        for(int i=0;i<entities.length;i++) {
            if(entities[i][0] == 1)
                zombies++;
        }
        // Verify that one of the non-zombies is now a zombie
        assertTrue(zombies>1);
    }

    /**
     * Put a zombie in the middle of non-zombies.  Confirm that one of them changes to a zombie
     */
    @Test
    public void testNonZombieToZombie2() {
        double entities[][] = {

                {2, 0.5, 0.5},
                {2, 0.5+0.002, 0.5},

                {1, 0.5, 0.5},  // Zombie

                {2, 0.5-0.002, 0.5},
                {2, 0.5, 0.5+.002},
                {2, 0.5, 0.5-.002},
        };
        ZombieSimulator.updateEntities(entities);

        int zombies = 0;
        for(int i=0;i<entities.length;i++) {
            if(entities[i][0] == 1)
                zombies++;
        }
        // Verify that one of the non-zombies is now a zombie
        assertTrue(zombies>1);
    }

    /**
     * Verify that a world with only non-zombies will not spontaneously create a zombie.
     */
    @Test
    public void testOnlyNonZombies() {
        double entities[][] = {

                {2, 0.5, 0.5},
                {2, 0.5+0.002, 0.5},
                {2, 0.5, 0.5},
                {2, 0.5-0.002, 0.5},
                {2, 0.5, 0.5+.002},
                {2, 0.5, 0.5-.002},
        };
        ZombieSimulator.updateEntities(entities);

        int zombies = 0;
        for(int i=0;i<entities.length;i++) {
            if(entities[i][0] == 1)
                zombies++;
        }
        // Verify that one of the non-zombies is now a zombie
        assertTrue(zombies==0);
    }


    /**
     * Verify that a world with only zombies stays only zombies.
     */
    @Test
    public void testOnlyZombies() {
        double entities[][] = {

                {1, 0.5, 0.5},
                {1, 0.5+0.002, 0.5},
                {1, 0.5, 0.5},
                {1, 0.5-0.002, 0.5},
                {1, 0.5, 0.5+.002},
                {1, 0.5, 0.5-.002},
        };
        ZombieSimulator.updateEntities(entities);

        int zombies = 0;
        for(int i=0;i<entities.length;i++) {
            if(entities[i][0] == 1)
                zombies++;
        }
        // Verify that one of the non-zombies is now a zombie
        assertTrue(zombies==entities.length);
    }
}
