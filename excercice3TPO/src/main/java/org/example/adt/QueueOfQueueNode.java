package org.example.adt;

import java.util.Objects;

public class QueueOfQueueNode {

    private Queue value;
    private QueueOfQueueNode next;

    public QueueOfQueueNode(Queue value, QueueOfQueueNode next) {
        this.value = value;
        this.next = next;
    }

    public Queue getValue() {
        return value;
    }

    public void setValue(Queue value) {
        this.value = value;
    }

    public QueueOfQueueNode getNext() {
        return next;
    }

    public void setNext(QueueOfQueueNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueOfQueueNode node = (QueueOfQueueNode) o;
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }
}
