import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;


/**
 * Methods that test the nonzombieCount() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class nonzombieCountTests {


    // /**
    //  * Test a single nonzombie (and a single entity)
    //  */
    // @Test
    // public void testSingleEntitySingleSurvivor() {
    //     double[][] entities = {{ 2, 0.5, 0.5 }};
    //     assertEquals(1, ZombieSimulator.nonzombieCount(entities));
    // }

    // /**
    //  * Test a single zombie (and a single entity)
    //  */
    // @Test
    // public void testSingleEntityNoSurvivor() {
    //     double[][] entities = {{ 1, 0.5, 0.5 }};
    //     assertEquals(0, ZombieSimulator.nonzombieCount(entities));
    // }

    // /**
    //  * Test two entities and no nonzombies
    //  */
    // @Test
    // public void testTwoEntitiesTwoSurvivors() {
    //     double[][] entities = {{ 1, 0.5, 0.5 }, { 1, 0.75, 0.5 }};
    //     assertEquals(0, ZombieSimulator.nonzombieCount(entities));
    // }


    // /**
    //  * Test two entities and two nonzombies
    //  */
    // @Test
    // public void testTwoEntitiesNoSurvivors() {
    //     double[][] entities = {{ 2, 0.5, 0.5 }, { 2, 0.75, 0.5 }};
    //     assertEquals(2, ZombieSimulator.nonzombieCount(entities));
    // }

    // /**
    //  * Test two entities and one nonzombie
    //  */
    // @Test
    // public void testTwoEntitiesFirstSurvives() {
    //     double[][] entities = {{ 2, 0.5, 0.5 }, { 1, 0.75, 0.5 }};
    //     assertEquals(1, ZombieSimulator.nonzombieCount(entities));
    // }

    // /**
    //  * Test two entities and one nonzombie
    //  */
    // @Test
    // public void testTwoEntitiesSecondSurvives() {
    //     double[][] entities = {{ 1, 0.5, 0.5 }, { 2, 0.75, 0.5 }};
    //     assertEquals(1, ZombieSimulator.nonzombieCount(entities));
    // }

    // /**
    //  * Test 100 entities and 50 nonzombies
    //  */
    // @Test
    // public void testOneHundredEntitiesFiftySurvive() {
    //     double[][] entities = new double[100][3];
    //     for(int i=0;i<entities.length;i++) {
    //         entities[i][0] = i%2==0 ? 1 : 2;
    //     }
    //     assertEquals(50, ZombieSimulator.nonzombieCount(entities));
    // }
}
