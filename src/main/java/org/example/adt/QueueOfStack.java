package org.example.adt;

/*
    Esta es la clase de QueueOfSatck, la cual va a utilizar como nodos las pilas dinamincas de la clase StackNode
 */

public class QueueOfStack implements IQueueOfStack {

    private StackNode first; // establezco un primer elemento como StackNode

    @Override
    public void add(DynamicStack stack) {
        StackNode node = new StackNode(stack,null);
        if (this.first == null){
            this.first = node;
            return;
        }

        StackNode candidate = this.first;
        while (candidate.getNext() != null){
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if (this.first == null){
            System.out.println("Error - La cola esta vacia");
            return;
        }
        this.first = this.first.getNext(); // pongo el primero como el siguiente
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public DynamicStack getFisrt() {
        if (this.first == null){
            System.out.println("No se puede obtener el primero de una cola vacia");
            return null;
        }
        return this.first.getValue(); // devuelvo la primera pila
    }

    @Override
    public int len(){
        StackNode aux = this.first;
        int len = 0;
        while (aux != null){
            len++;
            aux = aux.getNext();
        }
        return len;
    }
}
