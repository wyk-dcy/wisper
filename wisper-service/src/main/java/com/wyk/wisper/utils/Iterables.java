package com.wyk.wisper.utils;

import javax.annotation.Nonnull;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Iterable Utility
 *
 * @author elt
 */
public final class Iterables {
    /**
     * Converts to iterable instance
     *
     * @param enumeration the enumeration to convert
     * @param <T>         the element type
     * @return iterable instance
     */
    public static <T> Iterable<T> toIterable(Enumeration<T> enumeration) {
        return new IterableWrapper(enumeration);
    }

    /**
     * Converts to iterable instance
     *
     * @param enumeration the enumeration to convert
     * @return iterable instance
     */
    public static Iterable<?> toUnknownTypeIterable(Enumeration<?> enumeration) {
        return new IterableWrapper(enumeration);
    }

    /**
     * Iterable Wrapper For Enumeration
     *
     * @author elt
     */
    static class IterableWrapper<T> implements Iterable<T> {
        private final Enumeration<T> enumeration;

        public IterableWrapper(Enumeration<T> enumeration) {
            this.enumeration = enumeration;
        }

        @Override
        @Nonnull
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return IterableWrapper.this.enumeration.hasMoreElements();
                }

                @Override
                public T next() {
                    return IterableWrapper.this.enumeration.nextElement();
                }

                @Override
                public void remove() {
                    throw new IllegalStateException("Enumerations do not support this function, therefore this Iterable which WRAPS one doesn't either!!!");
                }
            };
        }
    }
}
