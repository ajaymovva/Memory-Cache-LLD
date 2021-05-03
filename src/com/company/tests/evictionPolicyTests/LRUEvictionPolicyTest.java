package com.company.tests.evictionPolicyTests;

import com.company.cache.evictionPolicy.LRUEvictionPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LRUEvictionPolicyTest {
    private LRUEvictionPolicy<Integer> lruEvictionPolicy;
    @BeforeEach
    void setUp(){
        lruEvictionPolicy = new LRUEvictionPolicy<>();
    }

    @Test
    void testKeysOrderEvicted(){
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);
        assertEquals(1, lruEvictionPolicy.evictKey());
        assertEquals(2, lruEvictionPolicy.evictKey());
        assertEquals(3, lruEvictionPolicy.evictKey());
        assertEquals(4, lruEvictionPolicy.evictKey());
    }

    @Test
    void testOrderAccessingPreventsEviction(){
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        assertEquals(3, lruEvictionPolicy.evictKey());
        assertEquals(4, lruEvictionPolicy.evictKey());
        assertEquals(1, lruEvictionPolicy.evictKey());
        assertEquals(2, lruEvictionPolicy.evictKey());
    }
}
