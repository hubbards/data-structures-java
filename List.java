/**
 * This interface represents a generic interface for the list ADT.
 * 
 * @author
 * Spencer Hubbard
 *
 * @param <E>
 * the element type of this list
 */
public interface List<E> extends Iterable<E> {
    /**
     * Returns the number of elements in this list or
     * <code>Integer.MAX_VALUE</code> if the number of elements in this list is
     * more than <code>Integer.MAX_VALUE</code>.
     * 
     * @return
     * the number of elements in this list
     */
    public int size();

    /**
     * Finds the element at a given index in this list.
     * 
     * @param index
     * the index of the element to find
     * 
     * @return
     * the element at the given index in this list
     * 
     * @throws IndexOutOfBoundsException
     * if the given index is negative or at least the size of this list
     */
    public E get(int index);

    /**
     * Finds the index of the first occurrence of a given value in this list.
     * 
     * @param value
     * the value to find
     * 
     * @return
     * the index of the first occurrence of the given value or <code>-1</code>
     * if this list does not contain the given value
     */
    public int indexOf(E value);

    /**
     * Checks if this list is empty.
     * 
     * @return
     * <code>true</code> if this list is empty, otherwise <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Checks if this list contains a given value.
     * 
     * @param value
     * the value to check
     * 
     * @return
     * <code>true</code> if this list contains the given value, otherwise
     * <code>false</code>
     */
    public boolean contains(E value);

    /**
     * Adds a given value to the end of this list.
     * 
     * @param value
     * the value to add
     */
    public void add(E value);

    /**
     * Adds a given value at a given index in this list.
     * 
     * @param index
     * the given index
     * 
     * @param value
     * the value to add
     * 
     * @throws IndexOutOfBoundsException
     * if the given index is negative or greater than the size of this list
     */
    public void add(int index, E value);

    /**
     * Appends the elements of a given list to the end of this list.
     * 
     * @param other
     * the other list to add
     */
    public void addAll(List<E> other);

    /**
     * Removes the element at a given index in this list.
     * 
     * @param index
     * the given index
     * 
     * @throws IndexOutOfBoundsException
     * if the given index is negative or at least the size of this list
     */
    public void remove(int index);

    /**
     * Sets the value of the element at a given index in this list to a given
     * value.
     * 
     * @param index
     * the given index
     * 
     * @param value
     * the value to set
     * 
     * @throws IndexOutOfBoundsException
     * if the given index is negative or at least the size of this list
     */
    public void set(int index, E value);

    /**
     * Removes all elements from this list.
     */
    public void clear();
}
