package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/17/16.
 */
public class DoublyLinkedList<Integer> {

    DoublyLinkedNode<Integer> head;

    public DoublyLinkedNode<Integer> getHead() {
        return this.head;
    }

    public void setHead(DoublyLinkedNode head) {
        this.head = head;
    }

    // This method keeps head at first element, after new element is inserted
    // Hence, data can be traversed in the same order as it is entered.
    public void addAtEnd(DoublyLinkedNode<Integer> newNode) {

        if(head == null) {
            head = newNode;
        } else {
            DoublyLinkedNode<Integer> temp = head;
            while(head.next != null) {
                head = head.next;
            }
            head.next = newNode;
            newNode.prev = head;
            head = temp;
        }
    }

    public void printDoublyLinkedList() {

        if(head == null) {
            System.out.println("Empty linkedList.");
            return;
        }
        DoublyLinkedNode current = head;
        System.out.println();
        while(current != null) {
            System.out.print(current.getData()+"->");
            current = current.next;
        }
        System.out.println();
    }

    public void printDoublyLinkedList(DoublyLinkedNode<Integer> head) {

        if(head == null) {
            System.out.println("Empty linkedList.");
            return;
        }
        DoublyLinkedNode current = head;
        while(current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
    }

    //Reverse a Doubly Linked List
    public void printReversedDoublyLinkedList(DoublyLinkedList<Integer> myLinkedList) {

        if(myLinkedList.getHead() == null) return;

        DoublyLinkedNode<Integer> prevNode = null;
        DoublyLinkedNode<Integer> current = myLinkedList.getHead();
        DoublyLinkedNode<Integer> nextNode = null;

        while(current != null) {

            nextNode = current.next;
            current.prev = nextNode;
            current.next = prevNode;

            prevNode = current;
            current = nextNode;

            myLinkedList.setHead(prevNode);
        }

        printDoublyLinkedList(myLinkedList.getHead());
    }

    // deleting a node
    public void deleteNode(DoublyLinkedList<Integer> list, int data) {

        DoublyLinkedNode<Integer> current = list.getHead();
        DoublyLinkedNode<Integer> prevNode;
        DoublyLinkedNode<Integer> nextNode;

        while(current != null) {
            if(current.getData() == data) {
                // 1. node to delete is first node
                if(current.prev == null) {
                    nextNode = current.next;
                    nextNode.prev = null;
                    current.next = null;
                    list.setHead(nextNode);
                }
                // 2. node to delete is last node
                else if(current.next == null) {
                    prevNode = current.prev;
                    prevNode.next = null;
                    current.prev = null;
                }
                // 3. node to delete is any other node
                else {
                    nextNode = current.next;
                    prevNode = current.prev;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                }
            }
            current = current.next;
        }
    }
}
