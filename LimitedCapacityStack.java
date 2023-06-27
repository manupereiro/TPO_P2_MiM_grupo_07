package org.adt.core.adt.implementation.dynamic.TDAModified;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.dynamic.node.Node;

public class LimitedCapacityStack implements IStack {
    private Node top;
    private int capacity;
    private int size;

    public LimitedCapacityStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public void add(int value) {
        if (isFull()) {
            System.out.println("La pila ha alcanzado su capacidad máxima.");
            return;
        }

        Node newNode = new Node(value, top);
        top = newNode;
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }

        top = top.getNext();
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return -1;
        }

        return top.getValue();
    }

    @Override
    public int countElements() {
        return 0;
    }

    @Override
    public int SumElements() {
        return 0;
    }

    @Override
    public int PromElement() {
        return 0;
    }

    @Override
    public boolean hasEvenNumberOfElements(IStack stack) {
        return false;
    }

    @Override
    public void printStack() {

    }
    @Override
    public boolean isFull() {
        return size == capacity;
    }
    @Override
    public int getCapacity() {
        return capacity;
    }
    @Override
    public int getSize() {
        return size;
    }
}
