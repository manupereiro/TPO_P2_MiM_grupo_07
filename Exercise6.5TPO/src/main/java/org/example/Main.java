package org.example;

import org.example.adt.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Agrega nodos al grafo
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        // Agrega aristas con sus probabilidades al grafo
        graph.addEdge(1, 2, 0.5);
        graph.addEdge(2, 3, 0.8);
        graph.addEdge(3, 4, 0.3);
        graph.addEdge(2, 1, 0.2);
        graph.addEdge(2, 2, 0.1);
        //graph.addEdge(2, 2, 1); este daria error

        // Imprime el grafo por pantalla
        graph.printGraph();

        // Realiza otras operaciones con el grafo si es necesario
    }
}