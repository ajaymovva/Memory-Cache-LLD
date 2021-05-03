package com.company.cache;

import com.company.cache.evictionPolicy.EvictionPolicy;
import com.company.cache.exceptions.NotFoundException;
import com.company.cache.exceptions.StorageFullException;
import com.company.cache.storage.Storage;

public class Cache <Key, Value>{

    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy <Key>evictionPolicy){
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value){
        try{
            this.storage.put(key, value);
            this.evictionPolicy.keyAccessed(key);
        }
        catch (StorageFullException exception){
            Key removedKey = this.evictionPolicy.evictKey();
            if(removedKey == null){
                throw new RuntimeException("Storage Full and unable to evict the Key..");
            }
            this.storage.remove(removedKey);
            System.out.println("Creating Space by evicting Key " + removedKey);
            put(key, value);
        }
    }

    public Value get(Key key){
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        }
        catch (NotFoundException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
