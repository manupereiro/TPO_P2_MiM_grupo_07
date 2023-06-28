package org.example;

import org.example.adt.ISetDuplicates;
import org.example.adt.SetDuplicates;

public class Main {
    public static void main(String[] args) {

        ISetDuplicates set = new SetDuplicates();

        set.add(1);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(4);

        set.remove(1);
        set.remove(1);
        set.remove(1);
        System.out.println(set.repeated(4));

    }
}