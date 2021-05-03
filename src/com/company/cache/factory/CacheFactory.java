package com.company.cache.factory;

import com.company.cache.Cache;
import com.company.cache.evictionPolicy.LRUEvictionPolicy;
import com.company.cache.storage.HashMapStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(final int capacity){
        return new Cache<Key, Value>(new HashMapStorage<Key, Value>(capacity), new LRUEvictionPolicy<>());
    }
}
