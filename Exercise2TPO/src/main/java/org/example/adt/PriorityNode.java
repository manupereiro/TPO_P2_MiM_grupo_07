package org.example.adt;

public class PriorityNode<T> {

    private T value;
    private int priority;
    private PriorityNode<T> next;

    public PriorityNode(T value, int priority, PriorityNode<T> next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityNode<T> getNext() {
        return next;
    }

    public void setNext(PriorityNode<T> next) {
        this.next = next;
    }
}
