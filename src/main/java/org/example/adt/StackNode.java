package org.example.adt;

/*
    Esta clase busca establecer las pilas dinamicas como nodos, para despues implementarlo en la clase de QueueOfStack,
    implementando sus "getters" y "setters"
 */

public class StackNode {

    private DynamicStack value; // declaro la pila como valor de nodo
    private StackNode next; // declaro un next para aclarar cual va a ser su siguiente nodo

    public StackNode(DynamicStack value, StackNode next){ // inicializacion del nodo
        this.value = value;
        this.next = next;
    }

    // Getters and Setters

    public DynamicStack getValue() {
        return value;
    }

    public void setValue(DynamicStack value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
