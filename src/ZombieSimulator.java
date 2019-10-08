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
     * <p>
     * Each row of the returned array represents one entity.  Column [TYPE] indicates the type
     * of entity (1 or ZOMBIE for zombies, 2 or NONZOMBIE for non-zombies),
     * Column [X] is the x coordinate and Column [Y] is the y coordinate.
     *
     * @param fileName the name of the file to read
     * @return a 2D array of entities.  Each row corresponds to an entity
     */
    public static double[][] readEntities(String fileName) {
        In inFile = new In(fileName);
        int numEntities = inFile.readInt();
        double[][] entities = new double[numEntities][3];
        for (int i = 0; i < entities.length; ++i) {
            entities[i][TYPE] = inFile.readInt();
            entities[i][X] = inFile.readDouble();
            entities[i][Y] = inFile.readDouble();
        }
        return entities;
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
        for (int i = 0; i < entities.length; ++i) {
            if (entities[i][TYPE] == 1) {
                StdDraw.setPenColor(Color.RED);
                StdDraw.filledCircle(entities[i][X], entities[i][Y], 0.005);
            } else if (entities[i][TYPE] == 2) {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.filledCircle(entities[i][X], entities[i][Y], 0.005);
            }
        }
        StdDraw.show();
    }
    /**
     * Check if the entity at the given index is touching a zombie.
     * (HINT: You know the location of the center of each entity and
     * that they all have a radius of 0.005.  If the circles
     * representing two entities overlap the are considered to be
     * touching.  Consider using the distance formula)
     *
     * @param index    the index of the entity to check
     * @param entities a 2D array of entities.  Each row corresponds to an entity.
     * @return true if the entity at index is touching a zombie
     */
    public static boolean touchingZombie(int index, double[][] entities) {
        for (int i = 0; i < entities.length; ++i) {
            double x1 = entities[index][X];
            double y1 = entities[index][Y];
            if (entities[i][TYPE] == ZOMBIE) {
                double x2 = entities[i][X];
                double y2 = entities[i][Y];
                double xDifference = Math.pow((x2 - x1), 2.0);
                double yDifference = Math.pow((y2 - y1), 2.0);
                double totDistance = Math.sqrt(xDifference + yDifference);
                if (totDistance <= 0.01) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Update the locations of all entities (assume brownian motion)
     * <p>
     * The rules for an update are:
     * Each entity should move by a random value between -0.005 and 0.005 in the x coordinate
     * and between -0.005 and 0.005 in the Y coordinate.
     * <p>
     * Entities should not be able to leave the screen. x and y coordinates should be kept between [0-1.0]
     * <p>
     * If a non-zombie is touching a zombie it should change to a zombie.
     * (HINT: you need to check all entities. On each one that is NOT a zombie, you can re-use code
     * you've already written to see if it's "touching" a Zombie and, if so, change it to a zombie.)
     *
     * @param entities a 2D array of entities.  Each row corresponds to an entity.
     */
    public static void updateEntities(double[][] entities) {
        for (int i = 0; i < entities.length; ++i) {
            double newX = entities[i][X] + ((Math.random() * 0.01)-0.005);
            double newY = entities[i][Y] + ((Math.random() * 0.01)-0.005);
            if(newX>=0 && newX<=1 ){
                entities[i][X] = newX;
            }
            if(newY>=0 && newY<=1){
                entities[i][Y] = newY;
            }
            if(touchingZombie(i, entities) && entities[i][TYPE]==NONZOMBIE){
                entities[i][TYPE] = ZOMBIE;
            }
        }
    }
    /**
     * Return the number of nonzombies remaining
     *
     * @param entities a 2D array of entities.  Each row corresponds to an entity.
     * @return
     */
    public static int nonzombieCount(double [][]entities) {
        int nonZombie = 0;
        for (int i = 0; i < entities.length; ++i) {
            if (entities[i][TYPE] == NONZOMBIE) {
                nonZombie = nonZombie + 1;
            }
        }
        return nonZombie;
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();   // Enable double buffering

        ArgsProcessor ap = new ArgsProcessor(args);
        String fileName = ap.nextString("Which starting file?");

        // Read in the file & display the world for 1s
        double[][] entities = readEntities(fileName);
        drawEntities(entities);
        StdDraw.pause(1000);

        while(nonzombieCount(entities)!=0){
            updateEntities(entities);
            drawEntities(entities);
        }
    }
}
