package com.company;

import com.company.Recursion.*;
import com.company.Recursion.Point;
import com.company.datastructures.*;
import com.company.datastructures.Number;
import com.company.datastructures.expressionTree.ExpressionTree;
import com.company.datastructures.expressionTree.ExpressionTreeNode;
import com.company.datastructures.graph.Graph;
import com.company.datastructures.graph.GraphNode;
import com.company.datastructures.linkedList.MyLinkedList;
import com.company.datastructures.linkedList.Node;
import com.company.datastructures.stack.SetOfStacks;
import com.company.datastructures.stack.SortedStack;
import com.company.datastructures.string.Strings;
import com.company.mathematics.PrimeNumbers;
import com.company.searching.Searching;
import com.company.sorting.*;
import com.ebay.Ebay1;
import com.ebay.Ebay2;
import com.paypal.Paypal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by vnagpurkar on 6/6/16.
 */
public class Main {

    public static void main(String args[]) {

        int[] result = new int[]{0};

        result = Arrays.mergeTwoSortedArrays(new int[]{2, 0, 7, 0, 0, 10, 0}, new int[]{5, 8, 12, 14});
        //result = Arrays.mergeTwoSortedArrays(new int[] {0,0,0,0,2,7,10}, new int[]{5,8,12,14});

        //result = Arrays.arrayRotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 2);
        result = Arrays.arrayRotateReversalAlgorithm(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }

        System.out.println("Maximum sum of elements in array, where no two elements are adjacent " + Arrays.maximumSum(new int[]{3, 2, 5, 10, 7}));

        Arrays.leadersInArray(new int[]{16, 17, 4, 3, 5, 2});

        System.out.println("The element x %d is majority element " + Arrays.isMajority(new int[]{1, 2, 3, 3, 3, 3, 10}, 3));
        System.out.println("The element x %d is majority element " + Arrays.isMajority(new int[]{1, 1, 2, 4, 4, 4, 6, 6}, 4));
        System.out.println("The element x %d is majority element " + Arrays.isMajority(new int[]{1, 1, 1, 2, 2}, 1));

        System.out.println("The element x %d is majority element " + Arrays.isMajorityElement(new int[]{1, 2, 3, 3, 3, 3, 10}, 3));
        System.out.println("The element x %d is majority element " + Arrays.isMajorityElement(new int[]{1, 1, 2, 4, 4, 4, 6, 6}, 4));
        System.out.println("The element x %d is majority element " + Arrays.isMajorityElement(new int[]{1, 1, 1, 2, 2}, 1));

        System.out.println("largest sum contiguous subarray is ");
        Arrays.largestSumContiguousSubArry(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});

        System.out.println("Maximum occurring character " + Strings.getMaximumOccurringChar("test"));
        System.out.println("Maximum occurring character " + Strings.getMaximumOccurringChar("aaababababababababab"));
        System.out.println("Maximum occurring character " + Strings.getMaximumOccurringChar("abbaabababababababababb"));

        System.out.println("Remove duplicates from string " + Strings.dedupInput("geeksforgeeks"));
        System.out.println("Remove duplicates from string " + Strings.dedupInput("nitin"));
        System.out.println("Remove duplicates from string " + Strings.dedupInput("aabbcdfgggh"));
        System.out.println("Remove duplicates from string " + Strings.dedupInput("vrunda"));
        System.out.println("Remove duplicates from string " + Strings.dedupInput(""));
        System.out.println("Remove duplicates from string " + Strings.dedupInput("%%%%%%^fghfgh"));

        Strings.printDuplicates("geeksforgeeks");
        Strings.printDuplicates("nitin");
        Strings.printDuplicates("aabbcdfgggh");
        Strings.printDuplicates("vrunda");
        Strings.printDuplicates("");
        Strings.printDuplicates("%%%%%%^fghfgh");

        System.out.println("Remove Second String From First String: " + Strings.removeSecondStringFromFirstString("test string", "mask"));
        System.out.println("Revesre a string recursively - " + Strings.reverseString("abcddddddeonitin"));

        System.out.println("Str2 is rotation of Str1 " + Strings.areRotations("ABCD", "CDAB"));
        System.out.println("Str2 is rotation of Str1 " + Strings.areRotations("ABCD", "CDABE"));
        System.out.println("Str2 is rotation of Str1 " + Strings.areRotations("ABCD12", "CDAB21"));


        Strings.permutation("ABC");
        Strings.printStringDivisions("ABC", 1);
        Strings.printStringDivisions("ABC", 3);
        Strings.printStringDivisions("Hi I Am a girl", 7);

        Strings.firstNonRepCharInOOf1("geeksforgeeks");
        Strings.firstNonRepCharInOOf1("geeksgeeks");
        Strings.firstNonRepCharInOOf1("zxzzab");
        Strings.firstNonRepCharInOOf1("GeeksQuiz");

        Strings.firstNonRepChar("geeksforgeeks");
        Strings.firstNonRepChar("geeksgeeks");
        Strings.firstNonRepChar("zxzzab");
        Strings.firstNonRepChar("GeeksQuiz");

        List<String> items = new ArrayList<String>();
        items.add("sunday");
        items.add("geeksforgeeks");
        items.add("utensils");
        items.add("just");
        items.add("sss");
        Strings.printListOfItems("sun", items);

        Arrays.segregate2Elements(new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0});
        Arrays.segregate2Elements(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        Arrays.segregate2Elements(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,});
        Arrays.segregate2Elements(new int[]{1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1});
        Arrays.segregate3Elements(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});

        Arrays.maxDifference(new int[]{2, 3, 10, 6, 4, 8, 1});
        Arrays.maxDifference(new int[]{7, 9, 5, 6, 3, 2});

        /*Arrays.smallestPositiveMissingNumber(new int[]{2, 3, 7, 6, 8, -1, -10, 15});
        Arrays.smallestPositiveMissingNumber(new int[]{2, 3, -7, 6, 8, 1, -10, 15});
        Arrays.smallestPositiveMissingNumber(new int[]{1, 1, 0, -1, -2});*/


        Arrays.find2RepeatingMissingElelemtns(new int[]{1, 2, 3, 4, 5, 6, 3, 4});
        Arrays.findNonRepeatingMissingElelemtns(new int[]{1, 2, 3, 4, 5, 6, 3, 4, 2, 1});
        Arrays.findNonRepeatingMissingElelemtnsXOR(new int[]{1, 2, 3, 4, 5, 6, 3, 4, 2, 1});
        Arrays.findNonRepeatingMissingElelemtnsXOR(new int[]{1, 2, 1, 2, 5, 6});

        Arrays.findDuplicateElements(new int[]{1, 2, 3, 1, 3, 6, 6});

        Home.sumFibinacci(10);

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtBegining(1);
        myLinkedList.addAtBegining(2);
        myLinkedList.addAtBegining(3);
        myLinkedList.addAtBegining(4);
        myLinkedList.addAtBegining(5);

        myLinkedList.getHead().getNext().getNext().getNext().setNext(myLinkedList.getHead());

        System.out.println(myLinkedList.detectCycleInLinkedList());
        if (!myLinkedList.detectCycleInLinkedList()) myLinkedList.printLinkedList();

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);

        //myLinkedList.getHead().next.next.next.next.next=myLinkedList.getHead();
        System.out.println(myLinkedList.detectCycleInLinkedList());
        myLinkedList.printLinkedList();

        myLinkedList = new MyLinkedList<Integer>();
        // 1->10->30->14; list is traversed in reverse of insersion order,
        // since head pointer moves with insersion of every new element
        myLinkedList.addAtBegining(14);
        myLinkedList.addAtBegining(30);
        myLinkedList.addAtBegining(10);
        myLinkedList.addAtBegining(1);

        System.out.println(myLinkedList.getNth(myLinkedList, 0));
        System.out.println(myLinkedList.getNth(myLinkedList, 2));

        System.out.println("Before deleting ");
        myLinkedList.printLinkedList();
        myLinkedList.deleteANode(myLinkedList.getHead().getNext());
        System.out.println("After deleting ");
        myLinkedList.printLinkedList();

        System.out.println("Before deleting ");
        myLinkedList.printLinkedList();
        myLinkedList.deleteANode(myLinkedList.getHead());
        System.out.println("After deleting ");
        myLinkedList.printLinkedList();

        // To delete last node, we need to change singly linked list to XOR list or memory efficient list
        // otherwise this will not work
        /*System.out.println("Before deleting ");
        myLinkedList.printLinkedList();
        myLinkedList.deleteANode(myLinkedList.getHead().next.next.next);
        System.out.println("After deleting ");
        myLinkedList.printLinkedList();*/

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(5);

        Node middle = myLinkedList.getMiddleOfLinkedList(myLinkedList);
        System.out.println("Middle element of 5->Null is " + middle.getData());

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);

        middle = myLinkedList.getMiddleOfLinkedList(myLinkedList);
        System.out.println("Middle element of 4->5->Null is " + middle.getData());

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);

        middle = myLinkedList.getMiddleOfLinkedList(myLinkedList);
        System.out.println("Middle element of 3->4->5->Null is " + middle.getData());

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);

        middle = myLinkedList.getMiddleOfLinkedList(myLinkedList);
        System.out.println("Middle element of 1->2->3->4->5->Null is " + middle.getData());

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(6);

        middle = myLinkedList.getMiddleOfLinkedList(myLinkedList);
        System.out.println("Middle element of 1->2->3->4->5->6->Null is " + middle.getData());

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(6);

        Node nthNodeFromEnd = myLinkedList.getNthNodeFromEnd(myLinkedList, 1);
        if (nthNodeFromEnd != null) {
            System.out.println("Nth Node from the end of 1->2->3->4->5->6->Null is " + nthNodeFromEnd.getData());
        } else {
            System.out.println("Nth node is not present");
        }

        nthNodeFromEnd = myLinkedList.getNthNodeFromEnd(myLinkedList, 2);
        if (nthNodeFromEnd != null) {
            System.out.println("Nth Node from the end of 1->2->3->4->5->6->Null is " + nthNodeFromEnd.getData());
        } else {
            System.out.println("Nth node is not present");
        }

        nthNodeFromEnd = myLinkedList.getNthNodeFromEnd(myLinkedList, 6);
        if (nthNodeFromEnd != null) {
            System.out.println("Nth Node from the end of 1->2->3->4->5->6->Null is " + nthNodeFromEnd.getData());
        } else {
            System.out.println("Nth node is not present");
        }

        nthNodeFromEnd = myLinkedList.getNthNodeFromEnd(myLinkedList, 0);
        if (nthNodeFromEnd != null) {
            System.out.println("Nth Node from the end of 1->2->3->4->5->6->Null is " + nthNodeFromEnd.getData());
        } else {
            System.out.println("Nth node is not present");
        }

        nthNodeFromEnd = myLinkedList.getNthNodeFromEnd(myLinkedList, 7);
        if (nthNodeFromEnd != null) {
            System.out.println("Nth Node from the end of 1->2->3->4->5->6->Null is " + nthNodeFromEnd.getData());
        } else {
            System.out.println("Nth node is not present");
        }

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtBegining(14);
        myLinkedList.addAtBegining(30);
        myLinkedList.addAtBegining(10);
        myLinkedList.addAtBegining(1);

        System.out.println("Before deleting ");
        myLinkedList.printLinkedList();
        myLinkedList.deleteLinkedListByEachNode();
        System.out.println("After deleting ");
        myLinkedList.printLinkedList();

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(1);

        System.out.println(String.format("Occurances of %d in list = %d", 3, myLinkedList.countOccurranceOfKeyInList(myLinkedList, 3)));
        System.out.println(String.format("Occurances of %d in list = %d", 2, myLinkedList.countOccurranceOfKeyInList(myLinkedList, 2)));
        System.out.println(String.format("Occurances of %d in list = %d", 1, myLinkedList.countOccurranceOfKeyInList(myLinkedList, 1)));

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(6);
        System.out.println("Original linked list");
        myLinkedList.printLinkedList();
        myLinkedList = myLinkedList.printReverseList();
        if (myLinkedList != null) {
            System.out.println("Reversed linked list");
            myLinkedList.printLinkedList();
        }

        MyLinkedList<Character> charList = new MyLinkedList<Character>();

        charList.addAtEnd('a');
        charList.addAtEnd('n');
        charList.addAtEnd('i');
        charList.addAtEnd('t');
        charList.addAtEnd('i');
        charList.addAtEnd('n');

        System.out.println("Is palindrome? " + charList.isPalindrome(charList));
        System.out.println("Is palindrome? " + charList.isPalindromeMethod2(charList));
        //System.out.println("Is palindrome? " + charList.isPalindromeMethod3(charList));

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(7);
        myLinkedList.addAtEnd(10);
        myLinkedList.addAtEnd(15);

        System.out.println("List before insert ");
        myLinkedList.printLinkedList();
        myLinkedList.insertInSortedList(myLinkedList, 9);
        System.out.println("List after insert ");
        myLinkedList.printLinkedList();

        System.out.println("List before insert ");
        myLinkedList.printLinkedList();
        myLinkedList.insertInSortedListUsingOnePointer(myLinkedList, 9);
        System.out.println("List after insert ");
        myLinkedList.printLinkedList();

        MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<Integer>();

        myLinkedList1.addAtEnd(3);
        myLinkedList1.addAtEnd(6);
        myLinkedList1.addAtEnd(9);
        myLinkedList1.addAtEnd(15);
        myLinkedList1.addAtEnd(30);

        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<Integer>();
        myLinkedList2.addAtEnd(10);
        myLinkedList2.addAtEnd(myLinkedList1.getHead().getNext().getNext().getNext());

        Node<Integer> intersectionNode = myLinkedList.getIntersectionPointOf2Lists(myLinkedList1, myLinkedList2);

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(6);
        myLinkedList.addAtEnd(7);

        System.out.print("Print before reverse ");
        myLinkedList.printLinkedList();
        System.out.print("Print after reverse ");
        Node<Integer> head = myLinkedList.reverseList(myLinkedList);
        myLinkedList.printLinkedList(head);

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(21);
        myLinkedList.addAtEnd(43);
        myLinkedList.addAtEnd(43);
        myLinkedList.addAtEnd(60);

        System.out.print("Print before dedup ");
        myLinkedList.printLinkedList();
        System.out.print("Print after dedup ");
        myLinkedList.removeDuplicatesFromList(myLinkedList);

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(21);
        myLinkedList.addAtEnd(43);
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(43);
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(60);

        System.out.print("Print before");
        myLinkedList.printLinkedList();
        System.out.print("Print after");
        myLinkedList.printdedupListUsingHash(myLinkedList);

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList<Integer>();
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(11));
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(21));
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(43));
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(11));
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(43));
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(11));
        doublyLinkedList.addAtEnd(new DoublyLinkedNode<Integer>(60));

        System.out.print("Print before");
        doublyLinkedList.printDoublyLinkedList();
        System.out.print("Print after");
        doublyLinkedList.printReversedDoublyLinkedList(doublyLinkedList);

        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addAtEnd(new Node<Integer>(12));
        circularLinkedList.addAtEnd(new Node<Integer>(56));
        circularLinkedList.addAtEnd(new Node<Integer>(2));
        circularLinkedList.addAtEnd(new Node<Integer>(11));
        circularLinkedList.addAtEnd(new Node<Integer>(25));

        System.out.print("Print before circular linked list");
        circularLinkedList.printLinkedList();
        System.out.print("Print after circular linked list");
        circularLinkedList.splitCircularLinkedListIn2Halves(circularLinkedList);

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(21);
        myLinkedList.addAtEnd(43);
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(43);
        myLinkedList.addAtEnd(11);
        myLinkedList.addAtEnd(60);

        System.out.print("Original list");
        myLinkedList.printLinkedList();
        System.out.print("Updated list");
        myLinkedList.moveLastElementToFront(myLinkedList);

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);

        System.out.print("Original list");
        myLinkedList.printLinkedList();
        System.out.print("Updated list");
        myLinkedList.swapElementsInLinkedList(myLinkedList);

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(7);

        System.out.print("Original list");
        myLinkedList.printLinkedList();
        System.out.print("Updated list");
        myLinkedList.swapElementsInLinkedList(myLinkedList);

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(5);
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(2);
        binarySearchTree.add(1);

        System.out.println("Binary Search Tree preorder ");
        binarySearchTree.printBinaryTreeInOrder(binarySearchTree.getRoot());

        binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(5);
        binarySearchTree.add(3);
        binarySearchTree.add(9);
        binarySearchTree.add(6);
        binarySearchTree.add(1);
        binarySearchTree.add(4);

        System.out.println("Binary Search Tree preorder ");
        binarySearchTree.printBinaryTreeInOrder(binarySearchTree.getRoot());

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);

        System.out.println("Binary tree preorder recursive ");
        binaryTree.printBinaryTreePreOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("Binary tree non-recursive preorder ");
        binaryTree.nonRecursivePreOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("Binary tree inorder recursive");
        binaryTree.printBinaryTreeInOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("Binary non-recursive tree inorder ");
        binaryTree.nonRecursiveInOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("Binary tree postorder recursive");
        binaryTree.printBinaryTreePostOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("Binary tree postorder non-recursive using two stacks");
        binaryTree.nonRecursivePostOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("Binary tree postorder non-recursive using one stack");
        binaryTree.nonRecursivePostOrderUsingOneStack(binaryTree.getRoot());
        System.out.println();

        binaryTree.add(100);
        binaryTree.add(200);
        binaryTree.printSizeOfTree(binaryTree.getRoot());

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.add(1);
        binaryTree1.add(200);
        binaryTree1.add(3);
        binaryTree1.add(45);
        binaryTree1.add(5);

        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.add(1);
        binaryTree2.add(2000);
        binaryTree2.add(3);
        binaryTree2.add(45);
        binaryTree2.add(5);

        System.out.println("Two trees are identical " + binaryTree1.areIdentical(binaryTree1.getRoot(), binaryTree2.getRoot()));
        System.out.println("Maximum depth of the tree " + binaryTree.getMaxDepthOfTree(binaryTree.getRoot()));

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        System.out.println("Breadth First Search on binary tree");
        bfs.breadthFirstSearchOnTree(binaryTree.getRoot());
        System.out.println();

        Graph graph = new Graph();
        graph.populateGraph();
        GraphNode vertex = graph.getVertex();
        DepthFirstSearch dfs = new DepthFirstSearch();
        System.out.println("Depth First Search on binary tree");
        dfs.depthFirstSearchOnGraph(vertex);
        System.out.println();

        System.out.println("Breadth First Search on graph");
        bfs.breadthFirstSearchOnGraph(vertex);
        System.out.println();

        boolean[][] matrix = new boolean[3][4];
        matrix[0] = new boolean[]{false, false, true, false};
        matrix[1] = new boolean[]{true, false, false, false};
        matrix[2] = new boolean[]{true, false, false, true};

        System.out.println("Matrix before.");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + ",");
            }
            System.out.println();
        }
        matrix = Matrix.modifyBooleanMatrix(matrix);

        System.out.println("Matrix after.");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + ",");
            }
            System.out.println();
        }

        matrix = new boolean[3][4];
        matrix[0] = new boolean[]{false, false, true, false};
        matrix[1] = new boolean[]{true, false, false, false};
        matrix[2] = new boolean[]{true, false, false, true};

        System.out.println("Matrix before method 2.");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + ",");
            }
            System.out.println();
        }
        matrix = Matrix.modifyBooleanMatrixMethod2(matrix);

        System.out.println("Matrix after method 2.");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + ",");
            }
            System.out.println();
        }

        int[][] input = new int[6][5];
        input[0] = new int[]{0, 1, 1, 0, 1};
        input[1] = new int[]{1, 1, 0, 1, 0};
        input[2] = new int[]{0, 1, 1, 1, 0};
        input[3] = new int[]{1, 1, 1, 1, 0};
        input[4] = new int[]{1, 1, 1, 1, 1};
        input[5] = new int[]{0, 0, 0, 0, 0};

        Matrix.maxSubMatrixWithOnes(input);

        input = new int[4][4];
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{2, 6, 9, 12};
        input[2] = new int[]{3, 7, 9, 13};
        input[3] = new int[]{4, 8, 10, 14};

        System.out.println(String.format("Is %d present in input ? %b", 13, Matrix.isPresent(input, 13)));
        System.out.println(String.format("Is %d present in input ? %b", 8, Matrix.isPresent(input, 8)));
        System.out.println(String.format("Is %d present in input ? %b", 0, Matrix.isPresent(input, 0)));
        System.out.println(String.format("Is %d present in input ? %b", 1, Matrix.isPresent(input, 1)));
        System.out.println(String.format("Is %d present in input ? %b", 4, Matrix.isPresent(input, 4)));
        System.out.println(String.format("Is %d present in input ? %b", 14, Matrix.isPresent(input, 14)));

        input = new int[4][4];
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{2, 6, 9, 12};
        input[2] = new int[]{3, 7, 9, 13};
        input[3] = new int[]{4, 8, 10, 14};

        Strings.printFindElement(input, 13);
        Strings.printFindElement(input, 8);
        Strings.printFindElement(input, 0);
        Strings.printFindElement(input, 1);
        Strings.printFindElement(input, 4);
        Strings.printFindElement(input, 14);

        input = new int[4][4];
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{12, 13, 14, 5};
        input[2] = new int[]{11, 16, 15, 6};
        input[3] = new int[]{10, 9, 8, 7};

        System.out.println("Spiral Matrix ");
        Matrix.printMatrixInSpiralForm(input);

        System.out.print("Magic Square ");
        Matrix.printMagicSquare(3);
        Matrix.printMagicSquare(5);

        input = new int[4][5];
        input[0] = new int[]{2, 1, -3, -4, 5};
        input[1] = new int[]{0, 6, 3, 4, 1};
        input[2] = new int[]{2, -2, -1, 4, -5};
        input[3] = new int[]{-3, 3, 1, 0, 3};

        Matrix.printMaximumSumRectangle(input);

        System.out.println();
        Arrays.printSortedArrayOfZeroAndOne(new int[]{1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0});

        input = new int[5][4];
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{5, 6, 7, 8};
        input[2] = new int[]{9, 10, 11, 12};
        input[3] = new int[]{13, 14, 15, 16};
        input[4] = new int[]{17, 18, 19, 20};

        Matrix.printMatrixDiagonally(input);

        input = new int[3][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 5, 6};
        input[2] = new int[]{7, 8, 9};

        Matrix.printMatrixDiagonally(input);

        input = new int[6][7];
        input[0] = new int[]{1, 2, 3, 4, 5, 6, 7};
        input[1] = new int[]{8, 9, 10, 11, 12, 13, 14};
        input[2] = new int[]{15, 16, 17, 18, 19, 20, 21};
        input[3] = new int[]{22, 23, 24, 25, 26, 27, 28};
        input[4] = new int[]{29, 30, 31, 32, 33, 34, 35};
        input[5] = new int[]{36, 37, 38, 39, 40, 41, 42};

        Matrix.printMatrixDiagonally(input);

        input = new int[3][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 8, 2};
        input[2] = new int[]{1, 5, 3};

        System.out.println("Min Cost Matrix " + Matrix.minCostPath(input, 2, 2));

        input = new int[3][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 1, 2};
        input[2] = new int[]{1, 5, 1};

        System.out.println("Min Cost Matrix " + Matrix.minCostPath(input, 2, 2));

        System.out.println("Number/Count of all paths in matrix recursively " + Matrix.printAllPathsFromTopLeftToBottomRight(new int[3][3]));
        System.out.println("Number/Count of all paths in matrix nonRecursively " + Matrix.printAllPathsFromTLToBRNonRecursive(new int[3][3]));
        System.out.println("Number/Count of all paths in matrix using formula " + Matrix.printAllPathsUsingFormula(new int[3][3]));

        Trie trie = new Trie();
        boolean[][] booleanMatrix = new boolean[4][5];
        booleanMatrix[0] = new boolean[]{false, true, false, false, true};
        booleanMatrix[1] = new boolean[]{true, false, true, true, false};
        booleanMatrix[2] = new boolean[]{false, true, false, false, true};
        booleanMatrix[3] = new boolean[]{true, true, true, false, false};

        trie.printUniqueRows(booleanMatrix);

        BubbleSort.printBubbleSortedNumbers(new int[]{10,9,8,7,6,5,4,3,2,1});
        BubbleSort.printBubbleSortedNumbersDesc(new int[]{1,2,3,4,5,6,7,8,9,10});

        InsertionSort.printInsertionSort(new int[]{10,9,8,7,6,5,4,3,2,1});
        InsertionSort.printInsertionSort(new int[]{100, 15,20,2});
        SelectionSort.printSelectionSort(new int[]{10,9,8,7,6,5,4,3,2,1});
        //QuickSort.printQuickSort(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println("Quick Sort");
        QuickSort.printQuickSort(new int[]{100, 23, 45, 56, 67});

        System.out.println("Non-Recursive");
        boolean isPresent = Searching.isNumberPresentUsingBS(new int[]{7,9,15,23,25,100}, 7);
        System.out.println("is number present "+isPresent);

        System.out.println("Recursive");
        isPresent = Searching.binarySearchRecursive(new int[]{7,9,15,23,25,100}, 7);
        System.out.println("is number present "+isPresent);

        HeapSort.heapSort(new int[]{15,25,100,1,2});
        HeapSort.heapSort(new int[]{1,2,3,4,5,6,7,8,9,10});
        HeapSort.heapSortDesc(new int[]{10,9,8,7,6,5,4,3,2,1});
        HeapSort.heapSortDesc(new int[]{-2,1,6,2,9,8,10,5,3,0});
        HeapSort.heapSortDesc(new int[]{1,3,6,5,9,8});

        Strings.sortStringsLexicographically("ABC");
        Strings.sortStringsLexicographically("ABCD");

        System.out.println("Lexicographic rank of a string "+ Strings.getLexicographicRankOfString("ABC", "CBA"));
        System.out.println("Lexicographic rank of a string "+ Strings.getLexicographicRankOfString("ABC","ACB"));

        System.out.println("Minimum # of palindromic subsequences to be removed " +
                "to empty a binary string " + Strings.minimumPalindromicSequences("10001"));
        System.out.println("Minimum # of palindromic subsequences to be removed " +
                "to empty a binary string " + Strings.minimumPalindromicSequences("10001001"));

        Strings.getPowerSetInJava(new Character[]{'a','b','c'});
        System.out.println();
        Strings.getPowerSetInJava(new Character[]{'a','b','c','d'});
        System.out.println();

        Strings.printSubArray(new Character[]{'a','b','c'});

        Strings.printDialiNumberCombinations(23);
        Strings.printDialiNumberCombinations(234);

        Strings.previousLexicographicPermutation("ABDC");
        Strings.previousLexicographicPermutation("ACBD");
        Strings.previousLexicographicPermutation("CBDA");

        System.out.println("ToUpperCase "+ Strings.toUpperCase("geeksforgeeks"));
        System.out.println("ToLowerCase "+ Strings.toLowerCase("GEEKSFORGEEKS"));

        Strings.printRearrangedString("aaaacbbbcd", 2);
        Strings.printRearrangedString("abb", 2);
        Strings.printRearrangedString("aacbbc", 2);
        Strings.printRearrangedString("geeksforgeeks", 2);
        Strings.printRearrangedString("aaa", 2);

        int[] heap = new int[10];
        heap[0] = 1;
        heap[1] = 3;
        heap[2] = 6;
        heap[3] = 5;
        heap[4] = 9;
        heap[5] = 8;
        //Heap.insertInBinaryMinHeap(heap, 10);
        //Heap.insertInBinaryMinHeap(heap, -2);
        //Heap.insertInBinaryMinHeap(heap, 2);

        Heap.insertInBinaryMaxHeap(heap, 10);

        Number.printPermutations(new int[]{1, 2, 3});

        binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(5);
        binarySearchTree.add(3);
        binarySearchTree.add(9);
        binarySearchTree.add(6);
        binarySearchTree.add(1);
        binarySearchTree.add(4);

        binarySearchTree.printSumPairInBST(binarySearchTree.getRoot(), 9);

        Strings.printAllPermutationsOfString("ABC");

        Puzzles.printUnitsOfTrappedWater(new int[]{4,2,6});
        Puzzles.printUnitsOfTrappedWater(new int[]{2,4,6});
        Puzzles.printUnitsOfTrappedWater(new int[]{6,4,2});

        Arrays.smallestPositiveMissingNumber(new int[]{2, 3, 7, 6, 8, -1, -10, 15});
        Arrays.smallestPositiveMissingNumber(new int[]{2, 3, -7, 6, 8, 1, -10, 15});

        Strings.replaceSpacesInStringInPlace("Mr John Smith".toCharArray());

        System.out.println(Strings.compressedString("aabcccccaaa"));

        int[][] matrixInput = new int[5][6];
        matrixInput[0] = new int[]{1,0,1,1,1,1};
        matrixInput[1] = new int[]{0,1,1,1,1,1};
        matrixInput[2] = new int[]{1,0,1,0,1,1};
        matrixInput[3] = new int[]{1,0,1,0,1,1};
        matrixInput[4] = new int[]{1,0,1,0,1,1};
        Matrix.printArrangedMatrix(matrixInput);
        System.out.println();

        System.out.println(Strings.isS2RotationOfS1("erbottLewat", "waterbottLe"));
        System.out.println(Strings.isS2RotationOfS1("erbottLewatl", "waterbottLe"));

        System.out.println(Number.numberOfTrailingZeros(5));
        System.out.println(Number.numberOfTrailingZeros(20));
        System.out.println(Number.numberOfTrailingZeros(45));
        System.out.println(Number.numberOfTrailingZeros(100));

        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addAtEnd(new DoublyLinkedNode<Integer>(1));
        list.addAtEnd(new DoublyLinkedNode<Integer>(2));
        list.addAtEnd(new DoublyLinkedNode<Integer>(3));
        list.addAtEnd(new DoublyLinkedNode<Integer>(4));
        list.addAtEnd(new DoublyLinkedNode<Integer>(5));

        list.printDoublyLinkedList();
        list.deleteNode(list, 1);
        list.printDoublyLinkedList();

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(new Node<Integer>(1));
        myLinkedList.addAtEnd(new Node<Integer>(2));
        myLinkedList.addAtEnd(new Node<Integer>(3));
        myLinkedList.addAtEnd(new Node<Integer>(4));
        myLinkedList.addAtEnd(new Node<Integer>(5));

        myLinkedList.printLinkedList();
        myLinkedList.deleteNode(myLinkedList, 3);
        myLinkedList.printLinkedList();

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(new Node<Integer>(25));
        myLinkedList.addAtEnd(new Node<Integer>(10));
        myLinkedList.addAtEnd(new Node<Integer>(80));
        myLinkedList.addAtEnd(new Node<Integer>(40));
        myLinkedList.addAtEnd(new Node<Integer>(5));
        myLinkedList.addAtEnd(new Node<Integer>(1));

        myLinkedList.printLinkedList();
        myLinkedList.partitionList(myLinkedList, 10);
        myLinkedList.printLinkedList();

        myLinkedList1 = new MyLinkedList<Integer>();
        myLinkedList1.addAtEnd(7);
        myLinkedList1.addAtEnd(1);
        myLinkedList1.addAtEnd(8);
        myLinkedList1.printLinkedList();

        myLinkedList2 = new MyLinkedList<Integer>();
        myLinkedList2.addAtEnd(5);
        myLinkedList2.addAtEnd(9);
        myLinkedList2.addAtEnd(2);
        myLinkedList2.printLinkedList();

        myLinkedList1.add(myLinkedList1.getHead(), myLinkedList2.getHead());

        myLinkedList1 = new MyLinkedList<Integer>();
        myLinkedList1.addAtEnd(7);
        myLinkedList1.addAtEnd(1);
        myLinkedList1.addAtEnd(6);
        myLinkedList1.printLinkedList();

        myLinkedList2 = new MyLinkedList<Integer>();
        myLinkedList2.addAtEnd(5);
        myLinkedList2.addAtEnd(9);
        myLinkedList2.printLinkedList();

        myLinkedList1.add(myLinkedList1.getHead(), myLinkedList2.getHead());

        myLinkedList1 = new MyLinkedList<Integer>();
        myLinkedList1.addAtEnd(8);
        myLinkedList1.addAtEnd(1);
        myLinkedList1.addAtEnd(7);
        myLinkedList1.printLinkedList();

        myLinkedList2 = new MyLinkedList<Integer>();
        myLinkedList2.addAtEnd(2);
        myLinkedList2.addAtEnd(9);
        myLinkedList2.addAtEnd(5);
        myLinkedList2.printLinkedList();
        myLinkedList1.addForwardStoredNumber(myLinkedList1.getHead(), myLinkedList2.getHead());

        charList = new MyLinkedList<Character>();
        charList.addAtEnd('A');
        charList.addAtEnd('B');
        Node<Character> loopNode = new Node<Character>('C');
        charList.addAtEnd(loopNode);
        charList.addAtEnd('D');
        charList.addAtEnd('E');
        charList.addAtEnd(loopNode);
        //charList.printLinkedList();

        System.out.println(charList.getBeginingNodeOfLoop(charList).getData());


        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        setOfStacks.push(9);
        setOfStacks.push(10);
        setOfStacks.push(11);
        setOfStacks.push(12);
        setOfStacks.push(13);
        setOfStacks.push(14);
        setOfStacks.push(15);
        setOfStacks.push(16);

        int val = setOfStacks.popAt(0);

        SortedStack sortedStack = new SortedStack();
        sortedStack.push(7);
        sortedStack.push(100);
        sortedStack.push(5);
        sortedStack.push(4);
        sortedStack.push(30);
        sortedStack.push(2);
        sortedStack.push(1);

        val = sortedStack.peek();

        PrimeNumbers.printListOfPrimeNumbers(20);
        PrimeNumbers.printListOfPrimeNumbers(120);

        TowersOfHanoi.moveDisks();

        binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(12);
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(17);
        binarySearchTree.add(3);
        binarySearchTree.add(7);
        binarySearchTree.add(13);
        binarySearchTree.add(1);
        binarySearchTree.add(9);
        binarySearchTree.add(14);
        binarySearchTree.add(20);
        binarySearchTree.add(8);
        binarySearchTree.add(11);
        binarySearchTree.add(18);

        binarySearchTree.deleteANode(binarySearchTree.getRoot(),15);

        Recursion.printParens(3);
        System.out.println();
        System.out.println();
        System.out.println();
        Recursion.printParensDP(3);
        Recursion.stringPermutations("a");
        Recursion.stringPermutations("abc");
        Recursion.findMagicIndexDistinct(new int[] {-40,-20, -1,1,2,3,5,7,9,12,13});
        Recursion.findMagicIndexDistinct(new int[] {-40,-20, 1,2,2,3,5,7,9,12,13});

        /*ThreadImplementation1 thread1 = new ThreadImplementation1();
        System.out.println("Thread using runnable interface.");
        thread1.run();
        System.out.println("Thread control is returned");

        ThreadImplementation1 threadRunnable = new ThreadImplementation1();
        System.out.println("Thread is passing object of class, which implemented runnable interface.");
        Thread thread = new Thread(threadRunnable);
        thread.start();

        while(threadRunnable.count != 5) {
            try {
                System.out.println("Waiting till count is less than 5");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Completed thread implementation");*/

        Strings.printAndSortStringsBasedOnLength(new String[] {"abcd","a","ldd","lhjfhjdfshfdshhjdsf", "345","45"});

        Strings.removeCharFromString("vrunda",'r');
        Strings.removeCharFromString("vrunda",'l');

        Strings.getHighestOccurredCharacter("aaaaaaaaaaaaaaaaabbbbcddddeeeeee");

        int res = Strings.contains("abcdefghijkl", "fgh");
        System.out.println("String1 contains String2 ? "+ (res==0));

        Strings.reverseWords("I am a girl.");
        Strings.reverseWords("Java is best programming language.");

        System.out.println(String.format("Is %s is palindrome? %b", "nitin",Strings.isPalindrome("nitin")));
        System.out.println(String.format("Is %s is palindrome? %b", "abcdba",Strings.isPalindrome("abcdba")));
        System.out.println(String.format("Is %s is palindrome? %b", "abcd",Strings.isPalindrome("abcd")));
        System.out.println(String.format("Is %s is palindrome? %b", "aba",Strings.isPalindrome("aba")));

        System.out.println(Number.convertNumericStringToInt("67263"));
        System.out.println(Strings.countOccurence("java", 'a'));

        List<Set<String>> groupedAnagrams = Strings.getAnagramsTogether(new String[]{"bat","top","ant","pot","act","tab","cat","tan"});
        System.out.println(1);
        for(Set<String> set: groupedAnagrams) {
            for(String s:set) {
                System.out.print(s+",");
            }
        }
        System.out.println();

        Strings.printAnagramsTogetherUsingComparator(new String[]{"bat","top","ant","pot","act","tab","cat","tan"});
        Strings.printAnagramsTogether(new String[]{"bat","top","ant","pot","act","tab","cat","tan"});

        Strings.printSortedArraysAtBegining(new int[]{1,3,5,9,11,0,0,0,0,0}, new int[]{2,4,6,8,10});
        Strings.printSortedArraysAtEnd(new int[]{1,3,11,0,0,0,0,0}, new int[]{2,4,6,8,10});

        Number.getSimilarityIndex(new int[]{1,1,2,3,3,4,5,7,9}, new int[]{1,1,2,2,5,8,9,10,10,10,100});

        System.out.println("Number of 1's "+ Ebay2.numberOfOnes(10));
        System.out.println("Number of 1's "+ Ebay2.numberOfOnes(100000));

        System.out.println(" Less Efficient Method");
        Ebay2.lessEfficientStartAndEndIndexesOfN(new int[]{0,0,1,1,1,5,5,6,6,6,6,7,11}, 5);
        Ebay2.lessEfficientStartAndEndIndexesOfN(new int[]{2,2,2,2,2,2,2,2}, 2);
        Ebay2.lessEfficientStartAndEndIndexesOfN(new int[]{0,0,1,1,1,5,5,6,6,6,6,7,11}, 100);
        Ebay2.lessEfficientStartAndEndIndexesOfN(new int[]{0,0,1,1,1,5,5,6,6,6,6,7,11}, 7);

        System.out.println(" More Efficient Method");
        Ebay2.printStartAndEndIndexesOfN(new int[]{0,0,1,1,1,5,5,6,6,6,6,7,11}, 5);
        Ebay2.printStartAndEndIndexesOfN(new int[]{2,2,2,2,2,2,2,2}, 2);
        Ebay2.printStartAndEndIndexesOfN(new int[]{0,0,1,1,1,5,5,6,6,6,6,7,11}, 100);
        Ebay2.printStartAndEndIndexesOfN(new int[]{0,0,1,1,1,5,5,6,6,6,6,7,11}, 7);

        String paragraph = "I am a girl. I study in 12th std. I love paintings, listening music etc";
        System.out.println(String.format("Count of word %s in paragraph %s = %d", "I",paragraph, Ebay1.countWords(paragraph, "I")));
        System.out.println(String.format("Count of word %s in paragraph %s = %d", "am", paragraph, Ebay1.countWords(paragraph, "am")));
        System.out.println(String.format("Count of word %s in paragraph %s = %d", "loooo",paragraph, Ebay1.countWords(paragraph, "looooo")));

        Ebay1.delDel("adelbc");

        Paypal.printArray(new int[] {7, 5, 6, 3, 4, 1, 2, 9, 11});

        myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addAtEnd(1);
        myLinkedList.addAtEnd(2);
        myLinkedList.addAtEnd(3);
        myLinkedList.addAtEnd(4);
        myLinkedList.addAtEnd(5);
        myLinkedList.addAtEnd(6);
        myLinkedList.addAtEnd(7);
        myLinkedList.addAtEnd(8);
        myLinkedList.addAtEnd(9);
        myLinkedList.printLinkedList();
        Paypal.printOneThirdTwoThirdEfficiently(myLinkedList);

        binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(5);
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(2);
        binarySearchTree.add(1);

        binarySearchTree.printBinaryTreeInOrder(binarySearchTree.getRoot());
        System.out.println("Binary tree is BST = " + BinarySearchTree.checkIfBinarySearchTree(binarySearchTree.getRoot()));

        Ebay1.getClassName();

        PrimeNumbers.findKthNumber(10);

        Color[][] screen = new Color[4][5];
        screen[0] = new Color[] {Color.blue, Color.gray, Color.gray, Color.blue, Color.blue};
        screen[1] = new Color[] {Color.gray, Color.blue, Color.black, Color.gray, Color.pink};
        screen[2] = new Color[] {Color.gray, Color.pink, Color.gray, Color.black, Color.gray};
        screen[3] = new Color[] {Color.gray, Color.pink, Color.black, Color.gray, Color.blue};

        screen = Recursion.paintFill(screen, new Point(0,1), Color.GREEN);

        if(screen != null) {

            for(int i=0; i<screen.length; i++) {
                System.out.println();
                for(int j=0; j<screen.length; j++) {
                    System.out.print(screen[i][j]);
                }
            }
        }
        System.out.println();

        Recursion.getNumberOfWays();
        Recursion.getWaysOfArrangeQueens(8);

        ExpressionTreeNode<Character> root =
                ExpressionTree.createExpressionTreeUsingPostfix("359+2*+");

        ExpressionTree.evaluateExpressionTree(root);

        ExpressionTree.printInfixToPostfix("3+((5+9)*2)");

        //ExpressionTree.infixToPrefix("+3*2+59");
        ExpressionTree.infixToPrefix("3+((5+9)*2)");
    }
}
