import java.util.Random;

/**
 * This program is a simple random test for the disjoint sets ADT.
 * 
 * @see DisjointSets
 * 
 * @author Spencer Hubbard
 */
public class DisjointSetsExample {
    public static final int MAX_DELTA = 10; // MAX_DELTA > 0
    public static final int MIN_NUMBER = 9; // MIN_NUMBER > 1

    public static void main(String[] args) {
        Random r = new Random();
        // MIN_NUMBER <= n <= MIN_NUMBER + MAX_DELTA - 1
        int n = MIN_NUMBER + r.nextInt(MAX_DELTA);
        // 1 <= m <= 2 * n
        int m = 1 + r.nextInt(2 * n);

        System.out.printf("Test sequence of %2d union/find operations on %2d elements.\n\n", m, n);

        DisjointSets d = new DisjointSets(n);
        for (int i = 1; i <= m; i++) {
            // pick random element of set A and set B
            int j = r.nextInt(n);
            int k = r.nextInt(n);
            // print test information
            System.out.printf("Test: %2d, Index A: %2d, Index B: %2d, ", i, j, k);
            // find root of set A and set B
            j = d.find(j);
            k = d.find(k);
            // print result
            if (j == k) {
                System.out.println("Same Set");
            } else {
                // form union of set A and B
                d.union(j, k);
                // print result
                System.out.printf("Root A: %2d, Root B: %2d, Union: ", j, k);
                j = d.find(j);
                d.print(j);
            }
        }
    }
}
