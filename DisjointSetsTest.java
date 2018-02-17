import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This program is a simple test suit for the disjoint sets ADT.
 *
 * @see DisjointSets
 *
 * @author Spencer Hubbard
 */
public class DisjointSetsTest {

    @Test
    public void findTest1() {
        DisjointSets ds = new DisjointSets(1);
        assertEquals(0, ds.find(0));
    }

    @Test
    public void findTest2() {
        DisjointSets ds = new DisjointSets(3);
        assertEquals(0, ds.find(0));
        assertEquals(1, ds.find(1));
    }

    @Test
    public void unionTest1() {
        DisjointSets ds = new DisjointSets(2);
        ds.union(0, 1);
        assertTrue(ds.find(0) == ds.find(1));
    }

    @Test
    public void unionTest2() {
        DisjointSets ds = new DisjointSets(3);
        ds.union(0, 1);
        assertTrue(ds.find(0) == ds.find(1));
        assertFalse(ds.find(0) == ds.find(2));
    }
}
