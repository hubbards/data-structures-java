/**
 * This class represents a runtime exception that indicates violation of a
 * precondition of a graph method, e.g., loop or multiple edge.
 * 
 * @author Spencer Hubbard
 */
@SuppressWarnings("serial")
public class GraphException extends RuntimeException {
    /**
     * Constructs a new graph exception.
     */
    public GraphException() {
        super();
    }

    /**
     * Constructs a new graph exception with a given message.
     * 
     * @param message
     * the given message
     */
    public GraphException(String message) {
        super(message);
    }
}
