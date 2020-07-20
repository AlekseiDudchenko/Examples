package com.dudchenko.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

    private LRUCache<Integer, Integer> cache;

    public LRUCacheTest() {
        this.cache = new LRUCache<>(2);
    }

    @Test
    public void testCacheStartsEmpty() {
        assertNull(cache.get(1));
    }

    @Test
    public void testSetBelowCapacity() {
        cache.put(1, 1);
        assertEquals(java.util.Optional.ofNullable(cache.get(1)), java.util.Optional.of(1));
        assertNull(cache.get(2));
        cache.put(2, 4);
        assertEquals(java.util.Optional.ofNullable(cache.get(1)), java.util.Optional.of(1));
        assertEquals((java.util.Optional.ofNullable(cache.get(2))), java.util.Optional.of(4));
    }

    @Test
    public void testCapacityReachedOldestRemoved() {
        cache.put(1, 1);
        cache.put(2, 4);
        cache.put(3, 9);
        assertNull(cache.get(1));
        assertEquals(java.util.Optional.ofNullable(cache.get(2)), java.util.Optional.of(4));
        assertEquals(java.util.Optional.ofNullable(cache.get(3)), java.util.Optional.of(9));
    }

    @Test
    public void testGetRenewsEntry() {
        cache.put(1, 1);
        cache.put(2, 4);
        assertEquals(java.util.Optional.ofNullable(cache.get(1)), java.util.Optional.of(1));
        cache.put(3, 9);
        assertEquals(java.util.Optional.ofNullable(cache.get(1)), java.util.Optional.of(1));
        assertNull(cache.get(2));
        assertEquals(java.util.Optional.ofNullable(cache.get(3)), java.util.Optional.of(9));
    }

}
