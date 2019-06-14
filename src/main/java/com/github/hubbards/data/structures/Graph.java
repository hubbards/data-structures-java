package com.github.hubbards.data.structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a directed graph with no multiple edge.
 *
 * @author Spencer Hubbard
 */
public class Graph {
    // map name of vertex to vertex object
    private Map<String, Vertex> map;

    /**
     * Constructs a graph object.
     */
    public Graph() {
        map = new HashMap<String, Vertex>();
    }

    /**
     * Adds a given edge to this graph.
     *
     * @param tail the tail of the given edge
     * @param head the head of the given edge
     *
     * @throws GraphException if graph does not contain the end-points of the
     * given edge or the given edge is a multiple edge
     */
    public void addEdge(String tail, String head) {
        // check preconditions
        if (containsEdge(tail, head)) {
            throw new GraphException("multiple edge");
        }
        checkVertex(tail);
        checkVertex(head);
        // add edge to graph
        Vertex u = map.get(tail);
        Vertex v = map.get(head);
        u.adj.add(v);
    }

    /**
     * Adds a given vertex (or node) to this graph.
     *
     * @param name the name of the given vertex
     *
     * @throws GraphException if this graph already contains the given vertex
     */
    public void addVertex(String name) {
        // check preconditions
        if (containsVertex(name)) {
            throw new GraphException();
        }
        // add vertex to graph
        Vertex v = new Vertex(name);
        map.put(name, v);
    }

    /**
     * Checks if this graph contains a given vertex.
     *
     * @param name the name of the given vertex
     *
     * @return <code>true</code> if this graph contains the given vertex,
     * otherwise <code>false</code>
     */
    public boolean containsVertex(String name) {
        return map.containsKey(name);
    }

    /**
     * Checks if this graph contains a given edge.
     *
     * @param tail the tail of the given edge
     * @param head the head of the given edge
     *
     * @return <code>true</code> if this graph contains the given edge,
     * otherwise <code>false</code>
     */
    public boolean containsEdge(String tail, String head) {
        if (containsVertex(tail) && containsVertex(head)) {
            // graph contains end-points
            Vertex u = map.get(tail);
            for (Vertex v : u.adj) {
                if (head.equals(v.name)) {
                    // u and v are adjacent
                    return true;
                }
            }
        }
        // graph does not contain edge
        return false;
    }

    /*
     * Throws exception if this graph does not contain a given vertex.
     */
    private void checkVertex(String name) throws GraphException {
        if (!containsVertex(name)) {
            throw new GraphException("vertex not found");
        }
    }

    /*
     * This inner class represents a vertex (or node) of a graph.
     */
    private class Vertex {
        // name of this vertex
        public final String name;
        // adjacency list for this vertex
        public List<Vertex> adj;

        public Vertex(String name) {
            this.name = name;
            adj = new LinkedList<Vertex>();
        }
    }
}
