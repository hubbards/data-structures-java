/**
 * This program contains a simple example of a hash table using linear probing
 * to resolve collisions.
 *
 * @author Spencer Hubbard
 */
public class LinearProbingHashTableExample {
    public static void main(String[] args) {
        LinearProbingHashTable<Integer> t = new LinearProbingHashTable<Integer>();

        // insertions
        System.out.println("Insertions:");
        int[] a = {42, 29, 42, 17, 112, -9, 17, 82, 53};
        for (int i = 0; i < a.length; i++) {
            t.insert(a[i]);
            System.out.printf("After inserting %3d, table = %s\n", a[i], t);
        }
        t.debug();
        System.out.println();

        // contains
        System.out.println("Contains:");
        a = new int[] {42, 29, 42, 17, 112, -9, 17, 82, 53, 55, 182, -91, 888};
        for (int i = 0; i < a.length; i++) {
            System.out.println(t + " contains " + a[i] + "? " + t.contains(a[i]));
        }
        System.out.println();

        // removals
        System.out.println("Removals:");
        a = new int[] {55, 42, 182, 17, -91, 82};
        for (int i = 0; i < a.length; i++) {
            t.remove(a[i]);
            System.out.printf("After removing %3d, table = %s, contains %3d? %b\n", a[i], t, a[i], t.contains(a[i]));
        }
        t.debug();
        System.out.println();

        int n = 22;
        t.insert(n);
        System.out.printf("After inserting %2d, table = %s, contains %2d? %b\n", n, t, n, t.contains(n));
        t.debug();
        System.out.println();

        // rehashing
        System.out.println("Rehashing:");
        a = new int[] {33, 56, 22, 19, 41, 104, -2, 75, 75, 22, 984, -777, 66, 33, 90210, 44444};
        for (int i = 0; i < a.length; i++) {
            t.insert(a[i]);
            System.out.printf("After inserting %5d, table = %s\n", a[i], t);
        }
        System.out.println();
    }
}
