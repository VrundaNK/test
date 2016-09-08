package com.company.datastructures.expressionTree;

/**
 * Created by vnagpurkar on 7/17/16.
 */
public class ExpressionTreeNode<E> {

    private E data;
    private ExpressionTreeNode<E> left;
    private ExpressionTreeNode<E> right;

    public ExpressionTreeNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public ExpressionTreeNode<E> getLeft() {
        return left;
    }

    public ExpressionTreeNode<E> getRight() {
        return right;
    }

    public void setLeft(ExpressionTreeNode<E> left) {
        this.left = left;
    }

    public void setRight(ExpressionTreeNode<E> right) {
        this.right = right;
    }

    public boolean isLeaf() {

        return (this.left == null) && (this.right == null);
    }

}
