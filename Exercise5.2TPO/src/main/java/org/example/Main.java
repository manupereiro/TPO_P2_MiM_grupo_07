package org.example;

import org.example.adt.MonteCarlo;

public class Main {
    public static void main(String[] args) {
        MonteCarlo monteCarlo = new MonteCarlo();
        System.out.println(monteCarlo.approx());
    }
}