package org.adt.core.adt.implementation.dynamic.TDAModified;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.dynamic.Queue;
import org.adt.core.adt.implementation.dynamic.node.Node;

public class CircularDoubleLinkedQueue implements IQueue {

    private Node first;
    private Node last;

    public CircularDoubleLinkedQueue() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(int a) {
        Node newNode = new Node(a);
        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            newNode.setPrevious(last);
            last.setNext(newNode);
            first.setPrevious(newNode);
            last = newNode;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            System.out.println("No se puede desacolar una cola vacía");
            return;
        }

        if (first == last) {
            first = null;
            last = null;
        } else {
            Node newFirst = first.getNext();
            newFirst.setPrevious(last);
            last.setNext(newFirst);
            first = newFirst;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            System.out.println("No se puede obtener el primero de una cola vacía");
            return -1;
        }
        return first.getValue();
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return;
        }

        System.out.println("Elementos de la cola:");
        Node current = first;
        do {
            System.out.println(current.getValue());
            current = current.getNext();
        } while (current != first);
    }

    @Override
    public int countElements() {
        int count = 0;
        if (!isEmpty()) {
            Node current = first;
            do {
                count++;
                current = current.getNext();
            } while (current != first);
        }
        return count;
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
    public boolean hasEvenNumberOfElements(IQueue queue) {
        return false;
    }

    @Override
    public void transferElements(Queue cola) {

    }

    @Override
    public void transferElements(org.adt.core.adt.implementation.normal.Queue cola) {

    }

    @Override
    public int sumElements() {
        int sum = 0;
        if (!isEmpty()) {
            Node current = first;
            do {
                sum += current.getValue();
                current = current.getNext();
            } while (current != first);
        }
        return sum;
    }

    @Override
    public int averageElement() {
        if (isEmpty()) {
            System.out.println("No se puede calcular el promedio de una cola vacía");
            return -1;
        }

        int sum = 0;
        int count = 0;
        Node current = first;
        do {
            sum += current.getValue();
            count++;
            current = current.getNext();
        } while (current != first);

        return sum / count;
    }
}

