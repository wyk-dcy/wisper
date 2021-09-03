package com.wyk.wisper.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Qingshan Qin
 */
public class Conjunction<T> implements Predicate<T> {
    private final List<Predicate<T>> conjuncts = new ArrayList<>();

    public Conjunction() {
    }

    @SafeVarargs
    public Conjunction(Predicate<T>... filters) {
        this.conjuncts.addAll(Arrays.asList(filters).subList(0, filters.length));
    }

    @Override
    public boolean test(T t) {
        Iterator<Predicate<T>> iterator = this.conjuncts.iterator();

        Predicate<T> each;
        do {
            if (!iterator.hasNext()) {
                return true;
            }

            each = iterator.next();
        } while (each.test(t));

        return false;
    }

    public void addFilter(Predicate<T> filter) {
        this.conjuncts.add(filter);
    }

    @Override
    public String toString() {
        return "[And: " + this.conjuncts + "]";
    }
}
