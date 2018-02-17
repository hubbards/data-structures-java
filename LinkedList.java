import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * This class represents a generic doubly linked list implementation of the
 * list ADT.
 * 
 * @author Spencer Hubbard
 */
public class LinkedList<E> extends AbstractList<E> implements Queue<E>, Stack<E> {
    // first dummy node
    private ListNode front;
    // last dummy node
    private ListNode back;
    // number of elements in list
    private int size;

    /**
    * Constructs an empty list.
    */
    public LinkedList() {
        front = new ListNode(null);
        back = new ListNode(null);
        clear();
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        ListNode current = nodeAt(index);
        return current.data;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    public int indexOf(E value) {
        int index = 0;
        ListNode current = front.next;
        while (current != back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void add(E value) {
        add(size, value);
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode current = nodeAt(index - 1);
        ListNode newNode = new ListNode(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public void addAll(List<E> other) {
        for (E value : other) {
            add(value);
        }
    }

    public void remove(int index) {
        checkIndex(index);
        ListNode current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    public void set(int index, E value) {
        checkIndex(index);
        ListNode current = nodeAt(index);
        current.data = value;
    }

    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    public void push(E value) {
        add(0, value);
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return remove();
    }

    public void enqueue(E value) {
        add(value);
    }

    public E dequeue() {
        if (size == 0) {
            throw new UnderflowException("empty queue");
        }
        return remove();
    }

    public E peek() {
        if (size == 0) {
            throw new UnderflowException("empty queue");
        }
        return front.next.data;
    }

    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    /*
     * Removes the element at the head of this list.
     */
    private E remove() {
        E value = front.next.data;
        front.next = front.next.next;
        front.next.prev = front;
        size--;
        return value;
    }

    /*
     * Returns the node at a given index, otherwise throws an exception.
     */
    private ListNode nodeAt(int index) {
        ListNode current;
        if (index < size / 2) {
            // start from front of list
            current = front;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
        } else {
            // start from back of list
            current = back;
            for (int i = size; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /*
     * This inner class represents a node used in a doubly linked list.
     */
    private class ListNode {
        // data stored in node
        public E data;
        // link to next node in list
        public ListNode next;
        // link to previous node in list
        public ListNode prev;

        /*
         * Constructs a node with given data and null links.
         */
        public ListNode(E data) {
            this(data, null, null);
        }

        /*
         * Constructs a node with given data and given links.
         */
        public ListNode(E data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /*
     * This inner class represents an iterator used for a linked list.
     */
    private class LinkedIterator implements Iterator<E> {
        // next element
        private ListNode current;
        // legal state for remove
        private boolean removeOK;

        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        public boolean hasNext() {
            return current != back;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}
