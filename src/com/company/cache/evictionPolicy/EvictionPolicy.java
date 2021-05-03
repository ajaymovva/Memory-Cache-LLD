package com.company.cache.evictionPolicy;

public interface EvictionPolicy<Key> {
    public void keyAccessed(Key key);
    public Key evictKey();
}
