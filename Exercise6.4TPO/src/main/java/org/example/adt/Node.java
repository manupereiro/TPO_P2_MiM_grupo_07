package org.example.adt;

import java.util.Objects;

public class Node {
    private int value;
    private int countTimes;
    private Node next;

    public Node(int value, Node next, int countTimes) {
        this.value = value;
        this.next = next;
        this.countTimes = countTimes;
    }

    public int getCountTimes() {
        return countTimes;
    }

    public void setCountTimes(int countTimes) {
        this.countTimes = countTimes;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }
}
