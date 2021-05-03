package com.company.cache.algorithms;

import lombok.Getter;

@Getter
public class DoubleLinkedListNode<Key> {
    public Key key;
    public DoubleLinkedListNode<Key> prev, next;
    public DoubleLinkedListNode(Key key){
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}
