package com.company.cache.evictionPolicy;

import com.company.cache.algorithms.DoubleLinkedList;
import com.company.cache.algorithms.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private DoubleLinkedList<Key> dll;
    private Map<Key, DoubleLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        this.dll = new DoubleLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            dll.addNode(mapper.get(key));
        }
        else{
            mapper.put(key, dll.addElement(key));
        }
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> removedNode = dll.getFirstNode();
        if(removedNode != null){
            dll.detachNode(removedNode);
            return removedNode.getKey();
        }
        return null;
    }
}
