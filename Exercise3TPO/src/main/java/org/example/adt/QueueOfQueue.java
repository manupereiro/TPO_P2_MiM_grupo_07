package org.example.adt;

public class QueueOfQueue implements IQueueOfQueue {

    private QueueOfQueueNode first;

    @Override
    public void add(Queue queue) {
        QueueOfQueueNode node = new QueueOfQueueNode(queue, null);
        if (this.first == null) {
            this.first = node;
            return;
        }
        QueueOfQueueNode candidate = this.first;
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
    public Queue getFirst() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return this.first.getValue();
    }

    @Override
    public void concatenate(QueueOfQueue qoq) {
        QueueOfQueue queueAux = new QueueOfQueue();

        while (!qoq.isEmpty()){
            this.add(qoq.getFirst());
            queueAux.add(qoq.getFirst());
            qoq.remove();
        }

        while (!queueAux.isEmpty()){
            qoq.add(queueAux.getFirst());
            queueAux.remove();
        }
    }

    @Override
    public Queue flat() {

        Queue queue = new Queue();

        while (!this.isEmpty()){
            Queue queueAux = this.getFirst();
            while (!queueAux.isEmpty()){
                queue.add(queueAux.getFirst());
                queueAux.remove();
            }
            this.remove();
        }
        return queue;
    }

    @Override
    public void reverseWithDepth() {

        if (this.isEmpty()) {
            return;
        }

        Queue queueAux = this.getFirst();
        queueAux.reverseQueue(); // metodo dentro de la clase Queue
        this.remove();
        this.reverseWithDepth();
        this.add(queueAux);
    }
}
