import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * This utility class contains methods for finding prime numbers. This class is
 * noninstantiable.
 * 
 * @note
 * See item #4 in Effective Java.
 * 
 * @author Spencer Hubbard
 */
public class Sieve {
    /*
     * Suppress default constructor for noninstantiability.
     */
    private Sieve() {
        throw new AssertionError();
    }

    /**
     * Finds all prime numbers up to a given max using the sieve of
     * Eratosthenes algorithm.
     * 
     * @param max
     * the given max
     * 
     * @return
     * a list of all prime numbers up to the given max
     */
  public static List<Integer> sieve(int max) {
    List<Integer> primes = new LinkedList<Integer>();
        Queue<Integer> numbers = new LinkedList<Integer>();

        if (max >= 2) {
            primes.add(2);
        }

    // add all odd numbers from 3 to max (inclusive) to queue
    for (int i = 3; i <= max; i += 2) {
      numbers.add(i);
    }

    while (!numbers.isEmpty()) {
      // remove a prime number from the front of the list
      int front = numbers.remove();
      primes.add(front);

      // if front squared is greater than max, then add rest
      if (max < front * front) {
        primes.addAll(numbers);
        numbers.clear();
      } else {
        // remove all multiples of this prime number
        Iterator<Integer> itr = numbers.iterator();
        while (itr.hasNext()) {
          int current = itr.next();
          if (current % front == 0) {
            itr.remove();
          }
        }
      }
    }

    return primes;
  }

    /**
     * Finds the smallest prime greater than or equal to a given number.
     * 
     * @param n
     * the given number
     * 
     * @return
     * the smallest prime greater than or equal to the given number
     * 
     * @throws IllegalArgumentException
     * if the given number is not a positive integer greater than one
     */
    static int nextPrime(int n) {
        // check precondition
        if (n <= 1) {
            throw new IllegalArgumentException("number less than one: " + n);
        }

        // use sieve of Eratosthenes to find all primes p with 2 <= p < 2 * n
        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        // add all integers i with 2 <= i < 2 * n to queue
        for (int i = 2; i < 2 * n; i++) {
            queue.add(i);
        }

        // add all primes p with p < 2 * n to stack
        while (!queue.isEmpty()) {
            // remove next largest prime from front of queue
            int p = queue.remove();
            // push p onto stack of prime numbers
            stack.push(p);
            // remove multiples of p from queue
            Iterator<Integer> itr = queue.iterator();
            while (itr.hasNext()) {
                int i = itr.next();
                if (i % p == 0) {
                    // p divides i
                    itr.remove();
                }
            }
        }

        // find smallest prime p with n <= p
        // there exists prime p such that n < p < 2 * n by Bertrand's theorem
        assert !stack.isEmpty();
        int p = stack.pop();
        assert !stack.isEmpty();
        int q = stack.pop();
        while (q >= n) {
            assert !stack.isEmpty();
            p = q;
            q = stack.pop();
        }

        return p;
    }
}
