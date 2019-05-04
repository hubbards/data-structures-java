package com.github.hubbards.data.structures;

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
    public void testFind1() {
        DisjointSets ds = new DisjointSets(1);

        assertEquals(0, ds.find(0));
    }

    @Test
    public void testFind2() {
        DisjointSets ds = new DisjointSets(3);

        assertEquals(0, ds.find(0));
        assertEquals(1, ds.find(1));
    }

    @Test
    public void testUnion1() {
        DisjointSets ds = new DisjointSets(2);
        ds.union(0, 1);

        assertEquals(ds.find(0), ds.find(1));
    }

    @Test
    public void testUnion2() {
        DisjointSets ds = new DisjointSets(3);
        ds.union(0, 1);

        assertEquals(ds.find(0), ds.find(1));
        assertNotEquals(ds.find(0), ds.find(2));
    }

    // TODO: write more tests
}
