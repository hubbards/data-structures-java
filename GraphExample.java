import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program contains a simple example of a directed graph with no multiple
 * edges. This program also contains a method for reading a graph from a given
 * input file.
 * 
 * @author Spencer Hubbard
 */
public class GraphExample {
    public static void main(String[] args) {
        // simple example
        System.out.println("Example of graph:");
        System.out.println();

        Graph g = new Graph();
        g.addVertex("a"); // a or 1
        g.addVertex("b"); // b or 2
        g.addVertex("c"); // c or 3
        g.addVertex("d"); // d or 4
        g.addVertex("e"); // e or 5
        g.addVertex("f"); // f or 6
        g.addVertex("g"); // g or 7
        g.addEdge("a", "d"); // (a, d) or (1, 4)
        g.addEdge("a", "e"); // (a, e) or (1, 5)
        g.addEdge("a", "g"); // (a, g) or (1, 7)
        g.addEdge("b", "c"); // (b, c) or (2, 3)
        g.addEdge("b", "e"); // (b, e) or (2, 5)
        g.addEdge("b", "f"); // (b, f) or (2, 6)
        g.addEdge("c", "d"); // (c, d) or (3, 4)
        g.addEdge("c", "e"); // (c, e) or (3, 5)
        g.addEdge("d", "e"); // (d, e) or (4, 5)
        g.addEdge("e", "f"); // (e, f) or (5, 6)
        g.addEdge("e", "g"); // (e, g) or (5, 7)
        g.addEdge("f", "g"); // (f, g) or (6, 7)

        System.out.println("Adjacency List:");
        g.printAdjacencyList();
        System.out.println();

        System.out.println("Adjacency Matrix:");
        g.printAdjacencyMatrix();
        System.out.println();

        System.out.println("Incidence Matrix:");
        g.printIncidenceMatrix();
        System.out.println();
    }

    /**
     * Reads and returns a graph specified by give input files.
     * 
     * @param vertex
     * the name of the given vertex file
     * 
     * @param edge
     * the name of the given edge file
     * 
     * @return
     * graph specified by the given input files
     * 
     * @throws FileNotFoundException
     * if the given input files cannot be found
     */
    @SuppressWarnings("resource")
    public static Graph readGraph(String vertex, String edge) throws FileNotFoundException {
        Graph g = new Graph();
        Scanner input;

        // read vertex file
        // assume each token in vertex file is distinct vertex name
        input = new Scanner(new File(vertex));
        while (input.hasNext()) {
            // parse next token
            String name = input.next(); // vertex name
            g.addVertex(name);
        }

        // read edge file
        // assume each line of edge file has two tokens for tail and head name
        input = new Scanner(new File(edge));
        while (input.hasNextLine()) {
            // read next line of edge file
            Scanner line = new Scanner(input.nextLine());
            // parse next two tokens
            String tail = line.next(); // tail name
            String head = line.next(); // head name
            g.addEdge(tail, head);
        }

        return g;
    }
}
