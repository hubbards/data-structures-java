package com.github.hubbards.data.structures.graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link Graph}.
 *
 * @author Spencer Hubbard
 */
public class GraphTest {
    @Test(expected = GraphException.class)
    public void addVertex1() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("a");
    }

    @Test
    public void containsVertex1() {
        Graph graph = new Graph();

        assertFalse(graph.containsVertex("a"));
    }

    @Test
    public void containsVertex2() {
        Graph graph = new Graph();

        graph.addVertex("a");

        assertTrue(graph.containsVertex("a"));
        assertFalse(graph.containsVertex("b"));
    }

    @Test
    public void testContainsVertex3() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");

        assertTrue(graph.containsVertex("a"));
        assertTrue(graph.containsVertex("b"));
    }

    @Test
    public void testContainsVertex4() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");

        graph.addEdge("a", "b");

        assertTrue(graph.containsVertex("a"));
        assertTrue(graph.containsVertex("b"));
    }

    @Test
    public void testContainsVertex5() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");

        graph.addEdge("a", "b");

        graph.addVertex("c");

        assertTrue(graph.containsVertex("a"));
        assertTrue(graph.containsVertex("b"));
        assertTrue(graph.containsVertex("c"));
    }

    @Test
    public void testContainsEdge1() {
        Graph graph = new Graph();

        assertFalse(graph.containsEdge("a", "b"));
    }

    @Test
    public void testContainsEdge2() {
        Graph graph = new Graph();

        graph.addVertex("a");

        assertFalse(graph.containsEdge("a", "a"));
    }

    @Test
    public void testContainsEdge3() {
        Graph graph = new Graph();

        graph.addVertex("a");

        graph.addEdge("a", "a");

        assertTrue(graph.containsEdge("a", "a"));
    }

    @Test
    public void testContainsEdge4() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");

        graph.addEdge("a", "b");

        assertTrue(graph.containsEdge("a", "b"));
        assertFalse(graph.containsEdge("b", "a"));
    }

    @Test
    public void testContainsEdge5() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");

        graph.addEdge("a", "b");
        graph.addEdge("b", "c");

        assertTrue(graph.containsEdge("a", "b"));
        assertTrue(graph.containsEdge("b", "c"));
        assertFalse(graph.containsEdge("a", "c"));
    }
}
