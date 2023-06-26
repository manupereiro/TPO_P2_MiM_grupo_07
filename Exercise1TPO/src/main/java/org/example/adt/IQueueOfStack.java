package org.example.adt;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueueOfStack {

    /**
     * Postcondicion: Acola (coloca en la primera posicion) una pila.
     * @param stack valor a acolar.
     */
    void add(DynamicStack stack);
    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer valor).
     */
    void remove();
    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();
    /**
     * @return Devuelve el primer elemento.
     */
    DynamicStack getFisrt();
    /**
     * @return Devuelve el tamaño de la cola.
     */
    int len();

}
