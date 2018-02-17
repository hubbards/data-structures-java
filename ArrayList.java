import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a generic array implementation of the list ADT.
 * 
 * @author Spencer Hubbard
 */
public class ArrayList<E> extends AbstractList<E> {
    public static final int DEFAULT_CAPACITY = 100;

    private E[] elementData; // values stored in list
    private int size; // number of elements in list

    /**
     * Constructs an empty list with default capacity.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list with a given capacity.
     * 
     * @param capacity
     * the given capacity
     * 
     * @throws IllegalArgumentException
     * if capacity is negative
     * 
     * @note
     * See item #26 in Effective Java.
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void add(E value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    public void addAll(List<E> other) {
        ensureCapacity(size + other.size());
        for (E value : other) {
            add(value);
        }
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        // remove reference for garbage collection
        elementData[size - 1] = null;
        size--;
    }

    public void set(int index, E value) {
        checkIndex(index);
        elementData[index] = value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            // remove reference for garbage collection
            elementData[i] = null;
        }
        size = 0;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Increases the capacity of this list if a given capacity is greater than
     * the current capacity.
     * 
     * @param capacity
     * the given capacity
     */
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            // block copy operation
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /*
     * This inner class represents an iterator used for an array list.
     */
    private class ArrayListIterator implements Iterator<E> {
        private int position; // next element
        private boolean removeOK; // legal state for remove

        public ArrayListIterator() {
            position = 0;
            removeOK = false;
        }

        public boolean hasNext() {
            return position < size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }
}
