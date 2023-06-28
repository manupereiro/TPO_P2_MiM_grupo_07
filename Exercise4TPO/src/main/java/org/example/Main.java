package org.example;

import org.example.adt.ISet;
import org.example.adt.IStack;
import org.example.adt.Set;
import org.example.adt.Stack;

public class Main {
    public static void main(String[] args) {

        IStack stack = new Stack()
                .add(1)
                .add(2)
                .add(3);

        while (!stack.isEmpty()){
            System.out.println(stack.getTop());
            stack.remove();
        }

        ISet set = new Set()
                .add(1)
                .add(2)
                .add(3);

        ISet aux = new Set()
                .add(4);

        aux.addAll(set);

        while (!set.isEmpty()){
            int n = set.choose();
            System.out.println(n);
            set.remove(n);
        }
    }
}