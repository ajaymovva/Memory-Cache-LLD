package com.company.tests.algorithms;

import com.company.cache.algorithms.DoubleLinkedList;
import com.company.cache.algorithms.DoubleLinkedListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> dll;

    @BeforeEach
    void setUp(){
        dll = new DoubleLinkedList<>();
    }

    void verifyDLL(DoubleLinkedList<Integer> dll, List<Integer> expectedList){
        DoubleLinkedListNode<Integer> tempNode = dll.getFirstNode();
        for(Integer presentVal: expectedList){
            assertNotNull(tempNode);
            assertEquals(presentVal, tempNode.getKey());
            tempNode = tempNode.getNext();
        }
        tempNode = tempNode.getNext();
        assertNull(tempNode);
    }

    @Test
    void testDLLAdd(){
        DoubleLinkedListNode<Integer> node1 = new DoubleLinkedListNode<>(1);
        DoubleLinkedListNode<Integer> node2 = new DoubleLinkedListNode<>(2);
        DoubleLinkedListNode<Integer> node3 = new DoubleLinkedListNode<>(3);
        DoubleLinkedListNode<Integer> node4 = new DoubleLinkedListNode<>(4);
        DoubleLinkedListNode<Integer> node5 = new DoubleLinkedListNode<>(5);

        dll.addNode(node1);
        verifyDLL(dll, List.of(1));
        dll.addNode(node2);
        verifyDLL(dll, List.of(1, 2));
        dll.addNode(node3);
        verifyDLL(dll, List.of(1, 2, 3));
        dll.addNode(node4);
        verifyDLL(dll, List.of(1, 2, 3, 4));
        dll.addNode(node5);
        verifyDLL(dll, List.of(1, 2, 3, 4, 5));
    }

    @Test
    void testDLLRemove(){

        DoubleLinkedListNode<Integer> node1 = dll.addElement(1);
        DoubleLinkedListNode<Integer> node2 = dll.addElement(2);
        DoubleLinkedListNode<Integer> node3 = dll.addElement(3);
        DoubleLinkedListNode<Integer> node4 = dll.addElement(4);
        DoubleLinkedListNode<Integer> node5 = dll.addElement(5);

        verifyDLL(dll, List.of(1, 2, 3, 4, 5));
        dll.detachNode(node1);
        verifyDLL(dll, List.of(2, 3, 4, 5));
        dll.detachNode(node2);
        verifyDLL(dll, List.of(3, 4, 5));
        dll.detachNode(node3);
        verifyDLL(dll, List.of(4, 5));
        dll.detachNode(node4);
        verifyDLL(dll, List.of(5));
    }
}
