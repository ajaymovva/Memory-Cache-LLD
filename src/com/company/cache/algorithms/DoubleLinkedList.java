package com.company.cache.algorithms;

public class DoubleLinkedList<E> {
    public DoubleLinkedListNode<E> dummyHead;
    public DoubleLinkedListNode<E> dummyTail;

    public DoubleLinkedList(){
        this.dummyHead = new DoubleLinkedListNode<>(null);
        this.dummyTail = new DoubleLinkedListNode<>(null);
        this.dummyTail.prev = this.dummyHead;
        this.dummyHead.next = this.dummyTail;
    }

    public void detachNode(DoubleLinkedListNode<E> node){
        if(node != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNode(DoubleLinkedListNode<E> node){
        if(node != null){
            node.prev = this.dummyTail.prev;
            node.next = this.dummyTail;
            this.dummyTail.prev.next = node;
            this.dummyTail.prev = node;
        }
    }

    public DoubleLinkedListNode<E> addElement(E element){
        if(element == null){
            throw new RuntimeException("No element found for adding..");
        }
        DoubleLinkedListNode<E> node = new DoubleLinkedListNode<E>(element);
        addNode(node);
        return node;
    }

    public DoubleLinkedListNode<E> getFirstNode(){
        if(isElementsPresent()){
            return dummyHead.next;
        }
        return null;
    }

    public DoubleLinkedListNode<E> getLastNode(){
        if(isElementsPresent()){
            return dummyTail.prev;
        }
        return null;
    }

    public boolean isElementsPresent(){
        return dummyTail.prev != dummyHead;
    }
}
