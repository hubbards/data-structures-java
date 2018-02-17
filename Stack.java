/**
 * This class represents a generic interface for the (LIFO or FILO) stack ADT.
 * 
 * @author Spencer Hubbard
 *
 * @param <E>
 * the element type of this stack
 */
public interface Stack<E> {
    /**
     * Checks if this stack is empty.
     * 
     * @return
     * <code>true</code> if this queue is empty, otherwise <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Adds a given value to the top of this stack.
     * 
     * @param value
     * the value to add
     */
    public void push(E value);

    /**
     * Returns and removes the value at the top of this stack.
     * 
     * @return
     * the value at the top of this stack
     * 
     * @throws EmptyStackException
     * if this stack is empty
     */
    public E pop();
}
