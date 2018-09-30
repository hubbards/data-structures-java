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
        System.out.println("Example of graph:");
        System.out.println();

        Graph g = new Graph();
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");
        g.addVertex("f");
        g.addVertex("g");
        g.addEdge("a", "d");
        g.addEdge("a", "e");
        g.addEdge("a", "g");
        g.addEdge("b", "c");
        g.addEdge("b", "e");
        g.addEdge("b", "f");
        g.addEdge("c", "d");
        g.addEdge("c", "e");
        g.addEdge("d", "e");
        g.addEdge("e", "f");
        g.addEdge("e", "g");
        g.addEdge("f", "g");

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
