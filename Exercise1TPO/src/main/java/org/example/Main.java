package org.example;

import org.example.adt.*;
public class Main {
    public static void main(String[] args) {

        QueueOfStack qos = new QueueOfStack();
        QueueOfStack qos1 = new QueueOfStack();
        DynamicStack s1 = new DynamicStack();
        DynamicStack s2 = new DynamicStack();
        DynamicStack s3 = new DynamicStack();
        DynamicStack s4 = new DynamicStack();
        DynamicStack s5 = new DynamicStack();
        DynamicStack s6 = new DynamicStack();

        // Stack 1
        s1.add(1);
        s1.add(4);
        s1.add(7);
        // Stack 2
        s2.add(2);
        s2.add(5);
        s2.add(8);
        // Stack 3
        s3.add(3);
        s3.add(6);
        s3.add(9);
        // Stack 4
        s4.add(1);
        s4.add(4);
        s4.add(7);
        // Stack 5
        s5.add(2);
        s5.add(5);
        s5.add(8);
        // Stack 6
        s6.add(3);
        s6.add(6);
        s6.add(9);


        // QueueOfStack 1
        qos.add(s1);
        qos.add(s2);
        qos.add(s3);
        // QueueOfStack 2
        qos1.add(s4);
        qos1.add(s5);
        qos1.add(s6);

        impression(matrixSum(qos,qos1));
        transposed(qos);
        System.out.println("Suma traza: " + trace(qos));


    }

    // 1) Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza.
    public static int trace(QueueOfStack qos){

        int i = 1; // posicion i-esima
        int trace = 0; // suma de la traza

        while (!qos.isEmpty()){
            DynamicStack stackAux = qos.getFisrt();
            int count = stackAux.len(); // declaramos el contador con el tamaño del stack
            while (!stackAux.isEmpty() && count >= i) {
                if (count == i){
                    System.out.println(stackAux.getTop());
                    trace += stackAux.getTop(); // suma la posicion i-esima
                    i++; // incremento la posicion de i-esima una vez encontrada la anterior
                }
                count--;
                stackAux.remove();
            }
            qos.remove();
        }

        return trace;
    }

    // 2) Desarrolle una función que reciba una instancia de QueueOfStacks, y devuelva su traspuesta.
    public static void transposed(QueueOfStack qos){

        DynamicStack stack = new DynamicStack();

        while (!qos.isEmpty()){
            DynamicStack stackAux = qos.getFisrt();
            while (!stackAux.isEmpty()){
                stack.add(stackAux.getTop());
                stackAux.remove();
            }
            stackImpresion(stack);
            System.out.println();
            qos.remove();
        }
    }

    public static void stackImpresion(DynamicStack stack){

        while (!stack.isEmpty()){
            System.out.print(stack.getTop() + "\t");
            stack.remove();
        }
    }

    // 3)
    public static QueueOfStack matrixSum(QueueOfStack qos, QueueOfStack qos1){

        QueueOfStack queueMatrixSum = new QueueOfStack();

        while (!qos.isEmpty()){
            DynamicStack stackQosAux = new DynamicStack();
            DynamicStack stackQos = qos.getFisrt();
            DynamicStack stackQos1 = qos1.getFisrt();
            while (!stackQos.isEmpty()){
                stackQosAux.add(stackQos.getTop()+stackQos1.getTop());
                stackQos.remove();
                stackQos1.remove();
            }
            queueMatrixSum.add(stackQosAux);
            qos.remove();
            qos1.remove();
        }
        return queueMatrixSum;
    }

    public static void impression(QueueOfStack qos){

        while (!qos.isEmpty()){
            DynamicStack stack = qos.getFisrt();
            while (!stack.isEmpty()){
                System.out.print(stack.getTop() + "\t");
                stack.remove();
            }
            System.out.println();
            qos.remove();
        }
    }
}