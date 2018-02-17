/**
 * This class represents a genaric implementation of the hash table ADT using
 * linear probing to avoid collisions.
 * 
 * @author Spencer Hubbard
 */
public class LinearProbingHashTable<E> {
    // default number of buckets
    public static final int DEFAULT_PRIME = 11;

    // dummy object to indicate removed values
    private static final Object REMOVED = new Object();

    // elements in this hash table
    private Object[] buckets;
    // number of elements in this hash table
    private int size;

    /**
     * Constructs a hash table with the default number of buckets.
     */
    public LinearProbingHashTable() {
        this(DEFAULT_PRIME);
    }

    /**
     * Constructs a hash table with some number of buckets between a given
     * number and twice the given number.
     * 
     * @param n
     * the given number
     */
    public LinearProbingHashTable(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        int p = Sieve.nextPrime(n);
        buckets = new Object[p];
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
        while (buckets[i] != null) {
            if (buckets[i].equals(value)) {
                return true;
            }
            // collision occured
            i = (i + 1) % buckets.length;
        }
        // value is not contained in this table
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
        // TODO: rehash if load factor is more than 0.5
        // check load factor
        if (3 * buckets.length < 4 * size) {
            rehash();
        }
        // linear probing to avoid collisions
        int i = hash(value);
        while (buckets[i] != null && !buckets[i].equals(REMOVED) && !buckets[i].equals(value)) {
            // collision occurred
            i = (i + 1) % buckets.length;
        }
        if (buckets[i] == null || buckets[i].equals(REMOVED)) {
            buckets[i] = value;
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
        while (buckets[i] != null && !buckets[i].equals(value)) {
            // collision occurred
            i = (i + 1) % buckets.length;
        }
        if (buckets[i] != null) {
            // remove value
            buckets[i] = REMOVED;
            size--;
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
        Object[] temp = buckets;
        int p = Sieve.nextPrime(2 * buckets.length);
        buckets = new Object[p];
        size = 0;
        // add all values in this hash table
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null && !temp[i].equals(REMOVED)) {
                insert((E) temp[i]);
            }
        }
    }

    /**
     * Prints this hash table. Note that output is formatted "nicely" if values
     * are no more than six characters long.
     */
    public void debug() {
        System.out.println("debug output");
        // print row for indices
        System.out.print("index: ");
        for (int i = 0; i < buckets.length; i++) {
            System.out.printf("%-7d", i);
        }
        System.out.println();
        // print row for values
        System.out.print("value: ");
        for (int i = 0; i < buckets.length; i++) {
            // print value in bucket i
            String string;
            if (buckets[i] == null || buckets[i].equals(REMOVED)) {
                string = "null";
            } else {
                string = buckets[i].toString();
            }
            System.out.printf("%-7s", string);
        }
        System.out.println();
        // print number of elements in table
        System.out.println("size : " + size);
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            // find first element
            int i = 0;
            while (buckets[i] == null || buckets[i].equals(REMOVED)) {
                i++;
            }
            // print first element
            String result = "[" + buckets[i];
            // find and print all other elements
            for (int j = i + 1; j < buckets.length; j++) {
                if (buckets[j] != null && !buckets[j].equals(REMOVED)) {
                    result = result + ", " + buckets[j];
                }
            }
            result = result + "]";
            return result;
        }
    }
}
