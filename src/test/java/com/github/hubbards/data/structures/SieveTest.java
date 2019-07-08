package com.github.hubbards.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is a simple test suite for {@link Sieve}.
 *
 * @author Spencer Hubbard
 */
public class SieveTest {
    // First six primes
    private static final int[] SMALL_PRIMES = {2, 3, 5, 7, 11, 13};

    // One hundredth prime
    private static final int BIG_PRIME = 541;

    // Helper method for testing small primes.
    private static void testSmallPrimes(java.util.List<Integer> numbers) {
        assert numbers.size() <= SMALL_PRIMES.length;
        for (int i = 0; i < numbers.size(); i++) {
            assertEquals(SMALL_PRIMES[i], (int) numbers.get(i));
        }
    }

    @Test
    public void testSieve0() {
        java.util.List<Integer> numbers = Sieve.sieve(0);
        assertTrue(numbers.isEmpty());
    }

    @Test
    public void testSieve1() {
        java.util.List<Integer> numbers = Sieve.sieve(1);
        assertTrue(numbers.isEmpty());
    }

    @Test
    public void testSieve2() {
        java.util.List<Integer> numbers = Sieve.sieve(2);
        assertEquals(1, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve3() {
        java.util.List<Integer> numbers = Sieve.sieve(3);
        assertEquals(2, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve4() {
        java.util.List<Integer> numbers = Sieve.sieve(4);
        assertEquals(2, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve5() {
        java.util.List<Integer> numbers = Sieve.sieve(5);
        assertEquals(3, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve6() {
        java.util.List<Integer> numbers = Sieve.sieve(6);
        assertEquals(3, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve7() {
        java.util.List<Integer> numbers = Sieve.sieve(7);
        assertEquals(4, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve8() {
        java.util.List<Integer> numbers = Sieve.sieve(8);
        assertEquals(4, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve9() {
        java.util.List<Integer> numbers = Sieve.sieve(9);
        assertEquals(4, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve10() {
        java.util.List<Integer> numbers = Sieve.sieve(10);
        assertEquals(4, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve11() {
        java.util.List<Integer> numbers = Sieve.sieve(11);
        assertEquals(5, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve12() {
        java.util.List<Integer> numbers = Sieve.sieve(12);
        assertEquals(5, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieve13() {
        java.util.List<Integer> numbers = Sieve.sieve(13);
        assertEquals(6, numbers.size());
        testSmallPrimes(numbers);
    }

    @Test
    public void testSieveOnNegative() {
        java.util.List<Integer> numbers = Sieve.sieve(-1);
        assertTrue(numbers.isEmpty());
    }

    @Test
    public void testSieveOnBigPrime() {
        java.util.List<Integer> numbers = Sieve.sieve(BIG_PRIME);
        assertEquals(BIG_PRIME, (int) numbers.get(numbers.size() - 1));
    }
}
