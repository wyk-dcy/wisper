package com.wyk.wisper.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate Utility
 *
 * @author elt
 */
public final class Predicates {
    public static final class ByType<E> implements Predicate<E> {
        private final Class<? extends E> allowedType;

        public ByType(Class<? extends E> allowedType) {
            this.allowedType = allowedType;
        }

        @Override
        public boolean test(E t) {
            return this.allowedType.isInstance(t);
        }
    }

    public static final class Not<E> implements Predicate<E> {
        private final Predicate<E> filter;

        public Not(Predicate<E> filter) {
            this.filter = filter;
        }

        @Override
        public boolean test(E t) {
            return !this.filter.test(t);
        }
    }

    public static final class AllowAll implements Predicate<Object> {
        public AllowAll() {
        }

        @Override
        public boolean test(Object t) {
            return true;
        }
    }

    public static class Disjunction<T> implements Predicate<T> {
        private final List<Predicate<T>> disjuncts = new ArrayList<>();

        public Disjunction() {
        }

        @Override
        public boolean test(T t) {
            Iterator<Predicate<T>> iterator = this.disjuncts.iterator();

            Predicate<T> each;
            do {
                if (!iterator.hasNext()) {
                    return false;
                }

                each = iterator.next();
            } while (!each.test(t));

            return true;
        }

        public void addFilter(Predicate<T> filter) {
            this.disjuncts.add(filter);
        }

        @Override
        public String toString() {
            return "[Or: " + this.disjuncts + "]";
        }
    }

}
