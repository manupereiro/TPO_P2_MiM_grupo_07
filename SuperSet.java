package org.adt.core.adt.implementation.dynamic.TDAModified;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.Set;

public class SuperSet implements ISet {

    private ISet superconjunto;

    public SuperSet() {
        this.superconjunto = new Set();
    }

    @Override
    public void add(int a) {
        superconjunto.add(a);
    }

    @Override
    public void remove(int a) {
        superconjunto.remove(a);
    }

    @Override
    public boolean contains(int a) {
        return superconjunto.contains(a);
    }

    @Override
    public boolean isEmpty() {
        return superconjunto.isEmpty();
    }

    @Override
    public int choose() {
        return 0;
    }

    @Override
    public int size() {
        return superconjunto.size();
    }

    public boolean esSubconjunto(ISet subconjunto) {
        for (int value : subconjunto) {
            if (!superconjunto.contains(value)) {
                return false;
            }
        }
        return true;
    }

    public ISet calcularComplemento(ISet subconjunto) {
        if (!esSubconjunto(subconjunto)) {
            throw new IllegalArgumentException("El conjunto no es subconjunto del superconjunto.");
        }

        ISet complemento = new Set();
        for (int value : superconjunto) {
            if (!subconjunto.contains(value)) {
                complemento.add(value);
            }
        }
        return complemento;
    }
}
