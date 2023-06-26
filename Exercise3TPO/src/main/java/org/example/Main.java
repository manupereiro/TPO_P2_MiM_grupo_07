package org.example;

import org.example.adt.Queue;
import org.example.adt.QueueOfQueue;

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue();
        Queue queue1 = new Queue();
        Queue queue2 = new Queue();
        Queue queue3 = new Queue();
        Queue queue4 = new Queue();

        QueueOfQueue qoq = new QueueOfQueue();
        QueueOfQueue qoq1 = new QueueOfQueue();

        // Queue 0-2
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue1.add(4);
        queue1.add(5);
        queue1.add(6);
        queue2.add(7);
        queue2.add(8);
        queue2.add(9);

        // QueueOfQueue 1
        qoq.add(queue);
        qoq.add(queue1);
        qoq.add(queue2);

        // Queue 3-4
        queue3.add(10);
        queue3.add(11);
        queue3.add(12);
        queue4.add(13);
        queue4.add(14);
        queue4.add(15);

        // QueueOfQueue 2
        qoq1.add(queue3);
        qoq1.add(queue4);

        /*qoq.concatenate(qoq1);

        System.out.println("Cola de colas contenada: ");

        while (!qoq.isEmpty()){
            Queue queueAux = qoq.getFirst();
            while (!queueAux.isEmpty()){
                System.out.println(queueAux.getFirst());
                queueAux.remove();
            }
            qoq.remove();
        }*/

        /*Queue qoqFlat = qoq.flat();

        while (!qoqFlat.isEmpty()){
            System.out.println(qoqFlat.getFirst());
            qoqFlat.remove();
        }*/

        /*qoq.reverseWithDepth();

        while (!qoq.isEmpty()){
            Queue queueAux = qoq.getFirst();
            while (!queueAux.isEmpty()){
                System.out.println(queueAux.getFirst());
                queueAux.remove();
            }
            qoq.remove();
        }*/

    }
}