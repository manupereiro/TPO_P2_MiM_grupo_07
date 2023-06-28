package org.example.adt;

import java.util.Random;

public class SetDuplicates implements ISetDuplicates{
    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null,1);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            this.first.setCountTimes(this.first.getCountTimes() + 1);
            return;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                candidate.setCountTimes(candidate.getCountTimes() + 1);
            }
        }
        candidate.setNext(new Node(a, null, 1));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                if (this.first.getCountTimes() > 1) {
                    this.first.setCountTimes(this.first.getCountTimes() - 1);
                } else {
                    this.first = null;
                    this.count--;
                }
            }
            return;
        }

        if (this.first.getValue() == a) {
            if (this.first.getCountTimes() > 1) {
                this.first.setCountTimes(this.first.getCountTimes() - 1);
            } else {
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        Node backup = this.first;
        Node candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                if (candidate.getCountTimes() > 1) {
                    candidate.setCountTimes(candidate.getCountTimes() - 1);
                } else {
                    backup.setNext(candidate.getNext());
                    this.count--;
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }

    @Override
    public int repeated(int value){

        Node candidate = this.first;
        if (candidate.getValue() == value){
            return candidate.getCountTimes();
        }
        while (candidate.getNext() != null && candidate.getValue() != value) {
            candidate = candidate.getNext();
            if (candidate.getValue() == value) {
                return candidate.getCountTimes();
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetDuplicates set = (SetDuplicates) o;
        if (count != set.count) {
            return false;
        }

        Node aux = this.first;
        while (aux != null) {
            if (!exists(aux.getValue(), set.first)) {
                return false;
            }
            aux = aux.getNext();
        }

        return true;
    }

    private boolean exists(int value, Node node) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return exists(value, node.getNext());
    }
}
