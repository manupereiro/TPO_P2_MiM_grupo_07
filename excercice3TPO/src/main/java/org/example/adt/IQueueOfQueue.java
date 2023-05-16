package org.example.adt;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueueOfQueue {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void add(Queue a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    Queue getFirst();

    /**
     *
     * Postcondicion: La cola pasada como parametro no pierde sus elementos en ella (Inmutable)
     * @param qoq cola de colas a concatenar
     */
    void concatenate(QueueOfQueue qoq);

    /**
     * @return Devuelve una cola, con los elementos de las colas de la cola de colas.
     */
    Queue flat();

    /**
     * Postcondicion: Cola de colas pero con las colas en orden inverso al original, además de los elementos invertidos dentro de ellas.
     */
    void reverseWithDepth();

}
