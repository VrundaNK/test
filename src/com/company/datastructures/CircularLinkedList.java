package com.company.datastructures;


import com.company.datastructures.linkedList.Node;

/**
 * Created by vnagpurkar on 6/17/16.
 */
public class CircularLinkedList {

    Node<Integer> head = null;

    // This method moves head to new element, after new element is inserted
    // Hence, data needs to be traversed in reverse order, as it is entered.
    public void addAtBegining(Node<Integer> newNode) {

        newNode.setNext(head);
        head = newNode;
    }

    // This method moves head to new element, after new element is inserted
    // Hence, data needs to be traversed in reverse order, as it is entered.
    public void addAtBegining(int data) {

        Node current = new Node(data);
        if(head == null) {
            head = current;
            head.setNext(current);
        } else {
            current.setNext(head);
            head.setNext(current);
            head = current;
        }
    }

    // This method keeps head at first element, after new element is inserted
    // Hence, data can be traversed in the same order as it is entered.
    public void addAtEnd(Node<Integer> newNode) {

        if(head == null) {
            head = newNode;
            head.setNext(newNode);
        } else {
            Node temp = head;
            while(head.getNext() != temp) {
                head = head.getNext();
            }
            head.setNext(newNode);
            newNode.setNext(temp);
            head = temp;
        }
    }

    // This method keeps head at first element, after new element is inserted
    // Hence, data can be traversed in the same order as it is entered.
    public void addAtEnd(Integer data) {

        Node current = new Node(data);
        if(head == null) {
            head = current;
            head.setNext(current);
        } else {
            Node temp = head;
            while(head.getNext() != temp) {
                head = head.getNext();
            }
            head.setNext(current);
            current.setNext(temp);
            head = temp;
        }
    }

    public Node getHead() {

        return this.head;
    }

    public void printLinkedList() {

        if(head == null) {
            System.out.println("Empty linkedList.");
            return;
        }
        Node current = head;
        while(current.getNext() != head) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void printLinkedList(Node<Integer> head) {

        if(head == null) {
            System.out.println("Empty linkedList.");
            return;
        }
        Node current = head;
        do {
            System.out.println(current.getData());
            current = current.getNext();
        } while(current != head);
    }

    // Split a Circular Linked List into two halves
    //1) Store the mid and last pointers of the circular linked list using tortoise and hare algorithm.
    //2) Make the second half circular.
    //3) Make the first half circular.
    //4) Set head (or start) pointers of the two linked lists.
    public void splitCircularLinkedListIn2Halves(CircularLinkedList myLinkedList) {

        Node<Integer> slowPointer = myLinkedList.getHead();
        Node<Integer> fastPointer = myLinkedList.getHead();

        while(fastPointer.getNext() != myLinkedList.getHead() && fastPointer.getNext().getNext() != myLinkedList.getHead()) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }
        // even elements fastPointer.next.next == head, fastPointer is not pointing to last element
        // odd elements fastPointer.next.next != head, fastPointer is pointing to last element
        if(fastPointer.getNext().getNext() == head) {
            fastPointer = fastPointer.getNext(); // fastPointer storing last element from the list
        }
        Node<Integer> head1 = myLinkedList.getHead(); // head of first half
        Node<Integer> head2 = slowPointer.getNext(); // head of second half

        // make second half circular
        fastPointer.setNext(head2);

        // make first half circular
        slowPointer.setNext(head1);

        System.out.println("list1 ");
        printLinkedList(head1);
        System.out.println("list2 ");
        printLinkedList(head2);
    }
}
