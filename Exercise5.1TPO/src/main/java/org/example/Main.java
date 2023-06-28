package org.example;

import org.example.adt.Set;
import org.example.adt.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add(4);
        stack.add(9);
        stack.add(7);
        stack.add(10);
        stack.add(5);
        stack.add(10);
        stack.add(8);
        stack.add(9);

        System.out.println("La pila original es:");
        stack.printstack();
        Stack ordenada = EliminaryOrdenarPila(stack);
        System.out.println("La pila ordenada queda: ");
        ordenada.printstack();



    }
    public static Stack EliminaryOrdenarPila(Stack pila) {
        Set conjunto = new Set();  // O(1)
        Stack pilaOrdenada = new Stack();  // O(1)
        while (!pila.isEmpty()) {  // O(N)
            conjunto.add(pila.getTop());  // O(1)
            pila.remove();  // O(1)
        }
        int num = conjunto.getLength();  // O(1)
        for (int i = 0; i < num; i++) {  // O(num)
            int aux = conjunto.choose();  // O(1)
            pilaOrdenada.add(aux);  // O(1)
            conjunto.remove(aux);  // O(1)
        }
        Stack pilaFinal = new Stack();  // O(1)
        while (!pilaOrdenada.isEmpty()) {  // O(M)
            int numero = pilaOrdenada.getTop();  // O(1)
            pilaOrdenada.remove();  // O(1)
            while (!pilaFinal.isEmpty() && pilaFinal.getTop() > numero) {  // O(M)
                pilaOrdenada.add(pilaFinal.getTop());  // O(1)
                pilaFinal.remove();  // O(1)
            }
            pilaFinal.add(numero);  // O(1)
        }
        return pilaFinal;  // O(1)
    }/*
    La complejidad computacional de la función es aproximadamente
    O(N + num + M^2), donde N es el número de elementos en la pila original,
     num es el tamaño del conjunto y M es el número de elementos en la pila ordenada.
     */
}