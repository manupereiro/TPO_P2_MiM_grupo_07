package org.example.adt;

import org.example.adt.ISet;
import java.util.Arrays;
import java.util.Random;

public class Set {

    private final int[] array;
    private int count;

    public Set() {
        this.array = new int[10000];
        this.count = 0;
    }


    public void add(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                return;
            }
        }

        this.array[this.count] = a;
        this.count++;
    }


    public void remove(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        if (count != set.count) return false;

        int[] array1Copy = Arrays.copyOf(array, array.length);
        int[] array2Copy = Arrays.copyOf(set.array, set.array.length);
        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        for (int i = 0; i < count; i++) {
            if (array1Copy[i] != array2Copy[i]) {
                return false;
            }
        }
        return true;
    }

    /*
    public void printSet() {
        if (isEmpty()) {
            System.out.println("Set is empty");
        } else {
            System.out.print("Set: ");
            for (int i = 0; i < count; i++) {
                System.out.print(array[i]);
                if (i != count - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

     */

    public void print() {
        System.out.print("{ ");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    public int getLength(){
        return count;
    }

}

