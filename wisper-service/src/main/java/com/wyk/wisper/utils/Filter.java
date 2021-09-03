package com.wyk.wisper.utils;

/**
 * Filter Interface
 *
 * @author elt
 */
@FunctionalInterface
public interface Filter<T> {
    /**
     * Judge whether or not accept the value.
     *
     * @param value the value to filter
     * @return a {@code true} value if the value has been accepted.
     * otherwise returns a {@code false} value
     */
    boolean accept(T value);
}
