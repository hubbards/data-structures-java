/**
 * This class represents a genaric implementation of the hash table ADT using
 * separate chaining to avoid collisions.
 * 
 * @author Spencer Hubbard
 */
public class SeparateChainingHashTable<E> {
    // default number of buckets
    public static final int DEFAULT_PRIME = 11;

    // elements in this hash table
    private Node[] buckets;

    // number of elements in this hash table
    private int size;

    /**
     * Constructs a hash table with the default number of buckets.
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_PRIME);
    }

    /**
     * Constructs a hash table with some number of buckets between a given
     * number and twice the given number.
     * 
     * @param n
     * the given number
     */
    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        int p = Sieve.nextPrime(n);
        buckets = (Node[]) new SeparateChainingHashTable.Node[p];
        size = 0;
    }

    /**
     * Returns the number of elements in this hash table.
     * 
     * @return
     * the number of elements in this hash table
     */
    public int size() {
        return size;
    }

    /**
     * Checks if a given value is contained in this hash table.
     * 
     * @param value
     * the value to check for
     * 
     * @return
     * <code>true</code> if the given value belongs to this hash table,
     * otherwise <code>false</code>
     */
    public boolean contains(E value) {
        int i = hash(value);
        Node current = buckets[i];
        while (current != null) {
            if (current.data.equals(value)) {
                // value at current node
                return true;
            }
            // value not at current node
            current = current.next;
        }
        // value not contained in this hash table
        return false;
    }

    /**
     * Inserts a given value into this hash table if this hash table does not
     * already contain the given value. The hash table is rehashed if the ratio
     * of the size of the hash table to the length of the backing array is more
     * than three quarters. The ratio is called the load factor and is
     * sometimes denoted by the lower-case Greek letter lambda.
     * 
     * @param value
     * the value to insert
     */
    public void insert(E value) {
        // TODO: rehash if load factor is greater than 1
        // check load factor
        if (3 * buckets.length < 4 * size) {
            rehash();
        }
        // separate chaining to avoid collisions
        if (!contains(value)) {
            int i = hash(value);
            Node node = new Node(value);
            node.next = buckets[i];
            buckets[i] = node;
            size++;
        }
    }

    /**
     * Removes a given value from this hash table if this hash table contains
     * the given value.
     * 
     * @param value
     * the value to remove
     */
    public void remove(E value) {
        int i = hash(value);
        if (buckets[i] != null) {
            if (buckets[i].data.equals(value)) {
                // value at front of list
                buckets[i] = buckets[i].next;
                size--;
            } else {
                // value not at front of list
                Node current = buckets[i];
                while (current.next != null && !current.next.data.equals(value)) {
                    // value not next in list
                    current = current.next;
                }
                if (current.next != null) {
                    // value next in list
                    current.next = current.next.next;
                    size--;
                }
            }
        }
    }

    /*
     * Hash function for this hash table.
     */
    private int hash(E value) {
        int temp = value.hashCode() % buckets.length;
        if (temp < 0) {
            return temp + buckets.length;
        } else {
            return temp;
        }
    }

    /*
     * Rehash this hash table.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        Node[] temp = buckets;
        int p = Sieve.nextPrime(2 * buckets.length);
        buckets = (Node[]) new SeparateChainingHashTable.Node[p];
        size = 0;
        for (int i = 0; i < temp.length; i++) {
            Node node = temp[i];
            while (node != null) {
                insert(node.data);
                node = node.next;
            }
        }
    }

    /**
     * Prints this hash table. Note that output is formatted "nicely" if values
     * are no more than six characters long.
     */
    public void debug() {
        System.out.println("debug output");
        System.out.printf("index: data:\n");
        for (int i = 0; i < buckets.length; i++) {
            // print row for list of values
            System.out.printf("%-4d   ", i);
            Node node = buckets[i];
            if (node == null) {
                System.out.printf("%s\n", "null");
            } else {
                System.out.printf("%-6s", node.data);
                node = node.next;
                while (node != null) {
                    System.out.printf(" --> %-6s", node.data);
                    node = node.next;
                }
                System.out.println();
            }
        }
        System.out.println("size: " + size);
        System.out.println();
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            // find first list
            int i = 0;
            while (buckets[i] == null) {
                i++;
            }
            // print elements in first list
            Node current = buckets[i];
            String result = "[" + current.data;
            while (current.next != null) {
                current = current.next;
                result = result + ", " + current.data;
            }
            // find and print elements in all other lists
            for (int j = i + 1; j < buckets.length; j++) {
                current = buckets[j];
                while (current != null) {
                    result = result + ", " + current.data;
                    current = current.next;
                }
            }
            result = result + "]";
            return result;
        }
    }

    /*
     * This inner class represents a node in a singly linked list used for
     * separate chaining.
     */
    private class Node {
        private E data;
        private Node next;

        public Node(E value) {
            data = value;
            next = null;
        }
    }
}
