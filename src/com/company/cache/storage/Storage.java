package com.company.cache.storage;

public interface Storage <Key, Value>{
    public void put(Key key, Value value);
    void remove(Key key);
    Value get(Key key);
}
