/**
 * This abstract class represents a generic abstract class for the list ADT.
 * 
 * @author Spencer Hubbard
 */
public abstract class AbstractList<E> implements List<E> {
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    /*
     * Throws an exception if a given index is illegal.
     */
    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
}
