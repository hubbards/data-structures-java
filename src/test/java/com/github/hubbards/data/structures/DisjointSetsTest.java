package com.github.hubbards.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link DisjointSets}.
 *
 * @author Spencer Hubbard
 */
public class DisjointSetsTest {
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrows1() {
        new DisjointSets(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrows2() {
        new DisjointSets(-1);
    }

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnionThrows1() {
        DisjointSets ds = new DisjointSets(2);

        ds.union(-1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnionThrows2() {
        DisjointSets ds = new DisjointSets(3);

        ds.union(0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnionThrows3() {
        DisjointSets ds = new DisjointSets(3);

        ds.union(3, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnionThrows4() {
        DisjointSets ds = new DisjointSets(3);

        ds.union(0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnionThrows5() {
        DisjointSets ds = new DisjointSets(3);

        ds.union(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnionThrows6() {
        DisjointSets ds = new DisjointSets(3);

        ds.union(0, 1);
        ds.union(1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnionThrows7() {
        DisjointSets ds = new DisjointSets(3);

        ds.union(0, 1);
        ds.union(2, 1);
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

    @Test
    public void testUnion3() {
        DisjointSets ds = new DisjointSets(4);
        ds.union(0, 1);
        ds.union(ds.find(1), 2);

        assertEquals(ds.find(0), ds.find(1));
        assertEquals(ds.find(0), ds.find(2));
        assertNotEquals(ds.find(0), ds.find(3));
    }

    // TODO: write more tests
}
