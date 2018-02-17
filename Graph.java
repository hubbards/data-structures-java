import java.util.HashMap;
import java.util.Iterator;
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
     * @param tail
     * the tail of the given edge
     * 
     * @param head
     * the head of the given edge
     * 
     * @throws GraphException
     * if graph does not contain the end-points of the given edge or the given
     * edge is a multiple edge
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
     * @param name
     * the name of the given vertex
     * 
     * @throws GraphException
     * if this graph already contains the given vertex
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
     * @param name
     * the name of the given vertex
     * 
     * @return
     * <code>true</code> if this graph contains the given vertex, otherwise
     * <code>false</code>
     */
    public boolean containsVertex(String name) {
        return map.containsKey(name);
    }

    /**
     * Checks if this graph contains a given edge.
     * 
     * @param tail
     * the tail of the given edge
     * 
     * @param head
     * the head of the given edge
     * 
     * @return
     * <code>true</code> if this graph contains the given edge, otherwise
     * <code>false</code>
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

    /**
     * Prints the adjacency list representation of this graph.
     */
    public void printAdjacencyList() {
        System.out.print("vertex: adjacency list:\n");
        for (Vertex u : map.values()) {
            // print vertex v
            System.out.printf("%-3.3s     ", u.name);
            // print adjacency list for vertex v
            Iterator<Vertex> i = u.adj.iterator();
            if (i.hasNext()) {
                Vertex v = i.next();
                System.out.printf("%-3.3s", v.name);
                while (i.hasNext()) {
                    v = i.next();
                    System.out.printf(" --> %-3.3s", v.name);
                }
                System.out.print("\n");
            } else {
                System.out.print("null\n");
            }
        }
    }

    /**
     * Prints the adjacency matrix representation of this graph.
     */
    public void printAdjacencyMatrix() {
        // index vertices of graph
        Vertex[] v = map.values().toArray(new Vertex[0]);
        // print column indices
        System.out.print("   ");
        for (int i = 0; i < v.length; i++) {
            System.out.printf(" %-3.3s", v[i].name);
        }
        System.out.print("\n");
        // print rows of adjacency matrix
        for (int i = 0; i < v.length; i++) {
            // print row index
            System.out.printf("%-3.3s", v[i].name);
            // print row i of adjacency matrix
            for (int j = 0; j < v.length; j++) {
                if (containsEdge(v[i].name, v[j].name)) {
                    // vertex i is adjacent to vertex j
                    System.out.printf(" %-3d", 1);
                } else {
                    // vertex i is not adjacent to vertex j
                    System.out.printf(" %-3d", 0);
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Prints the incidence matrix of this graph.
     */
    public void printIncidenceMatrix() {
        // index vertices of graph
        Vertex[] u = map.values().toArray(new Vertex[0]);
        // index edges of graph
        Vertex[][] v = new Vertex[u.length][];
        for (int i = 0; i < u.length; i++) {
            v[i] = u[i].adj.toArray(new Vertex[0]);
        }
        // print column indices (edges)
        System.out.print("   ");
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.printf(" (%-3.3s, %-3.3s)", u[i].name, v[i][j].name);
            }
        }
        System.out.print("\n");
        // print rows of incidence matrix
        for (int i = 0; i < u.length; i++) {
            // print row index (vertex)
            System.out.printf("%-3.3s", u[i].name);
            // print row i of incidence matrix
            for (int j = 0; j < u.length; j++) {
                for (int k = 0; k < v[j].length; k++) {
                    if (j == i) {
                        // vertex i is incident to edge (j, k)
                        System.out.printf(" %-10d", 1);
                    } else {
                        // vertex i is not incident to edge (j, k)
                        System.out.printf(" %-10d", 0);
                    }
                }
            }
            System.out.print("\n");
        }
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
    private static class Vertex {
        public final String name; // name of this vertex
        public List<Vertex> adj; // adjacency list for this vertex

        public Vertex(String name) {
            this.name = name;
            adj = new LinkedList<Vertex>();
        }
    }
}
