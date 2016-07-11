package com.company.datastructures.linkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by vnagpurkar on 6/15/16.
 */
public class MyLinkedList<E> {

    Node<E> head = null;

    // This method moves head to new element, after new element is inserted
    // Hence, data needs to be traversed in reverse order, as it is entered.
    public void addAtBegining(Node<E> newNode) {

        newNode.setNext(head);
        head = newNode;
    }

    // This method moves head to new element, after new element is inserted
    // Hence, data needs to be traversed in reverse order, as it is entered.
    public void addAtBegining(E data) {

        Node<E> newNode = new Node<E>(data);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // This method keeps head at first element, after new element is inserted
    // Hence, data can be traversed in the same order as it is entered.
    public void addAtEnd(Node<E> newNode) {

        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // This method keeps head at first element, after new element is inserted
    // Hence, data can be traversed in the same order as it is entered.
    public void addAtEnd(E data) {

        Node<E> newNode = new Node<E>(data);
        if(this.head == null) {
            this.head = newNode;
        } else {
            Node<E> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // This method keeps head at first element, after new element is inserted
    // Hence, data can be traversed in the same order as it is entered.
    public Node<E> addAtTail(E data) {

        Node<E> newNode = new Node<E>(data);
        if(this.head == null) {
            head = newNode;
            return head;
        } else {
            Node<E> temp = this.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return temp;
        }
    }

    public Node getHead() {

        return this.head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }


    public void printLinkedList() {

        if(head == null) {
            System.out.println("Empty linkedList.");
            return;
        }
        Node current = head;
        System.out.println();
        while(current != null) {
            System.out.print(current.getData()+"->");
            current = current.getNext();
        }
        System.out.println();
    }

    public void printLinkedList(Node<Integer> head) {

        if(head == null) {
            System.out.println("Empty linkedList.");
            return;
        }
        Node current = head;
        System.out.println();
        while(current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println();
    }

    // Write a function to delete a Linked List
    // In Java, automatic garbage collection happens, so deleting a linked list is easy. We just need to change head to null.
    public void deleteLinkedList() {

        this.head = null;

    }

    // Write a function to delete a Linked List by deleting a node one by one
    public void deleteLinkedListByEachNode() {

        if(head == null) return;
        Node temp = head;

        while(head != null) {
            temp = head.getNext();
            head = null;
            head = temp;
        }
    }

    // Write a program function to detect loop/cycle in a linked list
    public boolean detectCycleInLinkedList() {

        // 1. Use Hashing - store the addresses of the nodes in a hashtable and mark true if visited
        // if we visit any node more than once, then there is a loop/cycle in list

        // 2. Mark Visited nodes - add boolean Visted in existing list structure and mark that true if node is present
        // if we visit any node more than once, then there is a loop/cycle in list

        // 3. Fasted algorithm - Floyd’s Cycle-Finding Algorithm (Tortoise-Hair Algorithm)
        Node slow = head;
        Node fast = head.getNext().getNext();

        while(slow != null && fast != null && fast.getNext() != null) {

            if(slow == fast) {
                return true;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return false;
    }

    // Write a function to get Nth node in a Linked List
    public E getNth(MyLinkedList<E> linkedList, int n) {

        Node current = linkedList.getHead();
        int count = 0;
        while(current != null) {
            if(count == n) {
                return (E) current.getData();
            }
            count++;
            current = current.getNext();
        }
        return null;
    }

    // Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
    public void deleteANode(Node delete) {

        // only one node in list, hence set to null will delete that node.
        if (delete.getNext() == null) {
            delete = null;
        }

        else {
            // 1. copy data from next node to this node
            delete.setData(delete.getNext().getData());
            // 2. delete, nextToDelete node
            delete.setNext(delete.getNext().getNext());
        }
    }

    // Find the middle of a given linked list
    public Node getMiddleOfLinkedList(MyLinkedList myLinkedList) {

        Node slowPointer = myLinkedList.getHead();
        Node fastPointer = myLinkedList.getHead();

        if(myLinkedList.getHead() != null) {
             while(fastPointer != null && fastPointer.getNext() != null) {
                 slowPointer = slowPointer.getNext();
                 fastPointer = fastPointer.getNext().getNext();
             }
        }
        return slowPointer;
    }

    // Find n’th node from the end of a Linked List
    public Node getNthNodeFromEnd(MyLinkedList myLinkedList, int n) {

        int count = 0;
        if(myLinkedList.getHead()== null) return null;

        Node slowPointer = myLinkedList.getHead();
        Node fastPointer = myLinkedList.getHead();

        while(fastPointer != null && count <= n) {
            fastPointer = fastPointer.getNext();
            count++;
        }

        while(fastPointer != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext();
            count++;
        }
        if(n <= count)
            return slowPointer;
        else
            return null;
    }

    // Write a function that counts the number of times a given int occurs in a Linked List
    public int countOccurranceOfKeyInList(MyLinkedList<Integer> myLinkedList, int key) {

        if(myLinkedList.getHead() == null) return -1;

        Node current = myLinkedList.getHead();
        int count = 0;

        while(current != null) {
            if((Integer) current.getData() == key) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    // Write a function to reverse a linked list
    public MyLinkedList printReverseList() {

        if(head == null) {
            return null;
        }

        Node current = head;
        head = null;
        Node next = null;

        while(current != null) {

            next = current.getNext();
            current.setNext(head);

            head = current;
            current = next;
        }

        return this;
    }

    // Function to check if a singly linked list is palindrome
    // METHOD 1 (Use a Stack)
    public boolean isPalindrome(MyLinkedList<Character> myLinkedList) {

        if(myLinkedList.getHead() == null) return false;

        Stack<Character> temp = new Stack<Character>();
        boolean result = true;

        Node current = myLinkedList.getHead();
        while(current != null) {

            temp.push((Character) current.getData());
            current = current.getNext();
        }

        current = myLinkedList.getHead();
        while(current != null) {
            if(!temp.isEmpty()) {
                if(temp.pop() == current.getData()) {
                    result = result & true;
                } else {
                    result = result & false;
                    break;
                }
            }
            current = current.getNext();
        }
        return result;
    }

    // Function to check if a singly linked list is palindrome
    // METHOD 2 (By reversing the list)
    public boolean isPalindromeMethod2(MyLinkedList<Character> myLinkedList) {

        if(myLinkedList.getHead() == null) return false;
        boolean result = true;

        // 1. find the middle of the list
        Node<Character> midNode = null;
        Node<Character> slowPointer = myLinkedList.getHead();
        Node<Character> fastPointer = myLinkedList.getHead();

        while(fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        // odd elements
        /*if(fastPointer != null) {
            midNode = slowPointer;
            slowPointer = slowPointer.getNext();
        }*/

        // 2. reverse the second half of the list
        Node<Character> current = slowPointer;
        Node<Character> prev = null;
        Node<Character> next;
        while(current != null) {
            next = current.getNext();
            current.setNext(prev);

            prev = current;
            current = next;
        }
        slowPointer = prev;
        // 3. compare first half and second half and check if both match
        current = myLinkedList.getHead();
        while(slowPointer != null && prev.getNext() != null) {
            if(current.getData() == slowPointer.getData()) {
                result = result & true;
            } else {
                result = result & false;
                break;
            }
            slowPointer = slowPointer.getNext();
            current = current.getNext();
        }

        return result;
    }

    // Function to check if a singly linked list is palindrome
    // METHOD 3 (Using Recursion)
    // This method the way is explained in geeksforgeeks is not applicable in java
    /* public boolean isPalindromeMethod3(MyLinkedList<Character> myLinkedList) {

        if(myLinkedList.getHead() == null) return false;
        return isPalindromeRecur(myLinkedList.getHead(), myLinkedList.getHead().getNext(), true);
    }

    private static boolean isPalindromeRecur(Node<Character> left, Node<Character> right, boolean result) {

        if(left == null || result == false) return result;

        if(right.next != null) {
            result = isPalindromeRecur(left, right.next, result);
        }
        if(left.getData() == right.getData()) {
            result = result & true;
        } else {
            result = result & false;
        }
        left = left.next;
        return result;
    }*/

    // Given a linked list which is sorted, how will you insert in sorted way
    // Using prev, next and current pointers
    public static void insertInSortedList(MyLinkedList<Integer> myLinkedList, int newData) {

        if(myLinkedList.getHead() == null) {
            myLinkedList.addAtBegining(newData);
            return;
        }

        Node<Integer> newNode = new Node<Integer>(newData);
        Node prev = myLinkedList.getHead();
        Node current = myLinkedList.getHead();
        while(current != null) {

            if(newData > (Integer) current.getData()) {
                prev = current;
                current = current.getNext();

            } else {
                Node next = current;
                current = newNode;
                current.setNext(next);
                prev.setNext(current);
                return;
            }
        }
    }

    // Given a linked list which is sorted, how will you insert in sorted way
    public void insertInSortedListUsingOnePointer(MyLinkedList<Integer> myLinkedList, int newData) {

        if(myLinkedList.getHead() == null || (Integer)myLinkedList.getHead().getData() > newData ) {
            myLinkedList.addAtBegining(newData);
            return;
        }

        Node<Integer> newNode = new Node<Integer>(newData);
        Node current = myLinkedList.getHead();

        while(current != null && (Integer) current.getData() <= newData
                && current.getNext() != null && (Integer) current.getNext().getData() <= newData) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    //Write a function to get the intersection point of two Linked Lists.
    public Node<Integer> getIntersectionPointOf2Lists(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2) {

        Node<Integer> intersectionNode = null;
        // 1. make first list a circular linked list, save end node to remove circle from first list
        Node<Integer> head1 = list1.getHead();
        Node<Integer> head2 = list2.getHead();
        if(head1 == null || head2 == null) return null;

        Node<Integer> endNode = null;
        int count1 = 0;
        while(head1.getNext() != null) {
            head1 = head1.getNext();
            count1++;
        }
        endNode = head1;
        head1.setNext(list1.getHead());

        // 2. detect loop in the new circular list1
        Node<Integer> slowPointer = list1.getHead();
        Node<Integer> fastPointer = list1.getHead();

        while(slowPointer != null && fastPointer != null && fastPointer.getNext() != null) {

            if(slowPointer == fastPointer) {
                break;
            }
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }

        // 3. move slowpointer towards head of the second list to detect the begining of second list
        int count = 1;
        while(count < count1) {
            slowPointer = slowPointer.getNext();
            count++;
        }
        while(slowPointer != null && head2 != null) {
            if(slowPointer.getData() == head2.getData()) {
                intersectionNode = slowPointer;
                break;
            }
            head2 = head2.getNext();
        }
        // 4. remove circular loop from list1
        endNode.setNext(null);

        return intersectionNode;
    }

    // Write a recursive function to print reverse of a Linked List
    public Node<Integer> reverseList(MyLinkedList<Integer> list) {

        return reverseListRecur(list, null, list.getHead());
    }

    private Node<Integer> reverseListRecur(MyLinkedList<Integer> list, Node<Integer> head, Node<Integer> current) {

        if(current == null) return head;

        Node<Integer> next = current.getNext();
        current.setNext(head);

        return reverseListRecur(list, current, next);
    }

    // Remove duplicates from a sorted linked list in increasing order
    public void removeDuplicatesFromList(MyLinkedList myLinkedList) {

        if(myLinkedList.getHead() == null) return;

        Node<Integer> currentNode = myLinkedList.getHead();
        Node<Integer> nextNode = currentNode.getNext();
        while(nextNode != null) {

            if(currentNode.getData() == nextNode.getData()) {
                nextNode = nextNode.getNext();
            } else {
                currentNode.setNext(nextNode);
                currentNode = currentNode.getNext();
                nextNode = nextNode.getNext();
            }
        }
        printLinkedList(myLinkedList.getHead());
    }

    // Remove duplicates from an unsorted linked list
    // 1. One method is to sort the list then dedup similar to above method
    // 2. Create hashtable of visited nodes and thus dedup the list
    public void printdedupListUsingHash(MyLinkedList myLinkedList) {

        if(myLinkedList.getHead() == null) return;

        Node<Integer> current = myLinkedList.getHead();
        Node<Integer> prev = myLinkedList.getHead();

        Set<Integer> hashTable = new HashSet<Integer>();

        while(current != null && prev != null) {

            if(!hashTable.isEmpty() && hashTable.contains(current.getData())) {
                prev.setNext(current.getNext());
                current = prev.getNext();
            } else {
                hashTable.add(current.getData());
                prev = current;
                current = current.getNext();
            }
        }
        printLinkedList(myLinkedList.getHead());
    }

    // Move last element to front of a given Linked List
    public void moveLastElementToFront(MyLinkedList myLinkedList) {

        if(myLinkedList.getHead() == null) return;

        Node<Integer> current = myLinkedList.getHead();
        Node<Integer> prev = myLinkedList.getHead();

        while(current.getNext() != null) {

            prev = current;
            current = current.getNext();
        }
        // current = last element
        // prev = second last element

        current.setNext(myLinkedList.getHead());
        myLinkedList.setHead(current);
        prev.setNext(null);

        printLinkedList(myLinkedList.getHead());

    }
    // Pairwise swap elements of a given linked list
    public void swapElementsInLinkedList(MyLinkedList myLinkedList) {

        if(myLinkedList.getHead() == null) return;

        Node<Integer> current = myLinkedList.getHead();
        while(current != null && current.getNext() != null) {

            int temp = current.getData();
            current.setData((Integer)current.getNext().getData());
            current.getNext().setData(temp);

            current = current.getNext().getNext();
        }

        printLinkedList(myLinkedList.getHead());
    }

    public void deleteNode(MyLinkedList<Integer> list, int data) {

        Node<Integer> current = list.getHead();
        Node<Integer> prevNode = current;
        Node<Integer> nextNode;

        while(current != null) {
            if(current.getData() == data) {
                // 1. node to delete is first node
                if(list.getHead() == current) {
                    nextNode = current.next;
                    list.setHead(nextNode);
                    current.next = null;
                }
                // 2. node to delete is last node
                else if(current.next == null) {
                    prevNode.next = null;
                    current.next = null;
                }
                // 3. node to delete is any other node
                else {
                    nextNode=current.next;
                    prevNode.next = nextNode;
                    current.next = null;

                }
            }
            prevNode = current;
            current = current.next;
        }


    }

    // Write code to partition a linked list around a value x, such that all nodes less than
    // x come before all nodes greater than or equal to x.
    public void partitionList(MyLinkedList<Integer> list, int x) {

        // create two linkedlists
        // 1. with values less than x
        // 2. with values greater than or equal to x
        // 3. merge two lists
        // In this problem we just need to separate elements less than x  and greater than x.
        // the order of these elements does not matter, so we can insert elements in both the lists
        // at the begining of the lists (at head) and then merge two lists using head pointers of the two lists

        Node<Integer> beforeHead = null;
        Node<Integer> afterHead = null;

        Node<Integer> current = list.getHead();
        while(current != null) {
            if(current.getData() < x) {
                beforeHead = insertInList(beforeHead, current.getData());
            } else {
                afterHead = insertInList(afterHead, current.getData());
            }
            current = current.next;
        }
        list.setHead(beforeHead);
        while(beforeHead!= null) {
            if(beforeHead.next == null) {
                beforeHead.next = afterHead;
                break;
            }
            beforeHead = beforeHead.next;
        }

    }
    private Node<Integer> insertInList(Node<Integer> head, int data) {

        Node<Integer> newNode = new Node<Integer>(data);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    // You have two numbers represented by a linked list, where each node contains a
    //single digit. The digits are stored in reverse order, such that the Ts digit is at the
    //head of the list. Write a function that adds the two numbers and returns the sum
    //as a linked list.
    //EXAMPLE
    //Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
    //Output: 2 -> 1 -> 9.That is, 912.
    public void add(Node<Integer> first, Node<Integer> second) {

        MyLinkedList<Integer> result = new MyLinkedList<Integer>();
        int sum  = 0;
        int carry = 0;
        while(first != null || second != null) {
            sum = sum + carry;
            if(first != null) {
                sum = sum + first.getData();
                first = first.next;
            }
            if(second != null) {
                sum = sum + second.getData();
                second = second.next;
            }
            Node<Integer> newNode = new Node<Integer>(sum%10);
            result.addAtEnd(newNode);

            carry = sum/10;
            sum = 0;
        }
        if(carry != 0) {
            Node<Integer> newNode = new Node<Integer>(carry);
            result.addAtEnd(newNode);
        }
        result.printLinkedList();
    }
    //FOLLOW UP
    //Suppose the digits are stored in forward order. Repeat the above problem.
    //EXAMPLE
    //Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
    //Output: 9 -> 1 -> 2.That is, 912
    public void addForwardStoredNumber(Node<Integer> first, Node<Integer> second) {

        if(first == null && second == null) return;
        if(first == null && second != null) {
            printLinkedList(second);
            return;
        }
        if(first != null && second == null) {
            printLinkedList(first);
            return;
        }
        Node<Integer> result = null;
        int length1 = 0;
        int length2 = 0;
        Node<Integer> temp = first;
        while (temp != null) {
            temp = temp.next;
            length1++;
        }
        temp = second;
        while (temp != null) {
            temp = temp.next;
            length2++;
        }
        if (length1 < length2) {
            first = padList(first, (length2 - length1));
        } else if (length1 > length2) {
            second = padList(second, (length1 - length2));
        }

        PartialSum sum = getPartialSum(first, second);
        if(sum.getCarry() == 0) {
            result = sum.getSum();
        }
        else {
            result = insertBefore(sum.getSum(), sum.getCarry());
        }
        printLinkedList(result);
    }

    private PartialSum getPartialSum(Node<Integer> first, Node<Integer> second) {

        if(first == null && second == null) {
            PartialSum partialSum = new PartialSum();
            return partialSum;
        }
        PartialSum sum = getPartialSum(first.next, second.next);
        int val = sum.getCarry() + first.getData() + second.getData();

        Node<Integer> full_result = insertBefore(sum.getSum(), val%10);

        sum.setSum(full_result);
        sum.setCarry(val/10);

        return sum;

    }

    private Node<Integer> insertBefore(Node<Integer>node, int digit) {

        Node<Integer> newNode = new Node<Integer>(digit);
        if(node == null) {
            node = newNode;
        } else {
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    private Node<Integer> padList(Node<Integer> head, int padding) {

        Node<Integer> newNode;
        while(padding > 0) {
            newNode = new Node<Integer>(0);
            newNode.next = head;
            head = newNode;
            padding--;
        }
        return head;
    }

    // Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
    // DEFINITION
    // Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
    // so as to make a loop in the linked list.
    // EXAMPLE
    // Input: A - > B - > C - > D - > E - > C [the same C as earlier]
    // Output: C
    public static Node<Character> getBeginingNodeOfLoop(MyLinkedList<Character> list) {

        Node<Character> head = list.getHead();
        Node<Character> slowPointer = head;
        Node<Character> fastPointer = head.next.next;
        while(fastPointer!= null) {
            if (slowPointer != fastPointer) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            } else {
                break;
            }
        }
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next;
        while(slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}

class PartialSum {

    private Node<Integer> sum;
    private int carry=0;

    public void setSum(Node<Integer> sum) {
        this.sum = sum;
    }

    public void setCarry(int carry) {
        this.carry = carry;
    }

    public Node<Integer> getSum() {
        return this.sum;
    }

    public int getCarry() {
        return this.carry;
    }
}

