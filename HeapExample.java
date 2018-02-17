/**
 * This program contains a simple example of a binary (min) heap implementation
 * of the priority queue ADT.
 * 
 * @author Spencer Hubbard
 */
public class HeapExample {
    public static void main(String[] args) {
        // simple example
        System.out.println("Example of heap.");
        System.out.println();

        Heap<Integer> h = new Heap<Integer>();
        int[] a = { 13, 20, 11, 44, 3, 7, 9, 11, 43, 3, 14 };

        // insert
        System.out.println("Insertions:");
        for (int i = 0; i < a.length; i++) {
            h.insert(a[i]);
            System.out.printf("insert: %2d, heap: %s\n", a[i], h);
        }
        System.out.println();

        // delete minimum
        System.out.println("Deletions:");
        while (!h.isEmpty()) {
            int min = h.deleteMin();
            System.out.printf("min: %2d, heap: %s\n", min, h);
        }
        System.out.println();
    }
}
