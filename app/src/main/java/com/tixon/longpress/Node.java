package com.tixon.longpress;

public class Node {
    private Node left, right;
    String value;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
