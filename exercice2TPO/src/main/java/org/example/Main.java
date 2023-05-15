package org.example;

import org.example.adt.Queue;
import org.example.adt.Stack;
import org.example.adt.Set;

public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.add("Bob");
        stack.add("Jane");
        stack.add("John");
        stack.add("Thomas");
        stack.add("Brandon");

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }

        Set<String> set = new Set<>();

        set.add("Bob");
        set.add("Jane");
        set.add("John");

        Set<String> setCopied = copy(set);

        while (!setCopied.isEmpty()){
            String value = setCopied.choose();
            System.out.println(value);
            setCopied.remove(value);
        }

    }

    // 1) Desarrolle una función que reciba un Stack genérico e invierta sus elementos.
    private static <T> void reverse(Stack<T> stack){

        Queue<T> queueAux = new Queue<>();

        while (!stack.isEmpty()){
            queueAux.add(stack.getTop());
            stack.remove();
        }

        while (!queueAux.isEmpty()){
            stack.add(queueAux.getFirst());
            queueAux.remove();
        }
    }

    // 2) Desarrolle una función que copie un Set genérico.
    private static <T> Set<T> copy(Set<T> set){

        Stack<T> stackAux = new Stack<>();
        Set<T> setCopy = new Set<>();
        while (!set.isEmpty()){
            T value = set.choose();
            stackAux.add(value);
            set.remove(value);
        }

        while (!stackAux.isEmpty()){
            set.add(stackAux.getTop());
            setCopy.add(stackAux.getTop());
            stackAux.remove();
        }

        return setCopy;
    }
}