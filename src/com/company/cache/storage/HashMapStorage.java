package com.company.cache.storage;

import com.company.cache.exceptions.NotFoundException;
import com.company.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> storage;
    private final Integer capacity;
    public HashMapStorage(Integer capacity){
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if(isStorageFull()){
            throw new StorageFullException("Capacity Full...");
        }
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException{
        if(!storage.containsKey(key)){
            throw new NotFoundException(key + "doesn't exists in the cache");
        }
        storage.remove(key);
    }

    @Override
    public Value get(Key key) {
        if(!storage.containsKey(key)){
            throw new NotFoundException(key + "doesn't exists in the cache");
        }
        return storage.get(key);
    }

    private boolean isStorageFull(){
        return storage.size() == capacity;
    }
}
