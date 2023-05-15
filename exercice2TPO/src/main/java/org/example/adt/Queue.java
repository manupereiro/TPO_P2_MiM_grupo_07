package org.example.adt;

public class Queue<T> implements IQueue<T>{

    private Node<T> first;

    @Override
    public void add(T a) {
        Node<T> node = new Node<T>(a, null);
        if (this.first == null) {
            this.first = node;
            return;
        }
        Node<T> candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getFirst() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return this.first.getValue();
    }
}
