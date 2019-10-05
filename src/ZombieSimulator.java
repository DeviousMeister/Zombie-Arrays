import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.In;
import support.cse131.ArgsProcessor;
import java.awt.*;


/**
 * A Zombie Simulator!
 */
public class ZombieSimulator {
    // Constant values to use when accessing columns of "entities" arrays.
    static final int TYPE = 0;
    static final int X = 1;
    static final int Y = 2;

    // Constant values to use when checking/setting somethings type
    static final int ZOMBIE = 1;
    static final int NONZOMBIE = 2;

    /**
     * Read entities from a file and return an array of Entities.
     *
     * Each row of the returned array represents one entity.  Column [TYPE] indicates the type
     * of entity (1 or ZOMBIE for zombies, 2 or NONZOMBIE for non-zombies),
     * Column [X] is the x coordinate and Column [Y] is the y coordinate.
     *
     * @param fileName the name of the file to read
     * @return a 2D array of entities.  Each row corresponds to an entity
     */
    public static double[][] readEntities(String fileName) {

        // TODO: Implement this function (you can probably adjust code from Lab 4)

        // Return a 2D array of entities
        return null;  // FIXME: Replace this: Return the array of entities
    }

    /**
     * Draw all the entities.  Zombies are drawn with filled red filled circles of radius 0.005 and
     * non-zombies with filled black filled circles of radius 0.005)
     *
     * @param entities a 2D array of entities.  Each row corresponds to an entity.
     */
    public static void drawEntities(double[][] entities) {
        // DONE: Clear the frame
        StdDraw.clear();

        // TODO: Write the loop that displays all the entities (you can probably adjust code from Lab 4)


        // DONE: Show everything that was drawn (show the updated frame).  This should be the only "show()" command!
        StdDraw.show();
    }


    /**
     * Check if the entity at the given index is touching a zombie.
     * (HINT: You know the location of the center of each entity and 
     *        that they all have a radius of 0.005.  If the circles
     *        representing two entities overlap the are considered to be 
     *        touching.  Consider using the distance formula)
     *
     * @param index the index of the entity to check
     * @param entities a 2D array of entities.  Each row corresponds to an entity.
     * @return true if the entity at index is touching a zombie
     */
    public static boolean touchingZombie(int index, double[][] entities) {
        // TODO: Complete this method 

        return false; // FIXME: Replace this so it returns the value of interest
    }

    /**
     * Update the locations of all entities (assume brownian motion)
     *
     * The rules for an update are:
     *     Each entity should move by a random value between -0.005 and 0.005 in the x coordinate
     *     and between -0.005 and 0.005 in the Y coordinate.
     *    
     *     Entities should not be able to leave the screen. x and y coordinates should be kept between [0-1.0]
     *
     *     If a non-zombie is touching a zombie it should change to a zombie.
     *     (HINT: you need to check all entities. On each one that is NOT a zombie, you can re-use code
     *            you've already written to see if it's "touching" a Zombie and, if so, change it to a zombie.)
     *
     * @param entities a 2D array of entities.  Each row corresponds to an entity.
     */
    public static void updateEntities(double[][] entities) {
        // TODO: Complete this method: It should update the positions of items in the entities array


        // Note: No return value.  This "returns" when it hits the end }.
    }


    /**
     * Return the number of nonzombies remaining
     *
     * @param entities  a 2D array of entities.  Each row corresponds to an entity.
     * @return TODO: This should briefly explain what the returned value means
     */
    // TODO: Figure out the types to use below and uncomment the line (and the line for the return and ending } )
//    public static TYPE nonzombieCount(TYPE entities) {
//    // TODO: complete this method
//
//        return 0; // FIXME: Replace this so it returns the value of interest
//     }


    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();   // Enable double buffering

        ArgsProcessor ap = new ArgsProcessor(args);
        String fileName = ap.nextString("Which starting file?");

        // Read in the file & display the world for 1s
        double[][] entities = readEntities(fileName);
        drawEntities(entities);
        StdDraw.pause(1000);

        // TODO: Write the loop that will run the simulation.
        //   Continue if there are nonzombies
        //   Update positions
        //   Redraw things
    }

}
