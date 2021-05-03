package com.company.tests;

import com.company.cache.Cache;
import com.company.cache.factory.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {
    Cache<Integer, Integer> cache;
    @BeforeEach
    public void setup(){
        cache = new CacheFactory<Integer, Integer>().defaultCache(3);
    }

    @Test
    public void testCacheByAddingAndGettingItems(){
        cache.put(1,1);
        cache.put(2,2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(3, cache.get(3));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        cache.put(4, 4);
        cache.get(2); // This should throw exception "Tried to access non-existing key."
    }
}
